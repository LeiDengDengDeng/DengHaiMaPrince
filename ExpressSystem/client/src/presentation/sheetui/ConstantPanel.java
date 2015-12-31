package src.presentation.sheetui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.sheetbl.Constant;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.enums.FindingType;
import src.presentation.util.MyButton;
import src.vo.ConstantVO;
import src.vo.SheetVO;

public class ConstantPanel extends JPanel {

	static final ImageIcon IMG_REC = new ImageIcon("images/constant_rec1.png");
	static final ImageIcon IMG_REC2 = new ImageIcon("images/account_rec2.png");
	static final ImageIcon IMG_BG = new ImageIcon("images/constant_bg.png");
	static final ImageIcon IMG_ButtonConfirm = new ImageIcon("images/account_confirm.png");
	static final ImageIcon IMG_ButtonMod = new ImageIcon("images/account_mod.png");
	static final ImageIcon IMG_ButtonModEnter = new ImageIcon("images/account_modEnter.png");
	protected static final int x = 195;// panel 位置x
	protected static final int y = 70;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	protected static final int font = 14;
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	SheetBLService sheet;

	public ConstantPanel() {
		sheet = new Constant(null);
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		JButton buttonConfirm = new JButton(IMG_ButtonConfirm);

		buttonConfirm.setBounds(500, 500, IMG_ButtonConfirm.getIconWidth(), IMG_ButtonConfirm.getIconHeight());
		this.add(buttonConfirm);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(IMG_BG.getImage(), 45, 30, null);
		g.setColor(Color.white);
		this.setFont(myFont);
		ArrayList<SheetVO> vo = this.sheet.findVOs(FindingType.ALL);
		for (int i = 0; i < vo.size(); i++) {
			if (i % 2 == 1)
				g.drawImage(IMG_REC.getImage(), 48, 90 + IMG_REC.getIconHeight() * i, null);
			if (i % 2 == 0)
				g.drawImage(IMG_REC2.getImage(), 48, 90 + IMG_REC.getIconHeight() * i, null);
			g.drawString(((ConstantVO) vo.get(i)).getCityOne() + " - " + ((ConstantVO) vo.get(i)).getCityTwo(), 115,
					107 + IMG_REC.getIconHeight() * i);
			g.drawString(Double.toString(((ConstantVO) vo.get(i)).getDistant()), 285,
					107 + IMG_REC.getIconHeight() * i);
			g.drawString(Double.toString(((ConstantVO) vo.get(i)).getPrice()), 425, 107 + IMG_REC.getIconHeight() * i);
			MyButton buttonMod = new MyButton(IMG_ButtonMod, IMG_ButtonModEnter);
			buttonMod.setBounds(500, 107 + IMG_REC.getIconHeight() * i, IMG_ButtonMod.getIconWidth(),
					IMG_ButtonMod.getIconHeight());
			this.add(buttonMod);
			buttonMod.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MyButton button=(MyButton)e.getSource();
					JTextField distance = new JTextField();
					distance.setBounds(285, button.getY(),50,20);
					JTextField price = new JTextField();
					distance.setBounds(425, button.getY(),50,20);

				}
			});
		}
		g.setFont(myFont);
		g.setColor(Color.white);

	}

	public static void main(String[] args) {
		int WIDTH = 850;
		int HEIGHT = 646;
		ImageIcon IMG = new ImageIcon("images/mainFrame.png");

		JFrame AccountFrame = new JFrame();
		ConstantPanel panel = new ConstantPanel();
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
