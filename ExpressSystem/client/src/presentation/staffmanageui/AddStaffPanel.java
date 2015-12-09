package src.presentation.staffmanageui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.presentation.util.MyButton;

public class AddStaffPanel{

	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 95;
	static final int y = 64;
	static final int w = 170;
	static final int h = 16;
	static final int linesp = 49;
	static final int columnsp = 250;
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");

	private JFrame frame;
	private	JTextField ID;
	private	JTextField account;
	private	JTextField password;
	private	JTextField name;
	private	JTextField position;
	private	JTextField city;
	private	JTextField businessHall;
	
	long staffID;
	long staffAccount;
	String staffPassword;
	String staffName;
	String staffPosition;
	String staffCity;
	String staffbusinessHall;
	
	MyButton cancelButton;
	MyButton confirmButton;
	MainPanel mainPanel;
	StaffListPanel staffManagePanel;
	
	public AddStaffPanel(){
		componentsInstantiation();
		initial();
	}
	
	public static void main(String[] args){
		AddStaffPanel staffInfoPanel = new AddStaffPanel();
	}
	
	
	public void initial(){
		// 设置标题
		frame.setUndecorated(true);
		frame.setSize(850, 646);
		// 不允许用户改变窗口大小
		frame.setResizable(false);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		final int coo_x = (screen.width - WIDTH) >> 1;
		final int coo_y = ((screen.height - HEIGHT) >> 1) - 32;

		frame.setLocation(coo_x, coo_y);
				
		// 设置默认panel
		mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
		mainPanel.setLayout(null);
		
		name.setBounds(x, y, w, h);
		position.setBounds(x + columnsp, y, w, h);
		ID.setBounds(x, y + linesp, w, h);
		account.setBounds(x, y + linesp * 2, w, h);
		password.setBounds(x + columnsp, y + linesp * 2, w, h);
		city.setBounds(x, y + linesp * 3, w, h);
		businessHall.setBounds(x + columnsp + 13, y + linesp * 3, w, h);
		
		
		mainPanel.add(confirmButton);
		mainPanel.add(cancelButton);
		mainPanel.add(ID);
		mainPanel.add(account);
		mainPanel.add(name);
		mainPanel.add(password);
		mainPanel.add(position);
		mainPanel.add(city);
		mainPanel.add(businessHall);
		
		frame.add(mainPanel);
		frame.setVisible(true);
		
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 450, 480, false);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, 350, 480, false);
		mainPanel = new MainPanel();
		ID = new JTextField();
		account = new JTextField();
		password = new JTextField();
		name = new JTextField();
		position = new JTextField();
		city = new JTextField();
		businessHall = new JTextField();
	}
	
	public void getInfo(){
		staffID = Long.parseLong(ID.getText());
		staffAccount = Long.parseLong(account.getText());
		staffPassword = password.getText();
		staffName = name.getText();
		staffPosition = position.getText();
		staffCity = city.getText();
		staffbusinessHall = businessHall.getText();
		
	}
	
	
	  class StaffInfoActionListener implements ActionListener {
	       AddStaffPanel container;
		       
	        public StaffInfoActionListener(AddStaffPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		           if(e.getSource() == confirmButton){
		        	   getInfo();
		        	   
		           }else if(e.getSource() == cancelButton){
		        	   
		           }
		           
		        	   

//		            container.repaint();
		        }
		    }
}
