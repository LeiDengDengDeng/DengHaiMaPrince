package src.presentation.sheetui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.businesslogic.loginbl.LogIn;
import src.businesslogic.util.CommonUtil;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.enums.GoodsType;
import src.presentation.mainui.PanelController;
import src.presentation.util.ConfirmButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;
import src.vo.GoodsVO;
import src.vo.OrderSheetVO;

/**
 * Created by dell on 2015/11/26. 用途：寄件单界面
 */
public class OrderSheetPanel extends SheetPanel {
	SheetBLService orderSheetBL;
	String[] cities;

	TextFieldGroup idGroup;
	JTextField senName;
	JTextField senTel;
	JTextField senMob;
	JTextField senAdd;
	JTextField senOrg;
	JTextField recName;
	JTextField recTel;
	JTextField recMob;
	JTextField recAdd;
	JTextField recOrg;
	JTextField num;
	JTextField name;
	JTextField length;
	JTextField width;
	JTextField height;
	JTextField weight;
	JComboBox start;
	JComboBox end;
	JComboBox logisticsWay;
	JComboBox packWay;
	JButton calButton;
	MyLabel money;
	ConfirmButton confirmButton;

	JLabel imageLabel;
	ImageIcon bkgImg;

	private static final int MARGIN_LEFT = 175;
	private static final int COMPONENT_HEIGHT = 18;

	public OrderSheetPanel(SheetBLService orderSheetBL) {
		this.orderSheetBL = orderSheetBL;

		init();

		start.setBounds(MARGIN_LEFT + 250 + 20, 154, 70, COMPONENT_HEIGHT);
		end.setBounds(MARGIN_LEFT + 250 + 20, 313, 70, COMPONENT_HEIGHT);
		senName.setBounds(MARGIN_LEFT, 96, 100, COMPONENT_HEIGHT);
		senTel.setBounds(MARGIN_LEFT, 124, 100, COMPONENT_HEIGHT);
		senMob.setBounds(MARGIN_LEFT + 240, 124, 100, COMPONENT_HEIGHT);
		senAdd.setBounds(MARGIN_LEFT, 154, 250, COMPONENT_HEIGHT);
		senOrg.setBounds(MARGIN_LEFT, 182, 250, COMPONENT_HEIGHT);
		recName.setBounds(MARGIN_LEFT, 254, 100, COMPONENT_HEIGHT);
		recTel.setBounds(MARGIN_LEFT, 283, 100, COMPONENT_HEIGHT);
		recMob.setBounds(MARGIN_LEFT + 240, 283, 100, COMPONENT_HEIGHT);
		recAdd.setBounds(MARGIN_LEFT, 313, 250, COMPONENT_HEIGHT);
		recOrg.setBounds(MARGIN_LEFT, 342, 250, COMPONENT_HEIGHT);
		num.setBounds(150, 416, 40, COMPONENT_HEIGHT);
		name.setBounds(358, 416, 100, COMPONENT_HEIGHT);
		length.setBounds(128, 449, 30, COMPONENT_HEIGHT);
		width.setBounds(245, 449, 30, COMPONENT_HEIGHT);
		height.setBounds(363, 449, 30, COMPONENT_HEIGHT);
		weight.setBounds(470, 460, 30, COMPONENT_HEIGHT);
		logisticsWay.setBounds(156, 506, 80, COMPONENT_HEIGHT + 2);
		packWay.setBounds(358, 506, 80, COMPONENT_HEIGHT + 2);

		imageLabel.setIcon(bkgImg);
		imageLabel.setBounds(40, 20, bkgImg.getIconWidth(),
				bkgImg.getIconHeight());

		confirmButton.addActionListener(new ConfirmButtonListener(this));

		money.setBounds(105, 550, 40, 20);
		calButton.setBounds(200, 550, 46, 25);
		calButton.setIcon(new ImageIcon("images/sheet_calculate.png"));
		calButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money.setText(calculateMoney() + "");
				repaint();
			}
		});

		for (int i = 0; i < 10; i++) {
			this.add(idGroup.getTextField(i));
		}
		this.add(start);
		this.add(end);
		this.add(recName);
		this.add(recTel);
		this.add(recMob);
		this.add(recAdd);
		this.add(recOrg);
		this.add(senName);
		this.add(senTel);
		this.add(senMob);
		this.add(senAdd);
		this.add(senOrg);
		this.add(num);
		this.add(name);
		this.add(length);
		this.add(width);
		this.add(height);
		this.add(weight);
		this.add(logisticsWay);
		this.add(packWay);
		this.add(money);
		this.add(imageLabel);
		this.add(calButton);
		this.add(confirmButton);
		this.setLayout(null);
		this.setOpaque(false);

	}

	private void init() {
		String[][] cityList = orderSheetBL.getExistedInfo();
		cities = new String[cityList.length];
		for (int i = 0; i < cityList.length; i++) {
			cities[i] = cityList[i][0];
		}

		idGroup = new TextFieldGroup(10, MARGIN_LEFT, 25, 20, COMPONENT_HEIGHT);
		senName = new JTextField();
		senTel = new JTextField();
		senMob = new JTextField();
		senAdd = new JTextField();
		senOrg = new JTextField();
		recName = new JTextField();
		recTel = new JTextField();
		recMob = new JTextField();
		recAdd = new JTextField();
		recOrg = new JTextField();
		num = new JTextField();
		name = new JTextField();
		length = new JTextField();
		width = new JTextField();
		height = new JTextField();
		weight = new JTextField();
		start = new JComboBox<>(new String[] { LogIn.currentUser.getCity() });
		end = new JComboBox<>(cities);
		String[] logisticsWayName = { "经济快递", "标准快递", "特快专递" };
		logisticsWay = new JComboBox(logisticsWayName);
		String[] packWayName = { "纸箱", "木箱", "快递袋", "其它" };
		packWay = new JComboBox(packWayName);
		calButton = new JButton();
		money = new MyLabel("-");
		confirmButton = new ConfirmButton(520, 550);
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/sheet_order.png");
	}

	private double calculateMoney() {
		int moneyOfLogistics = 18;
		System.out.println(logisticsWay.getSelectedIndex());
		switch (logisticsWay.getSelectedIndex()) {
		case 0:
			moneyOfLogistics = 18;
			break;
		case 1:
			moneyOfLogistics = 23;
			break;
		case 2:
			moneyOfLogistics = 25;
			break;
		}
		int moneyOfPackway = 5;
		switch (packWay.getSelectedIndex()) {
		case 0:
			moneyOfPackway = 5;
			break;
		case 1:
			moneyOfPackway = 10;
			break;
		case 2:
			moneyOfPackway = 1;
			break;
		}
		return moneyOfLogistics * 266 / 1000
				* Double.parseDouble(weight.getText()) + moneyOfPackway;
	}

	public boolean confirm() {
		if (!CommonUtil.isValidNumberString(idGroup.getNumberString(), 10)) {
			new TipDialog(null, "", true, "快递物流编号格式错误", false);
			return false;
		} else if (!CommonUtil.isValidNumberString(senMob.getText(), 11)
				|| !CommonUtil.isValidNumberString(senMob.getText(), 11)) {
			new TipDialog(null, "", true, "手机号码格式错误", false);
			return false;
		} else if (senName.getText().equals("") || senAdd.getText().equals("")
				|| senOrg.getText().equals("") || senTel.getText().equals("")) {
			new TipDialog(null, "", true, "寄件信息存在未填写的部分", false);
			return false;
		} else if (recName.getText().equals("") || recAdd.getText().equals("")
				|| recOrg.getText().equals("") || recTel.getText().equals("")) {
			new TipDialog(null, "", true, "收件信息存在未填写的部分", false);
			return false;
		}

		OrderSheetVO vo = new OrderSheetVO("XXXX", CommonUtil.getDate(),
				Long.parseLong(idGroup.getNumberString()), senName.getText(),
				senAdd.getText(), senOrg.getText(), senTel.getText(),
				senMob.getText(), recName.getText(), recAdd.getText(),
				recOrg.getText(), recTel.getText(), recMob.getText());
		GoodsType logistics = GoodsType.ECONOMIC;
		switch (logisticsWay.getSelectedIndex()) {
		case 0:
			logistics = GoodsType.ECONOMIC;
			break;
		case 1:
			logistics = GoodsType.STANDARD;
			break;
		case 2:
			logistics = GoodsType.EXPRESS;
			break;
		}
		GoodsType pack = GoodsType.PAPERPAKAGE;
		switch (packWay.getSelectedIndex()) {
		case 0:
			pack = GoodsType.PAPERPAKAGE;
			break;
		case 1:
			pack = GoodsType.WOODPACKAGE;
			break;
		case 2:
			pack = GoodsType.EXPRESSPACKAGE;
			break;
		case 3:
			pack = GoodsType.OTHERPACKAGE;
			break;
		}

		GoodsVO goodsVO = new GoodsVO(idGroup.getNumberString(),
				name.getText(), Integer.parseInt(num.getText()),
				Double.parseDouble(length.getText()), Double.parseDouble(width
						.getText()), Double.parseDouble(height.getText()),
				Double.parseDouble(weight.getText()), Double.parseDouble(length
						.getText())
						* Double.parseDouble(width.getText())
						* Double.parseDouble(height.getText()), logistics, pack);
		vo.setGoodsVO(goodsVO);

		if (orderSheetBL.add(vo)) {
			new TipDialog(null, "", true, "单据提交成功", true);
			PanelController.refreshPresentPanel();
		} else
			new TipDialog(null, "", true, "单据提交失败", false);

		return true;
	}
}
