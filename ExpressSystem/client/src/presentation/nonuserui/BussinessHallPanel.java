package src.presentation.nonuserui;

import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import src.businesslogic.nonUserbl.BussinessHallController;
import src.businesslogicservice.nonUserblservice.BussinessHallBLService;
import src.presentation.util.TipDialog;
import src.vo.BussinessHallVO;

public class BussinessHallPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2921392953374518181L;

	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	
	protected static final ImageIcon IMG_BG = new ImageIcon("images/businesshall_bg.png");
	protected static final ImageIcon IMG_CHANGECONFIRM = new ImageIcon("images/driverchangeconfirmbutton.png");
	protected static final ImageIcon IMG_TRUCK = new ImageIcon("images/truck.png");
	
	protected static final int buttonToButton = 27;//营业厅图标之间的横向间距
	protected static final int height = 18;//营业厅图标之间的纵向间距
	protected static final int buttonToTop = 55;//第一排营业厅图标到最顶层的间距
	protected static final int numLabelHeight = 93;//按钮顶端到编号的距离
	protected static final int labelWidth = 51;//按钮左边到姓名编号的距离
	
	private ImageIcon addbkgImg;
	private ImageIcon checkbkgImg;
	private JLabel backLabel;
	private JLabel addLabel;
	private JLabel checkLabel;
	private JLabel numLabel;
	private JLabel nameLabel;
	private JTextField TextFieldCheckBusinessNum;
	private JTextField TextFieldHallName;
	private JTextField textFieldHallId;
	private JButton checkConfirmButton;
	private JButton addConfirmButton;
	private JButton deleteConfirmButton;
	private JButton cancelButton;
	private JButton saveButton;
	private JButton returnButton;
	private JButton changeConfirmButton;
//	private ArrayList<JButton> businesshallList;
	private ArrayList<JLabel> businesshallList;
	private ArrayList<JLabel> nameList;
	private ArrayList<BussinessHallVO> businesshalls;
	private ArrayList<String> numList;
	private BussinessHallBLService businesshallBL;
	private boolean isActive;
	
	public BussinessHallPanel(){
		System.out.println();
		businesshallBL = new BussinessHallController();
		
		TextFieldCheckBusinessNum = new JTextField();
		TextFieldCheckBusinessNum.setBounds(160, 30, 200, 28);
		this.add(TextFieldCheckBusinessNum);
		
		textFieldHallId = new JTextField();
		textFieldHallId.setBounds(140, 115, 80, 25);
		textFieldHallId.setVisible(false);
		this.add(textFieldHallId);
		
		TextFieldHallName = new JTextField();
		TextFieldHallName.setBounds(140, 70, 80, 25);
		TextFieldHallName.setVisible(false);
		this.add(TextFieldHallName);
		
		
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
		addbkgImg = new ImageIcon("images/businesshalladd2_bg.png");
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
		
		changeConfirmButton = new JButton(IMG_CHANGECONFIRM);
		changeConfirmButton.addActionListener(listener);
		changeConfirmButton.setBounds(270, 342, IMG_CHANGECONFIRM.getIconWidth(), IMG_CHANGECONFIRM.getIconHeight());
		changeConfirmButton.setBorder(null);
		changeConfirmButton.setVisible(false);
		this.add(changeConfirmButton);
		
		checkLabel = new JLabel();
		checkbkgImg = new ImageIcon("images/businesshallcheck_bg.png");
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
		
		drawTBusinessHalls();
		
		this.setPreferredSize(new Dimension(200,200));
		JScrollPane scrollPane = new JScrollPane(this);
	    scrollPane.setBounds(10, 10, 175, 70);
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
	}
	
	class ConfirmButtonListener implements ActionListener{

		BussinessHallPanel dPanel;
		
		public ConfirmButtonListener(BussinessHallPanel dPanel){
			this.dPanel = dPanel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == checkConfirmButton){
				String hallId = TextFieldCheckBusinessNum.getText();
				BussinessHallVO bvo = businesshallBL.getBussinessHallInfo(hallId);
				if(hallId.equals("")){
					new TipDialog(null, "", true, "请输入营业厅编号！", false);
				}
				else if(bvo == null){
					new TipDialog(null, "", true, "营业厅编号不存在！", false);
				}
				else{
					processCheck(hallId);
				}
				
			}
			if(e.getSource() == addConfirmButton){
//				DriverInfoVO dvo = null;
//				long number = Long.parseLong(textFieldDriverNum.getText());
//				int activeTime = Integer.parseInt(textFieldDriverTime.getText());
//				String driverId = textFieldDriverId.getText();
//				tvo = new TruckInfoVO(number, activeTime, driverId);
//				businesshallBL.addTruckInfo(tvo);
				backLabel.setVisible(false);
				TextFieldCheckBusinessNum.setVisible(false);
				textFieldHallId.setVisible(true);
				TextFieldHallName.setVisible(true);
				cancelButton.setVisible(true);
				saveButton.setVisible(true);
				addLabel.setVisible(true);
				isActive = true;
//				System.out.println("sb");
			}
			if(e.getSource() == deleteConfirmButton){
				String bussinessHallId = numLabel.getText();
				System.out.println("deletebussinessHallId: " + bussinessHallId);
				processReturn();
				for(int i = 0;i < businesshalls.size();i++) {
					dPanel.remove(businesshallList.get(i));
					dPanel.remove(nameList.get(i));
				}
				businesshallBL.deleteBussinessHallInfo(bussinessHallId);
				drawTBusinessHalls();
				dPanel.repaint();
			}
			if(e.getSource() == cancelButton){
				processCancel();
			}
			if(e.getSource() == saveButton){
				System.out.println("sb");
				String hallId = textFieldHallId.getText();
				String hallName = TextFieldHallName.getText();
				if(hallId.equals("")||hallName.equals("")){
					new TipDialog(null, "", true, "营业厅信息未填写完整！", false);
				}
				else if((!isNumeric(hallId))||(hallId.length() != 6)){
					new TipDialog(null, "", true, "营业厅编号格式不正确！", false);
				}
				else{
					BussinessHallVO bvo = new BussinessHallVO(hallName, hallId, null, null);
					businesshallBL.addBussinessHallInfo(bvo);
					new TipDialog(null, "", true, "营业厅信息已保存！", true);
					processCancel();
					for(int i = 0;i < businesshalls.size();i++) {
						dPanel.remove(businesshallList.get(i));
						dPanel.remove(nameList.get(i));
					}
					drawTBusinessHalls();
					dPanel.repaint();
				}
				
			}
			if(e.getSource() == returnButton){
				processReturn();
			}
		}
		
	}
	
	class businesshallListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if (isActive) {
				return;
			}
			
			for(int i = 0;i < businesshallList.size();i++){
				if (e.getSource() == businesshallList.get(i))
					processCheck(numList.get(i));
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
		BussinessHallPanel dp = new BussinessHallPanel();
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
	
	public void processCheck(String bussinessHallId) {
		backLabel.setVisible(false);
		TextFieldCheckBusinessNum.setVisible(false);
		for(int i = 0;i < this.businesshalls.size();i++){
			businesshallList.get(i).setVisible(false);
			nameList.get(i).setVisible(false);
		}
		deleteConfirmButton.setVisible(true);
		checkLabel.setVisible(true);
		returnButton.setVisible(true);
		BussinessHallVO bvo = null;
		
		System.out.println("checkbussinessHallId: " + bussinessHallId);
		bvo = businesshallBL.getBussinessHallInfo(bussinessHallId);
		
		numLabel = new JLabel(bvo.getHallId());
		numLabel.setBounds(320, 248, 200, 30);
		numLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(numLabel,1);
		
		nameLabel = new JLabel(bvo.getHallName());
		nameLabel.setBounds(320, 132, 200, 30);
		nameLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(nameLabel,1);
	}
	
	public void processReturn(){
		backLabel.setVisible(true);
		TextFieldCheckBusinessNum.setVisible(true);
		for(int i = 0;i < this.businesshalls.size();i++){
			businesshallList.get(i).setVisible(true);
			nameList.get(i).setVisible(true);
		}
		changeConfirmButton.setVisible(false);
		deleteConfirmButton.setVisible(false);
		returnButton.setVisible(false);
		checkLabel.setVisible(false);
		numLabel.setVisible(false);
		nameLabel.setVisible(false);
	}
	
	public void drawTBusinessHalls(){
		businesshalls = businesshallBL.getAllBussinessHallInfo();
//		businesshallList = new ArrayList<JButton>();
		businesshallList = new ArrayList<JLabel>();
		nameList = new ArrayList<JLabel>();
		numList = new ArrayList<String>();
		for(int i = 0;i < businesshalls.size();i++){
//			JButton driver  = new JButton(IMG_TRUCK);
			JLabel driver  = new JLabel(IMG_TRUCK);
			driver.setBounds(40 + (i%4)*(IMG_TRUCK.getIconWidth() + buttonToButton), 
					30 + buttonToTop + (i/4)*(height + IMG_TRUCK.getIconHeight()), 
					IMG_TRUCK.getIconWidth(), IMG_TRUCK.getIconHeight());
//			driver.setBorder(null);
			driver.addMouseListener(new businesshallListener());
			businesshallList.add(driver);
			JLabel name = new JLabel(businesshalls.get(i).getHallName());
			String hallNum = businesshalls.get(i).getHallId();
			name.setBounds(40 + (i%4)*(IMG_TRUCK.getIconWidth() + 
					buttonToButton) + labelWidth, 30 + 
					buttonToTop + (i/4)*(height + IMG_TRUCK.getIconHeight())
					+ numLabelHeight, 200, 30);
			nameList.add(name);
			numList.add(hallNum);
			this.add(nameList.get(i));
			this.add(businesshallList.get(i));
		}
	}
	
	public void processCancel(){
		backLabel.setVisible(true);
		TextFieldCheckBusinessNum.setVisible(true);
		textFieldHallId.setVisible(false);
		textFieldHallId.setText("");
		TextFieldHallName.setVisible(false);
		TextFieldHallName.setText("");
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
