package src.presentation.nonuserui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.nonUserbl.DriverController;
import src.businesslogicservice.nonUserblservice.DriverBLService;
import src.enums.Sex;
import src.vo.DriverInfoVO;

public class DriverPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2921392953374518181L;

	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高

	protected static final ImageIcon IMG_BG = new ImageIcon("images/driver_bg.png");
	protected static final ImageIcon IMG_CHANGECONFIRM = new ImageIcon("images/driverchangeconfirmbutton.png");
	protected static final ImageIcon IMG_DRIVER = new ImageIcon("images/driver.png");

	protected static final int buttonToButton = 27;// 司机图标之间的横向间距
	protected static final int height = 18;// 司机图标之间的纵向间距
	protected static final int buttonToTop = 55;// 第一排司机图标到最顶层的间距
	protected static final int numLabelHeight = 84;// 按钮顶端到编号的距离
	protected static final int nameLabelHeight = 105;// 按钮顶端到姓名的距离
	protected static final int labelWidth = 51;// 按钮左边到姓名编号的距离

	private ImageIcon addbkgImg;
	private ImageIcon checkbkgImg;
	private JLabel backLabel;
	private JLabel addLabel;
	private JLabel checkLabel;
	private JLabel nameLabel;
	private JLabel numLabel;
	private JLabel sexLabel;
	private JLabel mobNumLabel;
	private JLabel idLabel;
	private JLabel dateLabel;
	private JLabel yearOfExpiringLabel;
	private JTextField changeNameField;
	private JTextField changeNumField;
	private JComboBox changeSexBox;
	private JTextField changeMobNumField;
	private JTextField changeIdField;
	private JTextField changeDateField;
	private JTextField changeYearOfExpiringField;
	private JTextField TextFieldCheckdriverNum;
	private JTextField TextFieldCheckDriverNum;
	private JTextField textFieldDriverId;
	private JTextField TextFieldCity;
	private JTextField TextFieldBusinessHall;
	private JTextField textFieldYearOfExpiring;
	private JTextField textFieldDriverNum;
	private JTextField textFieldDriverName;
	private JTextField textFieldMobNum;
	private JComboBox comboBoxSex;
	private JButton checkConfirmButton;
	private JButton addConfirmButton;
	private JButton deleteConfirmButton;
	private JButton cancelButton;
	private JButton saveButton;
	private JButton returnButton;
	private JButton changeButton;
	private JButton changeConfirmButton;
	// private ArrayList<JButton> driverList;
	private ArrayList<JLabel> driverList;
	private ArrayList<JLabel> numList;
	private ArrayList<JLabel> nameList;
	private ArrayList<DriverInfoVO> drivers;
	private DriverBLService driverBL;
	private boolean isActive;

	public DriverPanel() {
		driverBL = new DriverController();

		TextFieldCheckdriverNum = new JTextField();
		TextFieldCheckdriverNum.setBounds(140, 30, 200, 28);
		this.add(TextFieldCheckdriverNum);
		nameLabel = new JLabel();
		numLabel = new JLabel();
		sexLabel = new JLabel();
		mobNumLabel = new JLabel();
		idLabel = new JLabel();
		dateLabel = new JLabel();
		yearOfExpiringLabel = new JLabel();

		TextFieldCheckDriverNum = new JTextField();
		TextFieldCheckDriverNum.setBounds(140, 30, 200, 28);
		this.add(TextFieldCheckDriverNum);

		textFieldDriverNum = new JTextField();
		textFieldDriverNum.setBounds(385, 95, 100, 25);
		textFieldDriverNum.setVisible(false);
		this.add(textFieldDriverNum);

		textFieldDriverName = new JTextField();
		textFieldDriverName.setBounds(125, 65, 80, 25);
		textFieldDriverName.setVisible(false);
		this.add(textFieldDriverName);

		textFieldDriverId = new JTextField();
		textFieldDriverId.setBounds(385, 65, 100, 25);
		textFieldDriverId.setVisible(false);
		this.add(textFieldDriverId);

		TextFieldCity = new JTextField();
		TextFieldCity.setBounds(105, 95, 70, 25);
		TextFieldCity.setVisible(false);
		this.add(TextFieldCity);

		TextFieldBusinessHall = new JTextField();
		TextFieldBusinessHall.setBounds(225, 95, 70, 25);
		TextFieldBusinessHall.setVisible(false);
		this.add(TextFieldBusinessHall);

		textFieldYearOfExpiring = new JTextField();
		textFieldYearOfExpiring.setBounds(340, 125, 80, 25);
		textFieldYearOfExpiring.setVisible(false);
		this.add(textFieldYearOfExpiring);

		textFieldMobNum = new JTextField();
		textFieldMobNum.setBounds(115, 125, 80, 25);
		textFieldMobNum.setVisible(false);
		this.add(textFieldMobNum);

		String[] sexString = { "男", "女" };
		comboBoxSex = new JComboBox(sexString);
		comboBoxSex.setBounds(245, 65, 70, 25);
		comboBoxSex.setVisible(false);
		this.add(comboBoxSex);

		changeNameField = new JTextField();
		changeNumField = new JTextField();
		changeSexBox = new JComboBox();
		changeMobNumField = new JTextField();
		changeIdField = new JTextField();
		changeDateField = new JTextField();
		changeYearOfExpiringField = new JTextField();

		cancelButton = new JButton();
		ConfirmButtonListener listener = new ConfirmButtonListener(this);
		cancelButton.addActionListener(listener);
		cancelButton.setBounds(428, 125, 70, 28);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setBorder(null);
		cancelButton.setVisible(false);
		this.add(cancelButton);

		saveButton = new JButton();
		saveButton.addActionListener(listener);
		saveButton.setBounds(507, 125, 70, 28);
		saveButton.setContentAreaFilled(false);
		saveButton.setBorder(null);
		saveButton.setVisible(false);
		this.add(saveButton);

		returnButton = new JButton();
		returnButton.addActionListener(listener);
		returnButton.setBounds(40, 59, 60, 25);
		returnButton.setContentAreaFilled(false);
		returnButton.setBorder(null);
		returnButton.setVisible(false);
		this.add(returnButton);

		addLabel = new JLabel();
		addbkgImg = new ImageIcon("images/driveradd_bg.png");
		addLabel.setIcon(addbkgImg);
		addLabel.setBounds(40, 55, addbkgImg.getIconWidth(), addbkgImg.getIconHeight());
		addLabel.setVisible(false);
		this.add(addLabel);

		deleteConfirmButton = new JButton();
		deleteConfirmButton.addActionListener(listener);
		deleteConfirmButton.setBounds(500, 340, 70, 28);
		deleteConfirmButton.setContentAreaFilled(false);
		deleteConfirmButton.setBorder(null);
		deleteConfirmButton.setVisible(false);
		this.add(deleteConfirmButton);

		changeButton = new JButton();
		changeButton.addActionListener(listener);
		changeButton.setBounds(415, 340, 72, 28);
		changeButton.setContentAreaFilled(false);
		changeButton.setBorder(null);
		changeButton.setVisible(false);
		this.add(changeButton);

		changeConfirmButton = new JButton(IMG_CHANGECONFIRM);
		changeConfirmButton.addActionListener(listener);
		changeConfirmButton.setBounds(270, 342, IMG_CHANGECONFIRM.getIconWidth(), IMG_CHANGECONFIRM.getIconHeight());
		changeConfirmButton.setBorder(null);
		changeConfirmButton.setVisible(false);
		this.add(changeConfirmButton);

		checkLabel = new JLabel();
		checkbkgImg = new ImageIcon("images/drivercheck2_bg.png");
		checkLabel.setIcon(checkbkgImg);
		checkLabel.setBounds(40, 59, checkbkgImg.getIconWidth(), checkbkgImg.getIconHeight());
		checkLabel.setVisible(false);
		this.add(checkLabel);

		checkConfirmButton = new JButton();
		checkConfirmButton.addActionListener(listener);
		checkConfirmButton.setBounds(400, 30, 65, 28);
		checkConfirmButton.setContentAreaFilled(false);
		checkConfirmButton.setBorder(null);
		this.add(checkConfirmButton);

		addConfirmButton = new JButton();
		addConfirmButton.addActionListener(listener);
		// System.out.println(IMG_CONFIRM.getIconWidth()+"
		// "+IMG_CONFIRM.getIconHeight());
		addConfirmButton.setBounds(480, 30, 100, 28);
		addConfirmButton.setContentAreaFilled(false);
		addConfirmButton.setBorder(null);
		this.add(addConfirmButton);

		backLabel = new JLabel();
		backLabel.setIcon(IMG_BG);
		backLabel.setBounds(40, 30, IMG_BG.getIconWidth(), IMG_BG.getIconHeight());
		this.add(backLabel);

		drivers = driverBL.getDriverByBusinesshall("025000000");
		// driverList = new ArrayList<JButton>();
		driverList = new ArrayList<JLabel>();
		numList = new ArrayList<JLabel>();
		nameList = new ArrayList<JLabel>();
		for (int i = 0; i < drivers.size(); i++) {
			// JButton driver = new JButton(IMG_DRIVER);
			JLabel driver = new JLabel(IMG_DRIVER);
			driver.setBounds(40 + (i % 4) * (IMG_DRIVER.getIconWidth() + buttonToButton),
					30 + buttonToTop + (i / 4) * (height + IMG_DRIVER.getIconHeight()), IMG_DRIVER.getIconWidth(),
					IMG_DRIVER.getIconHeight());
			// driver.setBorder(null);
			driver.addMouseListener(new DriverListener());
			driverList.add(driver);
			JLabel num = new JLabel(drivers.get(i).getNumber());
			numList.add(num);
			JLabel name = new JLabel(drivers.get(i).getName());
			nameList.add(name);
			this.add(driverList.get(i));
		}
		drawDrivers();
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
	}

	class ConfirmButtonListener implements ActionListener {

		DriverPanel dPanel;

		public ConfirmButtonListener(DriverPanel dPanel) {
			this.dPanel = dPanel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == checkConfirmButton) {
				String driverId = TextFieldCheckdriverNum.getText();
				processCheck(driverId);

			}
			if (e.getSource() == addConfirmButton) {
				// DriverInfoVO dvo = null;
				// long number = Long.parseLong(textFieldDriverNum.getText());
				// int activeTime =
				// Integer.parseInt(textFieldDriverTime.getText());
				// String driverId = textFieldDriverId.getText();
				// tvo = new TruckInfoVO(number, activeTime, driverId);
				// truckBL.addTruckInfo(tvo);
				backLabel.setVisible(false);
				TextFieldCheckdriverNum.setVisible(false);
				TextFieldCheckDriverNum.setVisible(false);
				textFieldDriverNum.setVisible(true);
				textFieldDriverName.setVisible(true);
				textFieldDriverId.setVisible(true);
				TextFieldCity.setVisible(true);
				TextFieldBusinessHall.setVisible(true);
				textFieldYearOfExpiring.setVisible(true);
				textFieldMobNum.setVisible(true);
				comboBoxSex.setVisible(true);
				cancelButton.setVisible(true);
				saveButton.setVisible(true);
				addLabel.setVisible(true);
				isActive = true;
				// System.out.println("sb");
			}
			if (e.getSource() == deleteConfirmButton) {
				String driverId = TextFieldCheckdriverNum.getText();
				System.out.println("deletedriverId: " + driverId);
				// driverBL.deleteDriverInfo(driverId);
			}
			if (e.getSource() == cancelButton) {
				backLabel.setVisible(true);
				TextFieldCheckdriverNum.setVisible(true);
				textFieldDriverNum.setVisible(false);
				textFieldDriverName.setVisible(false);
				textFieldDriverId.setVisible(false);
				TextFieldCity.setVisible(false);
				TextFieldBusinessHall.setVisible(false);
				textFieldYearOfExpiring.setVisible(false);
				textFieldMobNum.setVisible(false);
				comboBoxSex.setVisible(false);
				cancelButton.setVisible(false);
				saveButton.setVisible(false);
				addLabel.setVisible(false);
				isActive = false;
				// System.out.println("sb");
				String driverId = numLabel.getText();
				System.out.println("deletedriverId: " + driverId);
				processReturn();
				for (int i = 0; i < drivers.size(); i++) {
					dPanel.remove(driverList.get(i));
					dPanel.remove(nameList.get(i));
					dPanel.remove(numList.get(i));
				}
				driverBL.deleteDriverInfo(driverId);
				drawDrivers();
				dPanel.repaint();
			}
			if (e.getSource() == cancelButton) {
				processCancel();
			}
			if (e.getSource() == saveButton) {
				System.out.println("sb");
				String name = textFieldDriverName.getText();
				String sexString = (String) comboBoxSex.getSelectedItem();
				Sex sex = null;
				if (sexString.equals("男")) {
					sex = Sex.MALE;
				} else {
					sex = sex.FEMALE;
				}
				String id = textFieldDriverId.getText();
				String city = TextFieldCity.getText();
				String businessHall = TextFieldBusinessHall.getText();
				String num = textFieldDriverNum.getText();
				String mobNum = textFieldMobNum.getText();
				String yearOfExpiring = textFieldYearOfExpiring.getText();
				DriverInfoVO dvo = new DriverInfoVO(num, name, Integer.parseInt(id.substring(6, 10)),
						Integer.parseInt(id.substring(10, 12)), Integer.parseInt(id.substring(12, 14)), id, mobNum, sex,
						Integer.parseInt(yearOfExpiring));
				// System.out.println(dvo.getName() + " " + dvo.getSex());
				// System.out.println(dvo.getYear() + " " + dvo.getMonth() + " "
				// + dvo.getDay());
				// driverBL.addDriverInfo(dvo);
			}
			if (e.getSource() == returnButton) {
				backLabel.setVisible(true);
				TextFieldCheckdriverNum.setVisible(true);
				for (int i = 0; i < dPanel.drivers.size(); i++) {
					driverList.get(i).setVisible(true);
				}
				changeConfirmButton.setVisible(false);
				deleteConfirmButton.setVisible(false);
				changeButton.setVisible(false);
				returnButton.setVisible(false);
				checkLabel.setVisible(false);
				nameLabel.setVisible(false);
				numLabel.setVisible(false);
				sexLabel.setVisible(false);
				mobNumLabel.setVisible(false);
				idLabel.setVisible(false);
				dateLabel.setVisible(false);
				yearOfExpiringLabel.setVisible(false);
				changeNameField.setVisible(false);
				changeNumField.setVisible(false);
				changeSexBox.setVisible(false);
				changeMobNumField.setVisible(false);
				changeIdField.setVisible(false);
				changeDateField.setVisible(false);
				changeYearOfExpiringField.setVisible(false);
			}
			if (e.getSource() == changeButton) {
				nameLabel.setVisible(false);
				numLabel.setVisible(false);
				sexLabel.setVisible(false);
				mobNumLabel.setVisible(false);
				idLabel.setVisible(false);
				dateLabel.setVisible(false);
				yearOfExpiringLabel.setVisible(false);
				changeConfirmButton.setVisible(true);

				DriverInfoVO dvo = null;
				String driverId = TextFieldCheckdriverNum.getText();
				System.out.println("checkdriverId: " + driverId);
				dvo = driverBL.getDriverInfo(driverId);
				changeNameField = new JTextField(dvo.getName());
				changeNameField.setBounds(115, 195, 80, 25);
				dPanel.add(changeNameField, 1);
				changeNumField = new JTextField(dvo.getNumber());
				changeNumField.setBounds(115, 222, 80, 25);
				dPanel.add(changeNumField, 1);
				String[] sexString = { "男", "女" };
				changeSexBox = new JComboBox(sexString);
				if (dvo.getSex() == Sex.MALE) {
					changeSexBox.setSelectedItem("男");
				} else {
					changeSexBox.setSelectedItem("女");
				}
				changeSexBox.setBounds(270, 108, 80, 25);
				dPanel.add(changeSexBox, 1);
				changeMobNumField = new JTextField(dvo.getMobNum());
				changeMobNumField.setBounds(280, 153, 100, 25);
				dPanel.add(changeMobNumField, 1);
				changeIdField = new JTextField(dvo.getID());
				changeIdField.setBounds(295, 193, 150, 25);
				dPanel.add(changeIdField, 1);
				changeDateField = new JTextField(dvo.getYear() + "-" + dvo.getMonth() + "-" + dvo.getDay());
				changeDateField.setBounds(295, 234, 80, 25);
				dPanel.add(changeDateField, 1);
				System.out.println(dvo.getYearOfExpiring());
				changeYearOfExpiringField = new JTextField(dvo.getYearOfExpiring() + "");
				changeYearOfExpiringField.setBounds(335, 275, 80, 25);
				dPanel.add(changeYearOfExpiringField, 1);
			}
			if (e.getSource() == changeConfirmButton) {
				changeConfirmButton.setVisible(false);
				driverBL.addDriverInfo(dvo);

				processCancel();
				for (int i = 0; i < drivers.size(); i++) {
					dPanel.remove(driverList.get(i));
					dPanel.remove(nameList.get(i));
					dPanel.remove(numList.get(i));
				}
				drawDrivers();
				dPanel.repaint();
			}
			if (e.getSource() == returnButton) {
				processReturn();
			}
			if (e.getSource() == changeButton) {
				// String driverId = TextFieldCheckDriverNum.getText();
				// System.out.println("checkdriverId1: " + driverId);
				processchange();
			}
			if (e.getSource() == changeConfirmButton) {
				changeConfirmButton.setVisible(false);
				changeButton.setVisible(true);

				nameLabel.setText(changeNameField.getText());
				changeNameField.setVisible(false);
				nameLabel.setVisible(true);

				numLabel.setText(changeNumField.getText());
				changeNumField.setVisible(false);
				numLabel.setVisible(true);

				sexLabel.setText(changeSexBox.getSelectedItem() + "");
				changeSexBox.setVisible(false);
				sexLabel.setVisible(true);

				mobNumLabel.setText(changeMobNumField.getText());
				changeMobNumField.setVisible(false);
				mobNumLabel.setVisible(true);

				idLabel.setText(changeIdField.getText());
				changeIdField.setVisible(false);
				idLabel.setVisible(true);

				dateLabel.setText(changeDateField.getText());
				changeDateField.setVisible(false);
				dateLabel.setVisible(true);

				yearOfExpiringLabel.setText(changeYearOfExpiringField.getText());
				changeYearOfExpiringField.setVisible(false);
				yearOfExpiringLabel.setVisible(true);

				String name = changeNameField.getText();
				String sexString = (String) changeSexBox.getSelectedItem();
				Sex sex = null;
				if (sexString.equals("男")) {
					sex = Sex.MALE;
				} else {
					sex = sex.FEMALE;
				}
				String id = changeIdField.getText();
				String num = changeNumField.getText();
				String mobNum = changeMobNumField.getText();
				String yearOfExpiring = changeYearOfExpiringField.getText();
				System.out.println("id: " + id);
				DriverInfoVO dvo = new DriverInfoVO(num, name, Integer.parseInt(id.substring(6, 10)),
						Integer.parseInt(id.substring(10, 12)), Integer.parseInt(id.substring(12, 14)), id, mobNum, sex,
						Integer.parseInt(yearOfExpiring));
				// driverBL.changeDriverInfo(id, dvo);
				driverBL.changeDriverInfo(num, dvo);
			}
		}

	}

	class DriverListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (isActive) {
				return;
			}

			for (int i = 0; i < driverList.size(); i++) {
				if (e.getSource() == driverList.get(i))
					processCheck(numList.get(i).getText());
			}

		}
	}

	// public void paintComponent(Graphics g)
	// {
	// super.paintComponent(g);
	//
	//
	// g.drawImage(IMG_BG.getImage(),40, 30,null);
	//
	//
	// }

	public static void main(String[] args) {
		// TruckDataService truckDataService = null;
		DriverPanel dp = new DriverPanel();
		dp.run();
	}

	public void run() {
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setContentPane(this);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void processCheck(String driverId) {
		backLabel.setVisible(false);
		TextFieldCheckdriverNum.setVisible(false);

		for (int i = 0; i < this.drivers.size(); i++) {
			driverList.get(i).setVisible(false);
			nameList.get(i).setVisible(false);
			numList.get(i).setVisible(false);
		}
		changeButton.setVisible(true);
		deleteConfirmButton.setVisible(true);
		checkLabel.setVisible(true);
		returnButton.setVisible(true);
		DriverInfoVO dvo = null;

		System.out.println("checkdriverId: " + driverId);
		dvo = driverBL.getDriverInfo(driverId);
		System.out.println(dvo.getName());
		System.out.println("checkdriverId1: " + driverId);
		dvo = driverBL.getDriverInfo(driverId);
		System.out.println("name: " + dvo.getName());

		nameLabel = new JLabel(dvo.getName());
		nameLabel.setBounds(115, 195, 200, 30);
		nameLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(nameLabel, 1);

		numLabel = new JLabel(dvo.getNumber());
		numLabel.setBounds(115, 222, 200, 30);
		numLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(numLabel, 1);

		if (dvo.getSex() == Sex.MALE) {
			sexLabel = new JLabel("男");
		} else {
			sexLabel = new JLabel("女");
		}
		sexLabel.setBounds(270, 108, 200, 30);
		sexLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(sexLabel, 1);

		mobNumLabel = new JLabel(dvo.getMobNum());
		mobNumLabel.setBounds(280, 153, 200, 30);
		mobNumLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(mobNumLabel, 1);

		idLabel = new JLabel(dvo.getID());
		idLabel.setBounds(295, 193, 200, 30);
		idLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(idLabel, 1);

		dateLabel = new JLabel(dvo.getYear() + "-" + dvo.getMonth() + "-" + dvo.getDay());
		dateLabel.setBounds(295, 234, 200, 30);
		dateLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(dateLabel, 1);

		yearOfExpiringLabel = new JLabel(dvo.getYearOfExpiring() + "");
		yearOfExpiringLabel.setBounds(335, 275, 200, 30);
		yearOfExpiringLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(yearOfExpiringLabel, 1);
	}


	public void processchange() {
		changeButton.setVisible(false);
		nameLabel.setVisible(false);
		numLabel.setVisible(false);
		sexLabel.setVisible(false);
		mobNumLabel.setVisible(false);
		idLabel.setVisible(false);
		dateLabel.setVisible(false);
		yearOfExpiringLabel.setVisible(false);
		changeConfirmButton.setVisible(true);

		// DriverInfoVO dvo = null;
		// dvo = driverBL.getDriverInfo(driverId);
		changeNameField = new JTextField(nameLabel.getText());
		changeNameField.setBounds(115, 195, 80, 25);
		this.add(changeNameField, 1);
		changeNumField = new JTextField(numLabel.getText());
		changeNumField.setBounds(115, 222, 80, 25);
		this.add(changeNumField, 1);
		String[] sexString = { "男", "女" };
		changeSexBox = new JComboBox(sexString);
		changeSexBox.setSelectedItem(sexLabel.getText());
		// if(dvo.getSex() == Sex.MALE){
		// changeSexBox.setSelectedItem("男");
		// }
		// else{
		// changeSexBox.setSelectedItem("女");
		// }
		changeSexBox.setBounds(270, 108, 80, 25);
		this.add(changeSexBox, 1);
		changeMobNumField = new JTextField(mobNumLabel.getText());
		changeMobNumField.setBounds(280, 153, 100, 25);
		this.add(changeMobNumField, 1);
		changeIdField = new JTextField(idLabel.getText());
		changeIdField.setBounds(295, 193, 150, 25);
		this.add(changeIdField, 1);
		changeDateField = new JTextField(dateLabel.getText());
		changeDateField.setBounds(295, 234, 80, 25);
		this.add(changeDateField, 1);
		// System.out.println(dvo.getYearOfExpiring());
		changeYearOfExpiringField = new JTextField(yearOfExpiringLabel.getText());
		changeYearOfExpiringField.setBounds(335, 275, 80, 25);
		this.add(changeYearOfExpiringField, 1);
	}

	public void processReturn() {
		backLabel.setVisible(true);
		TextFieldCheckDriverNum.setVisible(true);
		for (int i = 0; i < this.drivers.size(); i++) {
			driverList.get(i).setVisible(true);
			nameList.get(i).setVisible(true);
			numList.get(i).setVisible(true);
		}
		changeConfirmButton.setVisible(false);
		deleteConfirmButton.setVisible(false);
		changeButton.setVisible(false);
		returnButton.setVisible(false);
		checkLabel.setVisible(false);
		nameLabel.setVisible(false);
		numLabel.setVisible(false);
		sexLabel.setVisible(false);
		mobNumLabel.setVisible(false);
		idLabel.setVisible(false);
		dateLabel.setVisible(false);
		yearOfExpiringLabel.setVisible(false);
		changeNameField.setVisible(false);
		changeNumField.setVisible(false);
		changeSexBox.setVisible(false);
		changeMobNumField.setVisible(false);
		changeIdField.setVisible(false);
		changeDateField.setVisible(false);
		changeYearOfExpiringField.setVisible(false);
	}

	public void drawDrivers() {
		drivers = driverBL.getDriverByBusinesshall("025000000");
		// driverList = new ArrayList<JButton>();
		driverList = new ArrayList<JLabel>();
		numList = new ArrayList<JLabel>();
		nameList = new ArrayList<JLabel>();
		System.out.println("size: " + drivers.size());
		for (int i = 0; i < drivers.size(); i++) {
			// JButton driver = new JButton(IMG_DRIVER);
			JLabel driver = new JLabel(IMG_DRIVER);
			driver.setBounds(40 + (i % 4) * (IMG_DRIVER.getIconWidth() + buttonToButton),
					30 + buttonToTop + (i / 4) * (height + IMG_DRIVER.getIconHeight()), IMG_DRIVER.getIconWidth(),
					IMG_DRIVER.getIconHeight());
			// driver.setBorder(null);
			driver.addMouseListener(new DriverListener());
			driverList.add(driver);
			JLabel num = new JLabel(drivers.get(i).getNumber());
			num.setBounds(40 + (i % 4) * (IMG_DRIVER.getIconWidth() + buttonToButton) + labelWidth,
					30 + buttonToTop + (i / 4) * (height + IMG_DRIVER.getIconHeight()) + numLabelHeight, 200, 30);
			numList.add(num);
			JLabel name = new JLabel(drivers.get(i).getName());
			name.setBounds(40 + (i % 4) * (IMG_DRIVER.getIconWidth() + buttonToButton) + labelWidth,
					30 + buttonToTop + (i / 4) * (height + IMG_DRIVER.getIconHeight()) + nameLabelHeight, 200, 30);
			nameList.add(name);
			this.add(numList.get(i));
			this.add(nameList.get(i));
			this.add(driverList.get(i));
		}
	}

	public void processCancel() {
		backLabel.setVisible(true);
		TextFieldCheckDriverNum.setVisible(true);
		textFieldDriverNum.setVisible(false);
		textFieldDriverNum.setText("");
		textFieldDriverName.setVisible(false);
		textFieldDriverName.setText("");
		textFieldDriverId.setVisible(false);
		textFieldDriverId.setText("");
		TextFieldCity.setVisible(false);
		TextFieldCity.setText("");
		TextFieldBusinessHall.setVisible(false);
		TextFieldBusinessHall.setText("");
		textFieldYearOfExpiring.setVisible(false);
		textFieldYearOfExpiring.setText("");
		textFieldMobNum.setVisible(false);
		textFieldMobNum.setText("");
		comboBoxSex.setVisible(false);
		cancelButton.setVisible(false);
		saveButton.setVisible(false);
		addLabel.setVisible(false);
		isActive = false;
		// System.out.println("sb");
	}
}
