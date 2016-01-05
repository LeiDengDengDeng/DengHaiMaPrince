package src.presentation.nonuserui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.commodityblservice.LogisticBLService;
import src.presentation.sheetui.TextFieldGroup;
import src.presentation.util.MyLabel;
import src.presentation.util.RButton;
import src.presentation.util.SearchButton;
import src.presentation.util.TipDialog;

public class logisticsInfoPanel extends JPanel {
	protected static final int x = 240;// panel 位置x
	protected static final int y = 80;// panel 位置y
	protected static final int searchToinfo = 45;// search到info的间距
	protected static final int gap = 50;
	protected static final ImageIcon IMG_Search = new ImageIcon("images/logistics_searchbox.png");
	protected static final ImageIcon IMG_Info = new ImageIcon("images/logistics_information.png");
	protected static final ImageIcon IMG_Circle = new ImageIcon("images/logistics_circle.png");
	protected static final ImageIcon IMG_Line = new ImageIcon("images/logistics_line.png");
	protected static final ImageIcon IMG_Connect = new ImageIcon("images/logistics_connect.png");
	protected static final ImageIcon IMG_ButtonFind = new ImageIcon("images/search.png");
	protected static final ImageIcon IMG_ButtonFindEnter = new ImageIcon("images/searchClicked.png");
	private SearchButton buttonFind;
	LogisticBLService logisticBL;
	TextFieldGroup group;
	protected static final int font = 14;
	protected Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	ArrayList<MyLabel> one;
	ArrayList<JLabel> two;
	ArrayList<JLabel> three;
	ArrayList<JLabel> four;

	public logisticsInfoPanel() {
		this.setLayout(null);
		this.setBounds(x, y, IMG_Info.getIconWidth(), IMG_Info.getIconHeight() + searchToinfo);
		this.setOpaque(false);
		drawNumTextField();
		logisticBL = new Logistic(new Log());
		buttonFind = new SearchButton(410, 2);
		this.addListener(buttonFind);
		this.add(buttonFind);
		one = new ArrayList<MyLabel>();
		two = new ArrayList<JLabel>();
		three = new ArrayList<JLabel>();
		four = new ArrayList<JLabel>();

		// RButton button=new RButton();
		// button.setBounds(100, 200, 100, 40);
		// this.add(button);

	}

	public void drawNumTextField() {
		group = new TextFieldGroup(10, 130, 5, 18, 18);
		for (int i = 0; i < 10; i++) {
			this.add(group.getTextField(i));

		}

	}

	private void addListener(JButton button) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> s = logisticBL.getLogisticsState(group.getNumberString());
				if (s == null)
					new TipDialog(null, "", true, "订单不存在", false);
				else {
					paint(s);
				}
			}

			
			
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(IMG_Search.getImage(), 0, 0, null);
		g.drawImage(IMG_Info.getImage(), 0, searchToinfo, null);
		// logisticBL.getLogisticsState(expressNumber)

	}
	
	protected void paint(ArrayList<String> s) {
		one.clear();
		two.clear();
		three.clear();
		four.clear();
		for (int i = 0; i < s.size(); i++) {
			MyLabel text = new MyLabel(s.get(i));
			JLabel circle = new JLabel(IMG_Circle);
			JLabel connect = new JLabel(IMG_Connect);
			JLabel line = new JLabel(IMG_Line);
			text.setBounds(80, IMG_Search.getIconHeight() + searchToinfo + 18 + gap * i, s.get(i).length() * 15,
					15);
			circle.setBounds(40, IMG_Search.getIconHeight() + searchToinfo + 16 + gap * i,
					IMG_Circle.getIconWidth(), IMG_Circle.getIconHeight());
			connect.setBounds(30 + IMG_Circle.getIconWidth() / 2 - 2,
					IMG_Search.getIconHeight() + searchToinfo + 16 + gap * i + IMG_Circle.getIconHeight() + 4,
					IMG_Connect.getIconHeight(), IMG_Connect.getIconHeight());
			line.setBounds(30 + IMG_Circle.getIconWidth() + 8,
					IMG_Search.getIconHeight() + searchToinfo + 16 + IMG_Connect.getIconHeight()
							+ IMG_Circle.getIconHeight() + gap * i,
					IMG_Line.getIconWidth(), IMG_Line.getIconHeight());
			one.add(text);
			two.add(circle);
			three.add(connect);
			four.add(line);

			getPanel().add(text);
			getPanel().add(circle);
			getPanel().add(connect);
			getPanel().add(line);
		}
		}

	logisticsInfoPanel getPanel() {
		return this;
	}

	public static void main(String[] args) {
		int WIDTH = 850;
		int HEIGHT = 646;
		ImageIcon IMG = new ImageIcon("images/mainFrame.png");

		JFrame frame = new JFrame();
		logisticsInfoPanel panel = new logisticsInfoPanel();
		JPanel panelbg = new JPanel();
		// 设置标题
		frame.setUndecorated(true);
		frame.setSize(850, 646);
		// 不允许用户改变窗口大小
		frame.setResizable(false);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		int x = (screen.width - WIDTH) >> 1;
		int y = ((screen.height - HEIGHT) >> 1) - 32;

		frame.setLocation(x, y);
		// 设置默认panel
		panelbg.setLayout(null);
		JLabel bg = new JLabel(IMG);
		bg.setBounds(0, 0, WIDTH, HEIGHT);

		panelbg.add(panel);
		frame.setContentPane(panelbg);
		frame.getContentPane().add(bg);
		frame.setVisible(true);
	}

}