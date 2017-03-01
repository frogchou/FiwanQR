package com.fiwan.qrgenerator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import com.google.zxing.common.BitMatrix;

/**
 * @version v1.0
 * @author frogchou
 * Zxing��һ�������࣬������չZxing��һЩ���ܡ�
 * */
public class ZxingHandler {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	/**
	 * ����һ����ɫ��λ�� BufferedImage
	 * @param matrix ����һ�����е�BitMatrix ��������������Ѿ������һ����ά��
	 * @return BufferedImage ���һ�����������BufferedImage
	 * */
	public static BufferedImage toBufferedImageWithColor(BitMatrix matrix) {
		int H = matrix.getHeight();
		int W = matrix.getWidth();
		int L = getFinderParttenWidth(matrix) + 3;  //��ȡ��λ���߳�
		int[] pixels = new int[W * H];
		Color redColor = new Color(182, 0, 5);
		int redColorInt = redColor.getRGB();
		Color greenColor = new Color(0, 124, 54);
		int greenColorInt = greenColor.getRGB();
		Color blueColor = new Color(0, 64, 152);
		int blueColorInt = blueColor.getRGB();
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				// ���Ҷ�λ���������ɲ�ɫ�ġ�
				if (x > 0 && x < L && y > 0 && y < L) {
					pixels[y * W + x] = matrix.get(x, y) ? redColorInt : WHITE;
				} else if (x > (W - L) && x < H && y > 0 && y < L) {
					pixels[y * W + x] = matrix.get(x, y) ? blueColorInt : WHITE;
				} else if (x > 0 && x < L && y > (H - L) && y < H) {
					pixels[y * W + x] = matrix.get(x, y) ? greenColorInt
							: WHITE;
				} else {
					pixels[y * W + x] = matrix.get(x, y) ? BLACK : WHITE;
				}
			}
		}
		BufferedImage image = new BufferedImage(W, H,
				BufferedImage.TYPE_INT_RGB);
		image.getRaster().setDataElements(0, 0, W, H, pixels);
		return image;
	}

	/**
	 * ����һ���ڰ׵� BufferedImage
	 * @param matrix ����һ�����е�BitMatrix ��������������Ѿ������һ����ά��
	 * @return BufferedImage ���һ�����������BufferedImage
	 * */
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	/**
	 * ���ڰ׶�ά��ͼƬ�����һ��ָ�����ļ���
	 * @param matrix ����һ�����е�BitMatrix ��������������Ѿ������һ����ά��
	 * @param format �ļ����� ������ͼƬ�ļ�����
	 * @param file ָ�������Ŀ���ļ�
	 * */
	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format "
					+ format + " to " + file);
		}
	}

	/**
	 * ����ɫ��ά��ͼƬ�����һ��ָ�����ļ���
	 * @param matrix ����һ�����е�BitMatrix ��������������Ѿ������һ����ά��
	 * @param format �ļ����� ������ͼƬ�ļ�����
	 * @param file ָ�������Ŀ���ļ�
	 * */
	public static void writeToFileWithColor(BitMatrix matrix, String format,
			File file) throws IOException {
		BufferedImage image = toBufferedImageWithColor(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format "
					+ format + " to " + file);
		}
	}

	/**
	 *���ڰ׶�ά��ͼƬ �ŵ�һ���������
	 * @param matrix ����һ�����е�BitMatrix ��������������Ѿ������һ����ά��
	 * @param format �ļ����� ������ͼƬ�ļ�����
	 * @param stream ָ�������
	 * */
	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format "
					+ format);
		}
	}

	/**
	 * ���Ҳ�ɫ��λ��
	 * */
	private static int getFinderParttenWidth(BitMatrix matrix) {
		int W = matrix.getWidth();
		int H = matrix.getHeight();
		int length = 0;
		boolean flag = false;
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				if (matrix.get(x, y) == true) {
					flag = true;
					length++;
				} else {
					if (flag != false) {
						return x;
					}
				}
			}
		}
		return length;
	}
}