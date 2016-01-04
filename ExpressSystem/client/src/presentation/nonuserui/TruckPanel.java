package src.presentation.nonuserui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.nonUserbl.TruckController;
import src.businesslogicservice.nonUserblservice.TruckBLService;
import src.presentation.util.TipDialog;
import src.vo.TruckInfoVO;

public class TruckPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2921392953374518181L;

	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	
	protected static final ImageIcon IMG_BG = new ImageIcon("images/truck_bg.png");
	protected static final ImageIcon IMG_CHANGECONFIRM = new ImageIcon("images/driverchangeconfirmbutton.png");
	protected static final ImageIcon IMG_TRUCK = new ImageIcon("images/truck.png");
	
	protected static final int buttonToButton = 27;//车辆图标之间的横向间距
	protected static final int height = 18;//车辆图标之间的纵向间距
	protected static final int buttonToTop = 55;//第一排车辆图标到最顶层的间距
	protected static final int numLabelHeight = 93;//按钮顶端到编号的距离
	protected static final int labelWidth = 51;//按钮左边到姓名编号的距离
	
	private ImageIcon addbkgImg;
	private ImageIcon checkbkgImg;
	private JLabel backLabel;
	private JLabel addLabel;
	private JLabel checkLabel;
	private JLabel numLabel;
	private JLabel activeTimeLabel;
	private JLabel licensePlateNumLabel;
	private JTextField changeNumField;
	private JTextField changeActiveTimeField;
	private JTextField changeLicensePlateNumField;
	private JTextField TextFieldCheckTruckNum;
	private JTextField TextFieldActiveTime;
	private JTextField textFieldTruckNumber;
	private JTextField textFieldLicensePlateNum;
	private JButton checkConfirmButton;
	private JButton addConfirmButton;
	private JButton deleteConfirmButton;
	private JButton cancelButton;
	private JButton saveButton;
	private JButton returnButton;
	private JButton changeButton;
	private JButton changeConfirmButton;
//	private ArrayList<JButton> truckList;
	private ArrayList<JLabel> truckList;
	private ArrayList<JLabel> numList;
	private ArrayList<TruckInfoVO> trucks;
	private TruckBLService truckBL;
	private boolean isActive;
	
	public TruckPanel(){
		System.out.println();
		truckBL = new TruckController();
		
		TextFieldCheckTruckNum = new JTextField();
		TextFieldCheckTruckNum.setBounds(140, 30, 200, 28);
		this.add(TextFieldCheckTruckNum);
		
		textFieldTruckNumber = new JTextField();
		textFieldTruckNumber.setBounds(125, 65, 80, 25);
		textFieldTruckNumber.setVisible(false);
		this.add(textFieldTruckNumber);
		
		TextFieldActiveTime = new JTextField();
		TextFieldActiveTime.setBounds(125, 95, 80, 25);
		TextFieldActiveTime.setVisible(false);
		this.add(TextFieldActiveTime);
		
		textFieldLicensePlateNum = new JTextField();
		textFieldLicensePlateNum.setBounds(125, 125, 80, 25);
		textFieldLicensePlateNum.setVisible(false);
		this.add(textFieldLicensePlateNum);
		
		changeNumField = new JTextField();
		changeActiveTimeField = new JTextField();
		changeLicensePlateNumField = new JTextField();
		
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
		addbkgImg = new ImageIcon("images/truckadd2_bg.png");
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
		checkbkgImg = new ImageIcon("images/truckcheck_bg.png");
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
		
		drawTrucks();
		
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
	}
	
	class ConfirmButtonListener implements ActionListener{

		TruckPanel dPanel;
		
		public ConfirmButtonListener(TruckPanel dPanel){
			this.dPanel = dPanel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == checkConfirmButton){
				String truckId = TextFieldCheckTruckNum.getText();
				TruckInfoVO tvo = truckBL.getTruckInfo(truckId);
				if(truckId.equals("")){
					new TipDialog(null, "", true, "请输入车辆代号！", false);
				}
				else if(tvo == null){
					new TipDialog(null, "", true, "车辆代号不存在！", false);
				}
				else{
					processCheck(truckId);
				}
				
			}
			if(e.getSource() == addConfirmButton){
//				DriverInfoVO dvo = null;
//				long number = Long.parseLong(textFieldDriverNum.getText());
//				int activeTime = Integer.parseInt(textFieldDriverTime.getText());
//				String driverId = textFieldDriverId.getText();
//				tvo = new TruckInfoVO(number, activeTime, driverId);
//				truckBL.addTruckInfo(tvo);
				backLabel.setVisible(false);
				TextFieldCheckTruckNum.setVisible(false);
				textFieldTruckNumber.setVisible(true);
				TextFieldActiveTime.setVisible(true);
				textFieldLicensePlateNum.setVisible(true);
				cancelButton.setVisible(true);
				saveButton.setVisible(true);
				addLabel.setVisible(true);
				isActive = true;
//				System.out.println("sb");
			}
			if(e.getSource() == deleteConfirmButton){
				String truckId = numLabel.getText();
				System.out.println("deletetruckId: " + truckId);
				processReturn();
				for(int i = 0;i < trucks.size();i++) {
					dPanel.remove(truckList.get(i));
					dPanel.remove(numList.get(i));
				}
				truckBL.deleteTruckInfo(truckId);
				drawTrucks();
				dPanel.repaint();
			}
			if(e.getSource() == cancelButton){
				processCancel();
			}
			if(e.getSource() == saveButton){
				System.out.println("sb");
				String number = textFieldTruckNumber.getText();
				String activeTime = TextFieldActiveTime.getText();
				String licensePlateNum = textFieldLicensePlateNum.getText();
				if(number.equals("")||activeTime.equals("")||licensePlateNum.equals("")){
					new TipDialog(null, "", true, "车辆信息未填写完整！", false);
				}
				else if((!isNumeric(number))||(number.length() != 9)){
					new TipDialog(null, "", true, "车辆代号格式不正确！", false);
				}
				else if(!isNumeric(activeTime)){
					new TipDialog(null, "", true, "服役时间格式不正确！", false);
				}
				else{
					TruckInfoVO tvo = new TruckInfoVO(number, Integer.parseInt(activeTime), licensePlateNum);
					truckBL.addTruckInfo(tvo);
					new TipDialog(null, "", true, "车辆信息已保存！", true);
					processCancel();
					for(int i = 0;i < trucks.size();i++) {
						dPanel.remove(truckList.get(i));
						dPanel.remove(numList.get(i));
					}
					drawTrucks();
					dPanel.repaint();
				}
				
			}
			if(e.getSource() == returnButton){
				processReturn();
			}
			if(e.getSource() == changeButton){
				processChange();
			}
			if(e.getSource() == changeConfirmButton){
				String number = changeNumField.getText();
				String activeTime = changeActiveTimeField.getText();
				String licensePlateNum = changeLicensePlateNumField.getText();
				if(number.equals("")||activeTime.equals("")||licensePlateNum.equals("")){
					new TipDialog(null, "", true, "车辆信息未填写完整！", false);
				}
				else if((!isNumeric(number))||(number.length() != 9)){
					new TipDialog(null, "", true, "车辆代号格式不正确！", false);
				}
				else if(!isNumeric(activeTime)){
					new TipDialog(null, "", true, "服役时间格式不正确！", false);
				}
				else{
					TruckInfoVO tvo = new TruckInfoVO(number, Integer.parseInt(activeTime), licensePlateNum);
					truckBL.changeTruckInfo(number, tvo);
					new TipDialog(null, "", true, "车辆信息已完成更改！", true);
					changeConfirmButton.setVisible(false);
					changeButton.setVisible(true);
					
					numLabel.setText(changeNumField.getText());
					changeNumField.setVisible(false);
					numLabel.setVisible(true);
					
					activeTimeLabel.setText(changeActiveTimeField.getText());
					changeActiveTimeField.setVisible(false);
					activeTimeLabel.setVisible(true);
					
					licensePlateNumLabel.setText(changeLicensePlateNumField.getText());
					changeLicensePlateNumField.setVisible(false);
					licensePlateNumLabel.setVisible(true);
				}
				
			}
		}
		
	}
	
	class truckListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if (isActive) {
				return;
			}
			
			for(int i = 0;i < truckList.size();i++){
				if (e.getSource() == truckList.get(i))
					processCheck(numList.get(i).getText());
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
		TruckPanel dp = new TruckPanel();
		dp.run();
	}
	
	public void run(){
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setContentPane(this);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void processCheck(String truckId) {
		backLabel.setVisible(false);
		TextFieldCheckTruckNum.setVisible(false);
		for(int i = 0;i < this.trucks.size();i++){
			truckList.get(i).setVisible(false);
			numList.get(i).setVisible(false);
		}
		changeButton.setVisible(true);
		deleteConfirmButton.setVisible(true);
		checkLabel.setVisible(true);
		returnButton.setVisible(true);
		TruckInfoVO tvo = null;
		
		System.out.println("checktruckId: " + truckId);
		tvo = truckBL.getTruckInfo(truckId);
		
		numLabel = new JLabel(tvo.getNumber());
		numLabel.setBounds(80, 240, 200, 30);
		numLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(numLabel,1);
		
		activeTimeLabel = new JLabel(tvo.getActiveTime() + "");
		activeTimeLabel.setBounds(330, 160, 200, 30);
		activeTimeLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(activeTimeLabel,1);
		
		licensePlateNumLabel = new JLabel(tvo.getLicensePlateNum());
		licensePlateNumLabel.setBounds(330, 255, 200, 30);
		licensePlateNumLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(licensePlateNumLabel,1);
	}
	
	public void processChange(){
		changeButton.setVisible(false);
		numLabel.setVisible(false);
		licensePlateNumLabel.setVisible(false);
		changeConfirmButton.setVisible(true);
		
//		TruckInfoVO tvo = null;
//		String driverId = TextFieldCheckTruckNum.getText();
		changeNumField = new JTextField(numLabel.getText());
		changeNumField.setBounds(80, 240, 80, 25);
		this.add(changeNumField,1);
		changeActiveTimeField = new JTextField(activeTimeLabel.getText());
		changeActiveTimeField.setBounds(330, 160, 100, 25);
		this.add(changeActiveTimeField,1);
		changeLicensePlateNumField = new JTextField(licensePlateNumLabel.getText());
		changeLicensePlateNumField.setBounds(330, 255, 80, 25);
		this.add(changeLicensePlateNumField,1);
	}
	
	public void processReturn(){
		backLabel.setVisible(true);
		TextFieldCheckTruckNum.setVisible(true);
		for(int i = 0;i < this.trucks.size();i++){
			truckList.get(i).setVisible(true);
			numList.get(i).setVisible(true);
		}
		changeConfirmButton.setVisible(false);
		deleteConfirmButton.setVisible(false);
		changeButton.setVisible(false);
		returnButton.setVisible(false);
		checkLabel.setVisible(false);
		numLabel.setVisible(false);
		activeTimeLabel.setVisible(false);
		licensePlateNumLabel.setVisible(false);
		changeNumField.setVisible(false);
		changeActiveTimeField.setVisible(false);
		changeLicensePlateNumField.setVisible(false);
	}
	
	public void drawTrucks(){
		trucks = truckBL.getTruckByBusinesshall("025000000");
//		truckList = new ArrayList<JButton>();
		truckList = new ArrayList<JLabel>();
		numList = new ArrayList<JLabel>();
		for(int i = 0;i < trucks.size();i++){
//			JButton driver  = new JButton(IMG_TRUCK);
			JLabel driver  = new JLabel(IMG_TRUCK);
			driver.setBounds(40 + (i%4)*(IMG_TRUCK.getIconWidth() + buttonToButton), 
					30 + buttonToTop + (i/4)*(height + IMG_TRUCK.getIconHeight()), 
					IMG_TRUCK.getIconWidth(), IMG_TRUCK.getIconHeight());
//			driver.setBorder(null);
			driver.addMouseListener(new truckListener());
			truckList.add(driver);
			JLabel num = new JLabel(trucks.get(i).getNumber());
			num.setBounds(40 + (i%4)*(IMG_TRUCK.getIconWidth() + 
					buttonToButton) + labelWidth, 30 + 
					buttonToTop + (i/4)*(height + IMG_TRUCK.getIconHeight())
					+ numLabelHeight, 200, 30);
			numList.add(num);
			this.add(numList.get(i));
			this.add(truckList.get(i));
		}
	}
	
	public void processCancel(){
		backLabel.setVisible(true);
		TextFieldCheckTruckNum.setVisible(true);
		textFieldTruckNumber.setVisible(false);
		textFieldTruckNumber.setText("");
		TextFieldActiveTime.setVisible(false);
		TextFieldActiveTime.setText("");
		textFieldLicensePlateNum.setVisible(false);
		textFieldLicensePlateNum.setText("");
		cancelButton.setVisible(false);
		saveButton.setVisible(false);
		addLabel.setVisible(false);
		isActive = false;
//		System.out.println("sb");
	}
	
	public boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		   System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }
}
