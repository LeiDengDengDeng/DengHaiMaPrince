package src.presentation.nonuserui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class DriverPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2921392953374518181L;

	protected static final int x = 195;// panel Î»ÖÃx
	protected static final int y = 59;// panel Î»ÖÃy
	protected static final int w = 641;// panel¿í
	protected static final int h = 572;// panel¸ß
	
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	protected static final ImageIcon IMG_BG = new ImageIcon("images/driver_bg.png");
	
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
	private JTextField changeSexField;
	private JTextField changeMobNumField;
	private JTextField changeIdField;
	private JTextField changeDateField;
	private JTextField TextFieldCheckdriverNum;
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
	
	private DriverBLService driverBL;
	
	public DriverPanel(){
		driverBL = new DriverController();
		
		TextFieldCheckdriverNum = new JTextField();
		TextFieldCheckdriverNum.setBounds(140, 30, 200, 28);
		this.add(TextFieldCheckdriverNum);
		
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
		
		String[] sexString = {"ÄÐ","Å®"};
		comboBoxSex = new JComboBox(sexString);
		comboBoxSex.setBounds(245, 65, 70, 25);
		comboBoxSex.setVisible(false);
		this.add(comboBoxSex);
		
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
		deleteConfirmButton.setBounds(500, 340, 70,
				28);
		deleteConfirmButton.setContentAreaFilled(false);
		deleteConfirmButton.setBorder(null);
		deleteConfirmButton.setVisible(false);
		this.add(deleteConfirmButton);
		
		changeButton = new JButton();
		changeButton.addActionListener(listener);
		changeButton.setBounds(415, 340, 72, 28);
		changeButton.setContentAreaFilled(false);
//		changeButton.setBorder(null);
		changeButton.setVisible(false);
		this.add(changeButton);
		
		checkLabel = new JLabel();
		checkbkgImg = new ImageIcon("images/drivercheck2_bg.png");
		checkLabel.setIcon(checkbkgImg);
		checkLabel.setBounds(40, 59, checkbkgImg.getIconWidth(), checkbkgImg.getIconHeight());
		checkLabel.setVisible(false);
		this.add(checkLabel);
		
		checkConfirmButton = new JButton();
		checkConfirmButton.addActionListener(listener);
		checkConfirmButton.setBounds(400, 30, 65, 
				28);
		checkConfirmButton.setContentAreaFilled (false);
		checkConfirmButton.setBorder(null);
		this.add(checkConfirmButton);
		
		addConfirmButton = new JButton();
		addConfirmButton.addActionListener(listener);
//		System.out.println(IMG_CONFIRM.getIconWidth()+" "+IMG_CONFIRM.getIconHeight());
		addConfirmButton.setBounds(480, 30, 100, 
				28);
		addConfirmButton.setContentAreaFilled (false);
		addConfirmButton.setBorder(null);
		this.add(addConfirmButton);
		
		
		backLabel = new JLabel();
		backLabel.setIcon(IMG_BG);
		backLabel.setBounds(40, 30, IMG_BG.getIconWidth(), IMG_BG.getIconHeight());
		this.add(backLabel);
		
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
	}
	
	class ConfirmButtonListener implements ActionListener{

		DriverPanel dPanel;
		
		public ConfirmButtonListener(DriverPanel dPanel){
			this.dPanel = dPanel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == checkConfirmButton){
				backLabel.setVisible(false);
				TextFieldCheckdriverNum.setVisible(false);
				changeButton.setVisible(true);
				deleteConfirmButton.setVisible(true);
				checkLabel.setVisible(true);
				returnButton.setVisible(true);
				DriverInfoVO dvo = null;
				String driverId = TextFieldCheckdriverNum.getText();
				System.out.println("checkdriverId: " + driverId);
				dvo = driverBL.getDriverInfo(driverId);
				System.out.println(dvo.getName());
				
				nameLabel = new JLabel(dvo.getName());
				nameLabel.setBounds(115, 195, 200, 30);
				nameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
				dPanel.add(nameLabel, 1);
				
				numLabel = new JLabel(dvo.getNumber());
				numLabel.setBounds(115, 222, 200, 30);
				numLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
				dPanel.add(numLabel,1);
				
				if(dvo.getSex() == Sex.MALE){
					sexLabel = new JLabel("ÄÐ");
				}
				else{
					sexLabel = new JLabel("Å®");
				}
				sexLabel.setBounds(270, 108, 200, 30);
				sexLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
				dPanel.add(sexLabel,1);
				
				mobNumLabel = new JLabel(dvo.getMobNum());
				mobNumLabel.setBounds(280, 153, 200, 30);
				mobNumLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
				dPanel.add(mobNumLabel,1);
				
				idLabel = new JLabel(dvo.getID());
				idLabel.setBounds(295, 193, 200, 30);
				idLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
				dPanel.add(idLabel,1);
				
				dateLabel = new JLabel(dvo.getYear() + "-" + dvo.getMonth() + "-" + dvo.getDay());
				dateLabel.setBounds(295, 234, 200, 30);
				dateLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
				dPanel.add(dateLabel,1);
				
				yearOfExpiringLabel = new JLabel(dvo.getYearOfExpiring() + "");
				yearOfExpiringLabel.setBounds(335, 275, 200, 30);
				yearOfExpiringLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
				dPanel.add(yearOfExpiringLabel,1);
				
			}
			if(e.getSource() == addConfirmButton){
//				DriverInfoVO dvo = null;
//				long number = Long.parseLong(textFieldDriverNum.getText());
//				int activeTime = Integer.parseInt(textFieldDriverTime.getText());
//				String driverId = textFieldDriverId.getText();
//				tvo = new TruckInfoVO(number, activeTime, driverId);
//				truckBL.addTruckInfo(tvo);
				backLabel.setVisible(false);
				TextFieldCheckdriverNum.setVisible(false);
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
//				System.out.println("sb");
			}
			if(e.getSource() == deleteConfirmButton){
				String driverId = TextFieldCheckdriverNum.getText();
				System.out.println("deletedriverId: " + driverId);
//				driverBL.deleteDriverInfo(driverId);
			}
			if(e.getSource() == cancelButton){
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
//				System.out.println("sb");
			}
			if(e.getSource() == saveButton){
				System.out.println("sb");
				String name = textFieldDriverName.getText();
				String sexString = (String) comboBoxSex.getSelectedItem();
				Sex sex = null;
				if(sexString.equals("ÄÐ")){
					sex = Sex.MALE;
				}
				else{
					sex = sex.FEMALE;
				}
				String id = textFieldDriverId.getText();
				String city = TextFieldCity.getText();
				String businessHall = TextFieldBusinessHall.getText();
				String num = textFieldDriverNum.getText();
				String mobNum = textFieldMobNum.getText();
				String yearOfExpiring = textFieldYearOfExpiring.getText();
				DriverInfoVO dvo = new DriverInfoVO(num, name, Integer.parseInt(id.substring(6, 10)), 
						Integer.parseInt(id.substring(10, 12)), Integer.parseInt(id.substring(12, 14)),
						id, mobNum, sex, Integer.parseInt(yearOfExpiring));
//				System.out.println(dvo.getName() + " " + dvo.getSex());
//				System.out.println(dvo.getYear() + " " + dvo.getMonth() + " " + dvo.getDay());
//				driverBL.addDriverInfo(dvo);
			}
			if(e.getSource() == returnButton){
				backLabel.setVisible(true);
				TextFieldCheckdriverNum.setVisible(true);
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
			}
			if(e.getSource() == changeButton){
				
			}
		}
		
	}
	
//	public void paintComponent(Graphics g) 
//	{ 
//	super.paintComponent(g); 
//
//
//	g.drawImage(IMG_BG.getImage(),40, 30,null);
//
//
//	}
	
	public static void main(String[] args) {
//		TruckDataService truckDataService = null;
		DriverPanel dp = new DriverPanel();
		dp.run();
	}
	
	public void run(){
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setContentPane(this);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
