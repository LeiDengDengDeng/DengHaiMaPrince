package src.presentation.nonuserui;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.nonUserbl.Driver;
import src.businesslogic.nonUserbl.DriverController;
import src.businesslogic.nonUserbl.TruckController;
import src.businesslogicservice.nonUserblservice.DriverBLService;
import src.businesslogicservice.nonUserblservice.TruckBLService;
import src.presentation.sheetui.DateChooserJButton;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

public class DriverPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2921392953374518181L;

	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	
	private JLabel checkRemind;
	private JLabel deleteRemind;
	private JLabel driverNum;
	private JLabel driverTime;
	private JLabel driverId;
	private JLabel yearOfExpiring;
	private JLabel driverName;
	private JLabel mobNum;
	private JLabel sex;
	private JTextField TextFieldCheckdriverNum;
	private JTextField textFieldDriverNum;
	private DateChooserJButton DriverTime;
	private JTextField textFieldDriverId;
	private JTextField textFieldYearOfExpiring;
	private JTextField textFieldDriverName;
	private JTextField textFieldMobNum;
	private JTextField textFieldDeletedriverNum;
	private JComboBox comboBoxSex;
	private JButton checkConfirmButton;
	private JButton addConfirmButton;
	private JButton deleteConfirmButton;
	
	private DriverBLService driverBL;
	
	public DriverPanel(){
		driverBL = new DriverController();
		checkRemind = new JLabel("请输入司机编号：");
		checkRemind.setBounds(70, 70, 200, 30);
		checkRemind.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(checkRemind);
		
		TextFieldCheckdriverNum = new JTextField();
		TextFieldCheckdriverNum.setBounds(180, 70, 150, 30);
		this.add(TextFieldCheckdriverNum);
		
		driverNum = new JLabel("司机编号：");
		driverNum.setBounds(70, 180, 400, 30);
		driverNum.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(driverNum);
		
		textFieldDriverNum = new JTextField();
		textFieldDriverNum.setBounds(180, 180, 150, 30);
		this.add(textFieldDriverNum);
		
		driverTime = new JLabel("出生日期：");
		driverTime.setBounds(70, 220, 350, 50);
		driverTime.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(driverTime);
		
		DriverTime = new DateChooserJButton();
		DriverTime.setBounds(180, 230, 150, 30);
		this.add(DriverTime);
		
		driverId = new JLabel("身份证号：");
		driverId.setBounds(70, 270, 350, 50);
		driverId.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(driverId);
		
		textFieldDriverId = new JTextField();
		textFieldDriverId.setBounds(180, 280, 150, 30);
		this.add(textFieldDriverId);
		
		yearOfExpiring = new JLabel("行驶证到期年份：");
		yearOfExpiring.setBounds(70, 320, 350, 50);
		yearOfExpiring.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(yearOfExpiring);
		
		textFieldYearOfExpiring = new JTextField();
		textFieldYearOfExpiring.setBounds(180, 330, 150, 30);
		this.add(textFieldYearOfExpiring);
		
		driverName = new JLabel("司机姓名：");
		driverName.setBounds(360, 170, 350, 50);
		driverName.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(driverName);
		
		textFieldDriverName = new JTextField();
		textFieldDriverName.setBounds(450, 180, 150, 30);
		this.add(textFieldDriverName);
		
		mobNum = new JLabel("手机号：");
		mobNum.setBounds(360, 220, 350, 50);
		mobNum.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(mobNum);
		
		textFieldMobNum = new JTextField();
		textFieldMobNum.setBounds(450, 230, 150, 30);
		this.add(textFieldMobNum);
		
		sex = new JLabel("性别：");
		sex.setBounds(360, 270, 350, 50);
		sex.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(sex);
		
		String[] sexString = {"男","女"};
		comboBoxSex = new JComboBox(sexString);
		comboBoxSex.setBounds(450, 280, 150, 30);
		this.add(comboBoxSex);
		
		deleteRemind = new JLabel("请输入司机编号：");
		deleteRemind.setBounds(70, 400, 350, 50);
		deleteRemind.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(deleteRemind);
		
		textFieldDeletedriverNum = new JTextField();
		textFieldDeletedriverNum.setBounds(180, 410, 150, 30);
		this.add(textFieldDeletedriverNum);
		
		checkConfirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener = new ConfirmButtonListener(this);
		checkConfirmButton.addActionListener(listener);
		checkConfirmButton.setBounds(500, 120, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(checkConfirmButton);
		
		addConfirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener2 = new ConfirmButtonListener(this);
		addConfirmButton.addActionListener(listener2);
		addConfirmButton.setBounds(500, 340, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(addConfirmButton);
		
		deleteConfirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener3 = new ConfirmButtonListener(this);
		deleteConfirmButton.addActionListener(listener3);
		deleteConfirmButton.setBounds(500, 450, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(deleteConfirmButton);
		
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
				DriverInfoVO dvo = null;
				String driverId = TextFieldCheckdriverNum.getText();
				System.out.println("checkdriverId: " + driverId);
				dvo = driverBL.getDriverInfo(driverId);
			}
			if(e.getSource() == addConfirmButton){
//				DriverInfoVO dvo = null;
//				long number = Long.parseLong(textFieldDriverNum.getText());
//				int activeTime = Integer.parseInt(textFieldDriverTime.getText());
//				String driverId = textFieldDriverId.getText();
//				tvo = new TruckInfoVO(number, activeTime, driverId);
//				truckBL.addTruckInfo(tvo);
			}
			if(e.getSource() == deleteConfirmButton){
				String driverId = textFieldDeletedriverNum.getText();
				System.out.println("deletedriverId: " + driverId);
				driverBL.deleteDriverInfo(driverId);
			}
		}
		
	}
	
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
