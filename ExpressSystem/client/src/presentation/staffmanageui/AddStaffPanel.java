package src.presentation.staffmanageui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.nonUserbl.IntermediateCenter;
import src.businesslogic.staffmanagebl.Position;
import src.businesslogic.staffmanagebl.StaffManage;
import src.businesslogic.userbl.User;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.StaffInfoVO;

public class AddStaffPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6824862242471768878L;
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 95;
	static final int y = 64;
	static final int w = 130;
	static final int h = 16;
	static final int linesp = 49;
	static final int columnsp = 250;
	static final int coordinate_X = 40;
	static final int coordinate_Y = 40;
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");

	private	JTextField ID;
	private	JTextField account;
	private	JTextField password;
	private	JTextField name;
	private	JTextField position;
	private	JComboBox<String> city;
	private	JTextField businessHall;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
	
	long staffID;
	long staffAccount;
	String staffPassword;
	String staffName;
	String staffPosition;
	String staffCity;
	String staffbusinessHall;
	
	MyButton cancelButton;
	MyButton confirmButton;
	StaffListPanel staffManagePanel;
	StaffManage staffManage;
	IntermediateCenter intermediateCenter;
	
	public AddStaffPanel(){
		componentsInstantiation();
		
		MyButtonActionListener listener = new MyButtonActionListener(this);
        confirmButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
        
		initial();
	}
	
//	public static void main(String[] args){
//		AddStaffPanel staffInfoPanel = new AddStaffPanel();
//	}
//	
	
	public void initial(){
		
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
		name.setBounds(coordinate_X + x, coordinate_Y + y, w, h);
		position.setBounds(coordinate_X + x + columnsp, coordinate_Y + y, w, h);
		ID.setBounds(coordinate_X + x, coordinate_Y + y + linesp, w, h);
		account.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 2, w, h);
		password.setBounds(coordinate_X + x + columnsp, coordinate_Y + y + linesp * 2, w, h);
		city.setBounds(coordinate_X + x + 10, coordinate_Y + y + linesp * 3 - 3, 60, h + 8);
		businessHall.setBounds(coordinate_X + x + columnsp + 13, coordinate_Y + y + linesp * 3, w, h);
		

		city.setModel(new DefaultComboBoxModel<String>(getCitys()));
		
		this.add(confirmButton);
		this.add(cancelButton);
		this.add(ID);
		this.add(account);
		this.add(name);
		this.add(password);
		this.add(position);
		this.add(city);
		this.add(businessHall);
		this.add(imageLabel);

		this.setLayout(null);
		this.setOpaque(false);
		
		
	}
	
	public void componentsInstantiation(){
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/staff_InfoBG.png");
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 450, coordinate_Y + 480, false);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, coordinate_X + 350, coordinate_Y + 480, false);
		ID = new JTextField();
		account = new JTextField();
		password = new JTextField();
		name = new JTextField();
		position = new JTextField();
		city = new JComboBox<String>();
		businessHall = new JTextField();
		staffManage = new StaffManage(null, new Position(new User(null)));
		intermediateCenter = new IntermediateCenter(null);
	}
	
	
	//获得城市列表
	public String[] getCitys(){
		ArrayList<String> citys = intermediateCenter.getcity();
		String[] cityList = new String[citys.size() + 1];
		cityList[0] = "无";
		for(int i = 0;i < citys.size();i++)
			cityList[i + 1] = citys.get(i);
		return cityList;
		
	}
	
	
	//获得填写的信息
	public void getInfo(){
		staffID = Long.parseLong(ID.getText());
		staffAccount = Long.parseLong(account.getText());
		staffPassword = password.getText();
		staffName = name.getText();
		staffPosition = position.getText();
		staffCity = (String) city.getSelectedItem();
		staffbusinessHall = businessHall.getText();
		
	}
	
	
	  class MyButtonActionListener implements ActionListener {
	       AddStaffPanel container;
		       
	        public MyButtonActionListener(AddStaffPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		           if(e.getSource() == confirmButton){
		        	   if(ID.getText().length() == 0 || account.getText().length() == 0
		        			   || password.getText().length() == 0 || name.getText().length() == 0
		        			   || position.getText().length() == 0){
		        		   TipDialog tipDialog = new TipDialog(null, "", true, "请完整填写！", false);
		           		}else{
		           			getInfo();
		           			if(businessHall.getText().length() == 0)
		           				staffbusinessHall = null;
		           			if(city.getSelectedItem().equals("无"))
		           				staffCity = null;
		           			staffManage.addStaffInfo(new StaffInfoVO(staffID, staffAccount, staffPassword,
		           					staffName, staffPosition, null, staffCity, staffbusinessHall));
		           		}
		           }else if(e.getSource() == cancelButton){
		        	   PanelController.setPresentPanel(new StaffListPanel());
		           }
		           
		        	   

//		            container.repaint();
		        }
		    }
}
