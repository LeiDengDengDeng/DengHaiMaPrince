package src.presentation.sheetui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.sheetbl.Sheet;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.vo.SheetVO;

public class EarningsPanel extends JPanel {

	static final ImageIcon IMG_BG = new ImageIcon("images/earnings_BG.png");
	protected static final int x = 195;// panel λ��x
	protected static final int y = 70;// panel λ��y
	protected static final int w = 641;// panel��
	protected static final int h = 572;// panel��
	ArrayList<SheetVO> payment = new ArrayList<SheetVO>();
	ArrayList<SheetVO> reception = new ArrayList<SheetVO>();
	protected static final int font = 14;
	Font fontPercent = new Font("Myriad Pro", Font.LAYOUT_NO_LIMIT_CONTEXT, 24);
	SheetBLService sheet;
	double receptionAmount;
	double paymentAmount;
	double earning;
	int payPercent;
	int earningsPercent;

	public EarningsPanel(Sheet sheet) {
		this.sheet = sheet;
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		receptionAmount = 24980.99;
		paymentAmount = 20000;
		earning = receptionAmount - paymentAmount;
		payPercent = (int) (paymentAmount * 100 / receptionAmount);
		earningsPercent = 100 - payPercent;

	}

	// �����־�ݣ�RenderingHints.KEY_TEXT_ANTIALIASING
	// ����ͼ��ݣ�RenderingHints.KEY_ANTIALIASING
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g.create();// ���һ��Graphics2D����
		// ���ÿ��������
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Color c = new Color(27, 172, 182);
		g2.drawImage(IMG_BG.getImage(), 27, 32, null);
		g2.setColor(c);
		g2.setFont(fontPercent);
		g2.drawString(Integer.toString(payPercent) + "%", 465, 325);
		g2.drawString(Integer.toString(earningsPercent) + "%", 545, 325);
	}

	public static void main(String[] args) {
		int WIDTH = 850;
		int HEIGHT = 646;
		ImageIcon IMG = new ImageIcon("images/mainFrame.png");

		JFrame AccountFrame = new JFrame();
		EarningsPanel panel = new EarningsPanel(null);
		JPanel panelbg = new JPanel();
		// ���ñ���
		AccountFrame.setUndecorated(true);
		AccountFrame.setSize(850, 646);
		// �������û��ı䴰�ڴ�С
		AccountFrame.setResizable(false);
		// �����Ļ��С
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// ���ô���λ��
		int x = (screen.width - WIDTH) >> 1;
		int y = ((screen.height - HEIGHT) >> 1) - 32;

		AccountFrame.setLocation(x, y);
		// ����Ĭ��panel
		panelbg.setLayout(null);
		JLabel bg = new JLabel(IMG);
		bg.setBounds(0, 0, WIDTH, HEIGHT);

		panelbg.add(panel);
		AccountFrame.setContentPane(panelbg);
		AccountFrame.getContentPane().add(bg);
		AccountFrame.setVisible(true);

	}

}
