package src.presentation.sheetui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import src.businesslogicservice.sheetblservice.SheetBLService;

public class ReceivingGoodsSheetPanel extends SheetPanel {
	 ArrayList<JTextField> courierNumber;
	 ArrayList<JComboBox> depature;
	 ArrayList<JComboBox> destination;
	 ArrayList<JComboBox> start;

	SubPanel subPanel;
	
	JLabel imageLabel;
	ImageIcon bkgImg;

	public ReceivingGoodsSheetPanel(SheetBLService receivingGoodsBL) {
		init();
	}

	private void init() {
		subPanel = new SubPanel();
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/sheet_receivingGoods.png");

		subPanel.setBounds(104, 141, 435, 300);
		
		imageLabel.setIcon(bkgImg);
		imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

		this.setLayout(null);
		this.setOpaque(false);
		
		this.setBounds(200, 50, 665, 601);
		this.add(subPanel);
		this.add(imageLabel);
	}

	@Override
	public boolean confirm() {
		// TODO �Զ����ɵķ������
		return false;
	}

	public static void main(String[] args) {
		int WIDTH = 850;
		int HEIGHT = 646;
		ImageIcon IMG = new ImageIcon("images/mainFrame.png");

		JFrame frame = new JFrame();
		ReceivingGoodsSheetPanel panel = new ReceivingGoodsSheetPanel(null);
		JPanel panelbg = new JPanel();
		// ���ñ���
		frame.setUndecorated(true);
		frame.setSize(850, 646);
		// �������û��ı䴰�ڴ�С
		frame.setResizable(false);
		// �����Ļ��С
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// ���ô���λ��
		int x = (screen.width - WIDTH) >> 1;
		int y = ((screen.height - HEIGHT) >> 1) - 32;

		frame.setLocation(x, y);
		// ����Ĭ��panel
		panelbg.setLayout(null);
		JLabel bg = new JLabel(IMG);
		bg.setBounds(0, 0, WIDTH, HEIGHT);

		panelbg.add(panel);
		frame.setContentPane(panelbg);
		frame.getContentPane().add(bg);
		frame.setVisible(true);
	}

	class SubPanel extends JScrollPane {

		JPanel panel;
		GridLayout layout;

		public SubPanel() {
			init();
		}

		private void init() {
			layout = new GridLayout(0, 4, 2, 2);
			panel = new JPanel();
			panel.setBackground(Color.BLACK);

//			panel.setLayout(layout);
//			// ��ʼ����ʾ����
//			for (int i = 0; i < 5; i++)
//				addLine();

			this.setViewportView(panel);
			this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		}

		public void addLine() {
		
		}
		
	}
}
