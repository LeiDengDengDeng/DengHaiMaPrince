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
		// ����AWTUtilities��setWindowShape�����趨������Ϊ�ƶ���Shape��״
		AWTUtilities.setWindowShape(frame,
				frame.getImageShape(backgroundImage.getImage()));
		// �趨����ɼ���
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
		int width = img.getWidth(null);// ͼ����
		int height = img.getHeight(null);// ͼ��߶�

		// ɸѡ����
		// ���Ȼ�ȡͼ�����е�������Ϣ
		PixelGrabber pgr = new PixelGrabber(img, 0, 0, -1, -1, true);
		try {
			pgr.grabPixels();
		} catch (InterruptedException ex) {
			ex.getStackTrace();
		}
		int pixels[] = (int[]) pgr.getPixels();

		// ѭ������
		for (int i = 0; i < pixels.length; i++) {
			// ɸѡ������͸�������ص�������뵽����ArrayList x��y��
			int alpha = getAlpha(pixels[i]);
			if (alpha == 0) {
				continue;
			} else {
				x.add(i % width > 0 ? i % width - 1 : 0);
				y.add(i % width == 0 ? (i == 0 ? 0 : i / width - 1) : i / width);
			}
		}

		// ����ͼ����󲢳�ʼ��(0Ϊ͸��,1Ϊ��͸��)
		int[][] matrix = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = 0;
			}
		}

		// ��������ArrayList�еĲ�͸��������Ϣ
		for (int c = 0; c < x.size(); c++) {
			matrix[y.get(c)][x.get(c)] = 1;
		}

		/*
		 * ����Area������ʾ������Խ��кϲ���������һˮƽ"ɨ��"ͼ������ÿһ�У�
		 * ����͸������������ΪRectangle���ٽ�ÿһ�е�Rectangleͨ��Area���rec
		 * ������кϲ�������γ�һ��������Shapeͼ��
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
	 * ��ȡ���ص�Alphaֵ
	 * 
	 * @param pixel
	 * @return ���ص�Alphaֵ
	 */
	private int getAlpha(int pixel) {
		// System.out.println("pixel:"+pixel);
		// System.out.println("alpha:"+((pixel >> 24) & 0xff));
		return (pixel >> 24) & 0xff;
	}

}
