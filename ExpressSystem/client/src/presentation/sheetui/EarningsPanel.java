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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.sheetbl.PaymentSheet;
import src.businesslogic.sheetbl.ReceivingMoneySheet;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.enums.FindingType;
import src.presentation.util.MyButton;
import src.vo.PaymentSheetVO;
import src.vo.ReceivingMoneySheetVO;
import src.vo.SheetVO;

public class EarningsPanel extends JPanel {

	static final ImageIcon IMG_BG = new ImageIcon("images/earnings_BG.png");
	static final ImageIcon IMG_ButtonP = new ImageIcon("images/earnings_ButtonP.png");
	static final ImageIcon IMG_ButtonPE = new ImageIcon("images/earnings_ButtonPE.png");
	static final ImageIcon IMG_ButtonR = new ImageIcon("images/earnings_ButtonR.png");
	static final ImageIcon IMG_ButtonRE = new ImageIcon("images/earnings_ButtonRE.png");
	protected static final int x = 195;// panel 位置x
	protected static final int y = 70;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	ArrayList<SheetVO> payment = new ArrayList<SheetVO>();
	ArrayList<SheetVO> reception = new ArrayList<SheetVO>();
	protected static final int font = 14;
	Font fontPercent = new Font("Myriad Pro", Font.LAYOUT_NO_LIMIT_CONTEXT, 24);
	Font fontAmount = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	Font fontTotal = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 20);
	SheetBLService paymentsheet;
	SheetBLService receiveingsheet;
	double receptionAmount_Day;
	double paymentAmount_Day;
	double earning_Day;
	double receptionAmount_Year;
	double paymentAmount_Year;
	double earning_Year;
	double receptionAmount_Month;
	double paymentAmount_Month;
	double earning_Month;
	int payPercent;
	int earningsPercent;
	MyButton buttonpay;
	MyButton buttonrec;
	DateChooserJButton datechoose;
	PaymentSubPanel payPanel;
	PaymentSubPanel receivePanel;
	ArrayList<SheetVO> paymentList;
	ArrayList<SheetVO> receiveList;

	public EarningsPanel(PaymentSheet paymentsheet, ReceivingMoneySheet receiveingsheet) {
		// bl层初始化
		this.receiveingsheet = receiveingsheet;
		this.paymentsheet = paymentsheet;
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		// 付款单VO
		paymentList = paymentsheet.findVOs(FindingType.ALL);

		// 收款单VO
		receiveList = receiveingsheet.findVOs(FindingType.ALL);

		// 付款单Panel
		payPanel = new PaymentSubPanel(paymentList, this);
		payPanel.setBounds(170, 230, 230, 230);
		payPanel.setVisible(true);
		// 收款单panel
		receivePanel = new PaymentSubPanel(receiveList, this);
		receivePanel.setBounds(170, 230, 230, 230);
		receivePanel.setVisible(false);
		// 计算钱
		this.calculateMoney();
		EarningActionListener l = new EarningActionListener();
		// 付款单按钮
		buttonpay = new MyButton(IMG_ButtonP, IMG_ButtonPE, 27, 225, true);
		buttonpay.addActionListener(l);
		// 收款单按钮
		buttonrec = new MyButton(IMG_ButtonR, IMG_ButtonRE, buttonpay.getX(),
				buttonpay.getY() + IMG_ButtonP.getIconHeight(), true);
		buttonrec.addActionListener(l);

		// 日期选择按钮
		datechoose = new DateChooserJButton();
		datechoose.setBounds(325, 200, 70, 23);
		datechoose.addFocusListener(new FocusListener() {
			boolean oncegained = false;

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (oncegained) {
					receivePanel.update(((DateChooserJButton) e.getSource()).getText());
					payPanel.update(((DateChooserJButton) e.getSource()).getText());
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				oncegained = true;
			}
		});
		;
		receivePanel.setVisible(false);

		this.add(datechoose);
		this.add(payPanel);
		this.add(receivePanel);
		this.add(buttonpay);
		this.add(buttonrec);
	}

	// 消文字锯齿：RenderingHints.KEY_TEXT_ANTIALIASING
	// 消绘图锯齿：RenderingHints.KEY_ANTIALIASING

	public void calculateMoney() {
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < paymentList.size(); i++) {
			PaymentSheetVO vo = (PaymentSheetVO) paymentList.get(i);
			String[] split = paymentList.get(i).getTime().split("-");
			if (c.get(Calendar.YEAR) == Integer.parseInt(split[0])) {
				paymentAmount_Year += vo.getMoney();
				System.out.println(c.get(Calendar.MONTH)+1+"------"+Integer.parseInt(split[1]));
				if (c.get(Calendar.MONTH)+1 == Integer.parseInt(split[1])) {
					paymentAmount_Month += vo.getMoney();
					if (c.get(Calendar.DATE) == Integer.parseInt(split[2])) {
						paymentAmount_Day += vo.getMoney();
					}
				}
			}
		}
		for (int i = 0; i < receiveList.size(); i++) {
			ReceivingMoneySheetVO vo = (ReceivingMoneySheetVO) receiveList.get(i);
			String[] split = receiveList.get(i).getTime().split("-");
			if (c.get(Calendar.YEAR) == Integer.parseInt(split[0])) {
				receptionAmount_Year += vo.getMoney();
				if (c.get(Calendar.MONTH) == Integer.parseInt(split[1])) {
					receptionAmount_Month += vo.getMoney();
					if (c.get(Calendar.DATE) == Integer.parseInt(split[2])) {
						receptionAmount_Day += vo.getMoney();
					}
				}
			}
		}
		earning_Year = receptionAmount_Year - paymentAmount_Year;
		earning_Month = receptionAmount_Month - paymentAmount_Month;
		earning_Day = receptionAmount_Day - paymentAmount_Day;

		// 计算比例
		if(receptionAmount_Day>paymentAmount_Day){
		payPercent = (int) (paymentAmount_Day * 100 / receptionAmount_Day);
		earningsPercent = 100 - payPercent;
		}
		else{
			payPercent = 0;
			earningsPercent = 0;
		}
			
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g.create();// 获得一个Graphics2D对象
		// 设置抗锯齿属性
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Color c = new Color(27, 172, 182);
		g2.drawImage(IMG_BG.getImage(), 27, 32, null);
		// 比例
		g2.setColor(c);
		g2.setFont(fontPercent);
		g2.drawString(Integer.toString(payPercent) + "%", 465, 325);
		g2.drawString(Integer.toString(earningsPercent) + "%", 545, 325);
		// 收入
		g2.setColor(Color.white);
		g2.setFont(fontAmount);
		g2.drawString((Integer.toString((int) receptionAmount_Year)), 42, 115);
		g2.drawString((Integer.toString((int) receptionAmount_Day)), 100, 115);
		g2.drawString((Integer.toString((int) receptionAmount_Month)), 157, 115);
		// 支出
		g2.drawString((Integer.toString((int) paymentAmount_Year)), 247, 115);
		g2.drawString((Integer.toString((int) paymentAmount_Day)), 305, 115);
		g2.drawString((Integer.toString((int) paymentAmount_Month)), 362, 115);
		// 利润
		g2.drawString((Integer.toString((int) earning_Year)), 452, 115);
		g2.drawString((Integer.toString((int) earning_Day)), 510, 115);
		g2.drawString((Integer.toString((int) earning_Month)), 567, 115);

		g2.setColor(new Color(45, 45, 45));
		g2.setFont(fontTotal);
		g2.drawString((Integer.toString((int) earning_Year)), 470, 437);
	}

	public static void main(String[] args) {
		int WIDTH = 850;
		int HEIGHT = 646;
		ImageIcon IMG = new ImageIcon("images/mainFrame.png");

		JFrame AccountFrame = new JFrame();
		EarningsPanel panel = new EarningsPanel(null, null);
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

	class EarningActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(buttonpay)) {
				buttonpay.setIcon(IMG_ButtonPE);
				buttonrec.setIcon(IMG_ButtonR);
				payPanel.setVisible(true);
				receivePanel.setVisible(false);
				repaint();
			}
			if (e.getSource().equals(buttonrec)) {
				buttonrec.setIcon(IMG_ButtonRE);
				buttonpay.setIcon(IMG_ButtonP);
				payPanel.setVisible(false);
				receivePanel.setVisible(true);
				repaint();
			}

		}
	}
}
