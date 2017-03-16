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
 * 工具类存放一些常用的方法
 * */
public class Utils {
	
	/**
	 * 返回程序当前被存放的路径，使用user.dir
	 * @return String 程序当前被存放的路径
	 * */
	public static String getCurrentPath() {
		return System.getProperty("user.dir")+File.separator+"images";
	}

	/**
	 * 创建一个文件，并返回文件的路径
	 * @param filetype 文件类型（后缀）
	 * @param filename 文件名
	 * @return String 返回文件的路径
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
	 * 把转入的图片资源设置到剪切板上
	 * 
	 * @param image
	 *            可以是image 或者是BufferedImage类型
	 */
	// 给剪切板设置图片型内容
	public static void setImageClipboard(Image image) {
		Images imgSel = new Images(image);
		// 设置
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgSel,
				null);
	}

	public static class Images implements Transferable {
		private Image image; // 得到图片或者图片流

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
