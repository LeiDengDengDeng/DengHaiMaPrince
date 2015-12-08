package src.presentation.staffmanageui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.presentation.util.MyButton;

public class AddStaffPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int WIDTH = 850;
	private final static int HEIGHT = 646;
	static final int x = 315;
	static final int y = 134;
	static final int w = 150;
	static final int h = 18;
	static final int linesp = 53;
	static final int columnsp = 250;
	
	private final static ImageIcon STAFFINFOHEAD_ICON = new ImageIcon("images/staff_InfoHead.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");

	private JFrame frame;
	private JLabel head;
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
		mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
		mainPanel.setLayout(null);
		
		head.setIcon(STAFFINFOHEAD_ICON);
		head.setBounds(0, 0, 
				STAFFINFOHEAD_ICON.getIconWidth(), STAFFINFOHEAD_ICON.getIconHeight());
		
		name.setBounds(x, y, w, h);
		position.setBounds(x + columnsp, y, w, h);
		ID.setBounds(x, y + linesp, w, h);
		account.setBounds(x, y + linesp * 2, w, h);
		password.setBounds(x + columnsp, y + linesp * 2, w, h);
		city.setBounds(x, y + linesp * 3, w, h);
		businessHall.setBounds(x + columnsp + 13, y + linesp * 3, w, h);
		
		
		mainPanel.add(confirmButton);
		mainPanel.add(cancelButton);
		mainPanel.add(head);
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
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 610, 580);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, 700, 580);
		head = new JLabel();
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
		           
		        	   

		            container.repaint();
		        }
		    }
}
