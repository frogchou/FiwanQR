package com.fiwan.qrgenerator;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 生成器窗体类
 * @version v.1.0
 * @author  frogchou
 */
@SuppressWarnings("serial")
public class GeneratorForm extends javax.swing.JFrame {
	Settings setting = Settings.getInstance();
	Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
	Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
	int screenWidth = screenSize.width; //获取屏幕的宽
	int screenHeight = screenSize.height; //获取屏幕的高
	public GeneratorForm() {
		initComponents();
		this.setResizable(false);
		this.settextArea();
		jButton3.setEnabled(false);
		int windowWidth = this.getWidth(); //获得窗口宽
		int windowHeight = this.getHeight(); //获得窗口高
		this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2
				- windowHeight / 2);//设置窗口居中显示
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox2 = new javax.swing.JComboBox();
		jComboBox3 = new javax.swing.JComboBox();
		jComboBox4 = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u98de\u7f51\u4e8c\u7ef4\u7801\u751f\u6210\u5668");
		setBounds(new java.awt.Rectangle(0, 0, 0, 0));

		jLabel1.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel1Layout.createSequentialGroup().add(jLabel1,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel1Layout.createSequentialGroup().add(jLabel1,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		jButton2.setText("\u590d\u5236");
		jButton2.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton2MouseClicked(evt);
			}
		});

		jButton1.setText("\u6253\u5f00");
		jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton3.setText("\u4fdd\u5b58\u4e8c\u7ef4\u7801");
		jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton3MouseClicked(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								org.jdesktop.layout.GroupLayout.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.add(
												jButton3,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												200, Short.MAX_VALUE)
										.add(18, 18, 18)
										.add(
												jButton2,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												59,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jButton1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												59,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel3Layout.createParallelGroup(
						org.jdesktop.layout.GroupLayout.BASELINE).add(jButton1,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(
						jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
						59, Short.MAX_VALUE)).add(jButton3,
				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 59,
				Short.MAX_VALUE));

		jLabel2.setText("\u989c\u8272");

		jLabel3.setText("\u5927\u5c0f");

		jLabel4.setText("\u683c\u5f0f");

		jLabel5.setText("\u5bb9\u9519\u7387");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"彩色", "黑白" }));
		jComboBox1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox1ItemStateChanged(evt);
			}
		});

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"200px", "400px", "600px", "800px" }));
		jComboBox2.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox2ItemStateChanged(evt);
			}
		});

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"png", "jpg", "bmp", "gif" }));
		jComboBox3.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox3ItemStateChanged(evt);
			}
		});

		jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"30%", "25%", "15%", "7%" }));
		jComboBox4.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox4ItemStateChanged(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel4Layout
										.createSequentialGroup()
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.add(
																				jPanel4Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								jLabel4)
																						.add(
																								jLabel5))
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED))
														.add(
																jPanel4Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.add(
																				jPanel4Layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.TRAILING)
																						.add(
																								jLabel2)
																						.add(
																								jLabel3))
																		.add(
																				18,
																				18,
																				18)))
										.add(
												jPanel4Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING,
																false)
														.add(jComboBox4, 0, 67,
																Short.MAX_VALUE)
														.add(jComboBox1, 0, 67,
																Short.MAX_VALUE)
														.add(jComboBox3, 0, 67,
																Short.MAX_VALUE)
														.add(jComboBox2, 0, 67,
																Short.MAX_VALUE))
										.addContainerGap(13, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel4Layout.createSequentialGroup().add(30, 30, 30).add(
						jPanel4Layout.createParallelGroup(
								org.jdesktop.layout.GroupLayout.BASELINE).add(
								jComboBox1,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jLabel2)).addPreferredGap(
						org.jdesktop.layout.LayoutStyle.RELATED).add(
						jPanel4Layout.createParallelGroup(
								org.jdesktop.layout.GroupLayout.BASELINE).add(
								jComboBox2,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jLabel3)).addPreferredGap(
						org.jdesktop.layout.LayoutStyle.RELATED).add(
						jPanel4Layout.createParallelGroup(
								org.jdesktop.layout.GroupLayout.BASELINE).add(
								jComboBox3,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jLabel4)).addPreferredGap(
						org.jdesktop.layout.LayoutStyle.UNRELATED).add(
						jPanel4Layout.createParallelGroup(
								org.jdesktop.layout.GroupLayout.BASELINE).add(
								jComboBox4,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(jLabel5)).addContainerGap(41,
						Short.MAX_VALUE)));

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextArea1KeyReleased(evt);
			}
		});
		jScrollPane1.setViewportView(jTextArea1);

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING,
																false)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				jPanel1,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				202,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.RELATED)
																		.add(
																				jPanel4,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
														.add(
																layout
																		.createParallelGroup(
																				org.jdesktop.layout.GroupLayout.TRAILING)
																		.add(
																				jPanel3,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.add(
																				org.jdesktop.layout.GroupLayout.LEADING,
																				jScrollPane1,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				341,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																jPanel1,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																202,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(
																jPanel4,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED)
										.add(
												jPanel3,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.add(11, 11, 11)
										.add(
												jScrollPane1,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												125,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		getAccessibleContext().setAccessibleName(
				"\u4e8c\u7ef4\u7801\u751f\u6210\u5668");

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
		String str = jTextArea1.getText();
		if (str == null || "".equals(str)) {
		} else {
			try {
				Utils
						.setImageClipboard(getQRimage(str, setting
								.getQrcodeSize()));
			} catch (WriterException e) {
				e.printStackTrace();
			}

		}
		new Dialog1("已经将图片复制到粘贴板了。").jd.setVisible(true);
	}

	private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {
		switch (jComboBox4.getSelectedIndex()) {
		case 0:
			setting.setQrcodeErrorRate(ErrorCorrectionLevel.H);
			break;
		case 1:
			setting.setQrcodeErrorRate(ErrorCorrectionLevel.Q);
			break;
		case 2:
			setting.setQrcodeErrorRate(ErrorCorrectionLevel.M);
			break;
		case 3:
			setting.setQrcodeErrorRate(ErrorCorrectionLevel.L);
			break;
		}
		try {
			this.crateQRcode();
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}

	private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {
		switch (jComboBox3.getSelectedIndex()) {
		case 0:
			setting.setQrcodeFiletype(jComboBox3.getSelectedItem().toString());
			break;
		case 1:
			setting.setQrcodeFiletype(jComboBox3.getSelectedItem().toString());
			break;
		case 2:
			setting.setQrcodeFiletype(jComboBox3.getSelectedItem().toString());
			break;
		case 3:
			setting.setQrcodeFiletype(jComboBox3.getSelectedItem().toString());
			break;
		}
		try {
			this.crateQRcode();
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}

	private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {
		switch (jComboBox2.getSelectedIndex()) {
		case 0:
			setting.setQrcodeSize(200);
			break;
		case 1:
			setting.setQrcodeSize(400);
			break;
		case 2:
			setting.setQrcodeSize(600);
			break;
		case 3:
			setting.setQrcodeSize(800);
			break;
		}
		try {
			this.crateQRcode();
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}

	private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
		setting.setQrcodeColor(jComboBox1.getSelectedIndex());
		try {
			this.crateQRcode();
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将生成的图片保存到本地
	 * */
	private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
		if(((JButton)evt.getSource()).isEnabled()){  // 判断按钮当前状态，不可用时，事件不执行
		String filename = "FiwanQR"+System.currentTimeMillis();
		String filepath = Utils.CreateFile(setting.getQrcodeFiletype(),
				filename);
		File file = new File(filepath);
		try {
			if (setting.getQrcodeColor() == 0) {
				ZxingHandler.writeToFileWithColor(GetBitMatrix(jTextArea1
						.getText(), setting.getQrcodeSize()), setting
						.getQrcodeFiletype(), file);
			}
			if (setting.getQrcodeColor() == 1) {
				ZxingHandler.writeToFile(GetBitMatrix(jTextArea1.getText(),
						setting.getQrcodeSize()), setting.getQrcodeFiletype(),
						file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		}
		new Dialog1("已经保存到本地，请点击打开按钮查看。").jd.setVisible(true);
		}
	}

	private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {
		try {
			this.crateQRcode();
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
		try {
			Runtime.getRuntime().exec("explorer.exe " + Utils.getCurrentPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GeneratorForm().setVisible(true);
			}
		});
	}

	private void settextArea() {
		jTextArea1.setLineWrap(true); //激活自动换行功能 
		jTextArea1.setWrapStyleWord(true); // 激活断行不断字功能
	}

	public void crateQRcode() throws WriterException {
		String str = jTextArea1.getText();
		if (str == null || "".equals(str)) {
			jLabel1.setIcon(null);
			jButton3.setEnabled(false);
		} else {
			ImageIcon ii = new ImageIcon(getQRimage(str, setting
					.getQrcodeSize()));
			ii.setImage(ii.getImage().getScaledInstance(200, 200,
					Image.SCALE_DEFAULT));
			jLabel1.setIcon(ii);
			jButton3.setEnabled(true);
		}
	}

	public BitMatrix GetBitMatrix(String content, int size)
			throws WriterException {
		size = (size <= 0) ? 100 : size;
		BitMatrix bitMatrix = null;
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MARGIN, 1); //控制码图白边
		hints
				.put(EncodeHintType.ERROR_CORRECTION, setting
						.getQrcodeErrorRate()); //容错率
		bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE,
				size, size, hints);
		return bitMatrix;
	}

	private BufferedImage getQRimage(String content, int size)
			throws WriterException {
		size = (size <= 0) ? 100 : size;
		BufferedImage image = null;
		//BufferedImage image=  ZxingHandler.toBufferedImage( GetBitMatrix(content,size)); 
		if (setting.getQrcodeColor() == 0) {
			image = ZxingHandler.toBufferedImageWithColor(GetBitMatrix(content,
					size)); // 生成彩色
		}
		if (setting.getQrcodeColor() == 1) {
			image = ZxingHandler.toBufferedImage(GetBitMatrix(content, size)); // 生成黑白
		}
		return image;
	}

	class Dialog1 {
		JDialog jd = new JDialog();
		Dialog1(String msg) {
			jd.setSize(300, 160);
			jd.setTitle("提示");
			Container c2 = jd.getContentPane();
			c2.setLayout(null);
			jd.setLocation(screenWidth / 2 - jd.getWidth() / 2, screenHeight
					/ 2 - jd.getHeight() / 2);
			JLabel jl = new JLabel(msg);
			jl.setBounds(20, -20, 250, 100);
			JButton jbb = new JButton("确定");
			jbb.setBounds(100, 70, 60, 30);
			c2.add(jl);
			c2.add(jbb);
			jbb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jd.dispose();
				}
			});
			jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	// End of variables declaration//GEN-END:variables
}