package src.presentation.loginui;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.PixelGrabber;
import java.util.ArrayList;

public class LogInFrame extends JFrame {
	private static final ImageIcon backgroundImage = new ImageIcon(
			"images/logIn_BG.png");

	public LogInFrame() {

	}
	
	public static void main(String[] args) {
		LogInFrame frame = new LogInFrame();
		LogInPanel panel = new LogInPanel(frame);
		frame.setSize(panel.getWidth(), panel.getHeight());
		frame.setLocationRelativeTo(null);
		frame.setContentPane(panel);
		frame.setUndecorated(true);
		// 调用AWTUtilities的setWindowShape方法设定本窗体为制定的Shape形状
		AWTUtilities.setWindowShape(frame,
				frame.getImageShape(backgroundImage.getImage()));
		// 设定窗体可见度
		AWTUtilities.setWindowOpacity(frame, 1.0f);
		frame.setVisible(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - panel.getWidth()) >> 1;
		int y = ((screen.height - 640) >> 1) - 32;
		frame.setLayout(null);
		frame.setLocation(x, y);


	}

	public Shape getImageShape(Image img) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		int width = img.getWidth(null);// 图像宽度
		int height = img.getHeight(null);// 图像高度

		// 筛选像素
		// 首先获取图像所有的像素信息
		PixelGrabber pgr = new PixelGrabber(img, 0, 0, -1, -1, true);
		try {
			pgr.grabPixels();
		} catch (InterruptedException ex) {
			ex.getStackTrace();
		}
		int pixels[] = (int[]) pgr.getPixels();

		// 循环像素
		for (int i = 0; i < pixels.length; i++) {
			// 筛选，将不透明的像素的坐标加入到坐标ArrayList x和y中
			int alpha = getAlpha(pixels[i]);
			if (alpha == 0) {
				continue;
			} else {
				x.add(i % width > 0 ? i % width - 1 : 0);
				y.add(i % width == 0 ? (i == 0 ? 0 : i / width - 1) : i / width);
			}
		}

		// 建立图像矩阵并初始化(0为透明,1为不透明)
		int[][] matrix = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = 0;
			}
		}

		// 导入坐标ArrayList中的不透明坐标信息
		for (int c = 0; c < x.size(); c++) {
			matrix[y.get(c)][x.get(c)] = 1;
		}

		/*
		 * 由于Area类所表示区域可以进行合并，我们逐一水平"扫描"图像矩阵的每一行，
		 * 将不透明的像素生成为Rectangle，再将每一行的Rectangle通过Area类的rec
		 * 对象进行合并，最后形成一个完整的Shape图形
		 */
		Area rec = new Area();
		int temp = 0;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == 1) {
					if (temp == 0)
						temp = j;
					else if (j == width) {
						if (temp == 0) {
							Rectangle rectemp = new Rectangle(j, i, 1, 1);
							rec.add(new Area(rectemp));
						} else {
							Rectangle rectemp = new Rectangle(temp, i,
									j - temp, 1);
							rec.add(new Area(rectemp));
							temp = 0;
						}
					}
				} else {
					if (temp != 0) {
						Rectangle rectemp = new Rectangle(temp, i, j - temp, 1);
						rec.add(new Area(rectemp));
						temp = 0;
					}
				}
			}
			temp = 0;
		}
		return rec;
	}

	/**
	 * 获取像素的Alpha值
	 * 
	 * @param pixel
	 * @return 像素的Alpha值
	 */
	private int getAlpha(int pixel) {
		// System.out.println("pixel:"+pixel);
		// System.out.println("alpha:"+((pixel >> 24) & 0xff));
		return (pixel >> 24) & 0xff;
	}

}
