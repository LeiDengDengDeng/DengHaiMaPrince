package src.presentation.sheetui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.logbl.Log;
import src.businesslogic.sheetbl.Constant;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.enums.FindingType;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.vo.ConstantVO;
import src.vo.SheetVO;

public class ConstantPanel extends JPanel {

	static final ImageIcon IMG_REC = new ImageIcon("images/constant_rec1.png");
	static final ImageIcon IMG_REC2 = new ImageIcon("images/account_rec2.png");
	static final ImageIcon IMG_BG = new ImageIcon("images/constant_bg.png");
	static final ImageIcon IMG_ButtonConfirm = new ImageIcon("images/confirm.png");
	static final ImageIcon IMG_ButtonConfirmEnter = new ImageIcon("images/confirmClicked.png");
	static final ImageIcon IMG_ButtonMod = new ImageIcon("images/account_mod.png");
	static final ImageIcon IMG_ButtonModEnter = new ImageIcon("images/account_modEnter.png");
	static final ImageIcon IMG_ButtonCancel = new ImageIcon("images/cancel.png");
	static final ImageIcon IMG_ButtonCancelEnter = new ImageIcon("images/cancel_Enter.png");
	protected static final int x = 195;// panel 位置x
	protected static final int y = 70;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	protected static final int font = 14;
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	SheetBLService sheet;
	ArrayList<MyButton> modList;
	MyActionListener l;
	MyButton confirm;
	MyButton cancel;
	JTextField distance;
	JTextField price;
	ConstantVO cv;
	ArrayList<SheetVO> vo;

	public ConstantPanel(Log logBL) {
		sheet = new Constant(logBL, null);
		vo = this.sheet.findVOs(FindingType.ALL);
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		modList = new ArrayList<MyButton>();
		l = new MyActionListener();
		for (int j = 0; j < vo.size(); j++) {
			MyButton buttonMod = new MyButton(IMG_ButtonMod, IMG_ButtonModEnter, 500, 93 + IMG_REC.getIconHeight() * j);
			modList.add(buttonMod);
			buttonMod.addActionListener(l);
			this.add(buttonMod);
		}
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawImage(IMG_BG.getImage(), 45, 30, null);
		g2.setColor(Color.white);
		g2.setFont(myFont);
		for (int i = 0; i < vo.size(); i++) {
			if (i % 2 == 1)
				g2.drawImage(IMG_REC.getImage(), 48, 90 + IMG_REC.getIconHeight() * i, null);
			if (i % 2 == 0)
				g2.drawImage(IMG_REC2.getImage(), 48, 90 + IMG_REC.getIconHeight() * i, null);

			g2.drawString(((ConstantVO) vo.get(i)).getCityOne() + " - " + ((ConstantVO) vo.get(i)).getCityTwo(), 115,
					107 + IMG_REC.getIconHeight() * i);
			g2.drawString(Double.toString(((ConstantVO) vo.get(i)).getDistant()), 285,
					107 + IMG_REC.getIconHeight() * i);
			g2.drawString(Double.toString(((ConstantVO) vo.get(i)).getPrice()), 425, 107 + IMG_REC.getIconHeight() * i);

		}

	}

	public JPanel getPanel() {
		return this;
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < modList.size(); i++) {
				if (e.getSource().equals(cancel)) {
					PanelController.refreshPresentPanel();
					return;
				}
				if (e.getSource().equals(confirm)) {
					ConstantVO vo = new ConstantVO(null, null, Double.parseDouble(distance.getText()),
							Double.parseDouble(price.getText()), cv.getCityOne(), cv.getCityTwo());
					sheet.modify(cv.getID(), vo);
					PanelController.refreshPresentPanel();
					return;
				}
				if (e.getSource().equals(modList.get(i))) {
					MyButton button = (MyButton) e.getSource();
					getPanel().remove(modList.get(i));
					distance = new JTextField();
					distance.setBounds(283, button.getY(), 50, 20);
					price = new JTextField();
					price.setBounds(423, button.getY(), 50, 20);
					confirm = new MyButton(IMG_ButtonConfirm, IMG_ButtonConfirmEnter, button.getX() - 20,
							button.getY());
					confirm.addActionListener(l);
					cancel = new MyButton(IMG_ButtonCancel, IMG_ButtonCancelEnter, button.getX() + 40, button.getY());
					cancel.addActionListener(l);
					cv = (ConstantVO) vo.get(i);
					getPanel().add(cancel);
					getPanel().add(confirm);
					getPanel().add(distance);
					getPanel().add(price);
					getPanel().repaint();

				}
				else
					modList.get(i).setEnabled(false);
					
			}

			;

		}

	}

	public static void main(String[] args) {
		int WIDTH = 850;
		int HEIGHT = 646;
		ImageIcon IMG = new ImageIcon("images/mainFrame.png");

		JFrame AccountFrame = new JFrame();
		ConstantPanel panel = new ConstantPanel(new Log());
		JPanel panelbg = new JPanel();
		// 设置标题
		AccountFrame.setUndecorated(true);
		AccountFrame.setSize(850, 646);
		// 不允许用户改变窗口大小
		AccountFrame.setResizable(false);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		int x = (screen.width - WIDTH) >> 1;
		int y = ((screen.height - HEIGHT) >> 1) - 32;

		AccountFrame.setLocation(x, y);
		// 设置默认panel
		panelbg.setLayout(null);
		JLabel bg = new JLabel(IMG);
		bg.setBounds(0, 0, WIDTH, HEIGHT);

		panelbg.add(panel);
		AccountFrame.setContentPane(panelbg);
		AccountFrame.getContentPane().add(bg);
		AccountFrame.setVisible(true);

	}

	// class stub {
	// String[][] getCityList() {
	// String[][] s = new String[5][1];
	// s[0][0] = "南京";
	// s[1][0] = "北京";
	// s[2][0] = "上海";
	// s[3][0] = "深圳";
	// s[4][0] = "广州";
	// return s;
	// }
	// }
}
