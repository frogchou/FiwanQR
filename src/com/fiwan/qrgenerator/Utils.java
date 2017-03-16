package com.fiwan.qrgenerator;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

/**
 * @author frogchou
 * @version 1.1
 * ��������һЩ���õķ���
 * */
public class Utils {
	
	/**
	 * ���س���ǰ����ŵ�·����ʹ��user.dir
	 * @return String ����ǰ����ŵ�·��
	 * */
	public static String getCurrentPath() {
		return System.getProperty("user.dir")+File.separator+"images";
	}

	/**
	 * ����һ���ļ����������ļ���·��
	 * @param filetype �ļ����ͣ���׺��
	 * @param filename �ļ���
	 * @return String �����ļ���·��
	 * */
	public static String CreateFile(String filetype, String filename) {
		File file = null;
		try {
			File filepath = new File(getCurrentPath());
			if (!filepath.exists())
				filepath.mkdirs();
			file = new File(filepath + File.separator + filename + "."
					+ filetype);
			if (!file.exists())
				file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.getAbsolutePath();
	}

	/**
	 * ��ת���ͼƬ��Դ���õ����а���
	 * 
	 * @param image
	 *            ������image ������BufferedImage����
	 */
	// �����а�����ͼƬ������
	public static void setImageClipboard(Image image) {
		Images imgSel = new Images(image);
		// ����
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgSel,
				null);
	}

	public static class Images implements Transferable {
		private Image image; // �õ�ͼƬ����ͼƬ��

		public Images(Image image) {
			this.image = image;
		}

		public DataFlavor[] getTransferDataFlavors() {
			return new DataFlavor[] { DataFlavor.imageFlavor };
		}

		public boolean isDataFlavorSupported(DataFlavor flavor) {
			return DataFlavor.imageFlavor.equals(flavor);
		}

		public Object getTransferData(DataFlavor flavor)
				throws UnsupportedFlavorException, IOException {
			if (!DataFlavor.imageFlavor.equals(flavor)) {
				throw new UnsupportedFlavorException(flavor);
			}
			return image;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentPath());
	}
}
