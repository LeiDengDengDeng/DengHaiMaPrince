package src.presentation.staffmanageui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.presentation.mainui.MainFrame;
import src.presentation.userui.MainPanel;
import src.presentation.util.MyButton;

public class StaffInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int WIDTH = 641;
	private final static int HEIGHT = 572;
	static final int x = 315;
	static final int y = 112;
	static final int w = 150;
	static final int h = 20;
	static final int linesp = 63;
	static final int columnsp = 310;
	private final static ImageIcon STAFFINFO_ICON = new ImageIcon("images/StaffInfo.png");
	private final static ImageIcon CONFIRM_ICON = new ImageIcon("images/确认.png");
	private final static ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/确认enter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/取消.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/取消enter.png");

	private JFrame frame;
	private JLabel Staff_Info;
	private	JTextField ID;
	private	JTextField account;
	private	JTextField password;
	private	JTextField name;
	private	JTextField position;
	private	JTextField city;
	private	JTextField businessHall;
	
	MyButton cancelButton;
	MyButton confirmButton;
	MainPanel mainPanel;
	StaffListPanel staffManagePanel;
	
	public StaffInfoPanel(){
		componentsInstantiation();
		initial();
	}
	
	public static void main(String[] args){
		StaffInfoPanel staffInfoPanel = new StaffInfoPanel();
	}
	
	
	public void initial(){
		mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
		mainPanel.setLayout(null);
		
		Staff_Info.setIcon(STAFFINFO_ICON);
		Staff_Info.setBounds(0, 0, 
				STAFFINFO_ICON.getIconWidth(), STAFFINFO_ICON.getIconHeight());
		
		name.setBounds(x, y, w, h);
		position.setBounds(x + columnsp, y, w, h);
		ID.setBounds(x, y + linesp, w, h);
		account.setBounds(x, y + linesp * 2, w, h);
		password.setBounds(x + columnsp, y + linesp * 2, w, h);
		city.setBounds(x, y + linesp * 3, w, h);
		businessHall.setBounds(x + columnsp + 10, y + linesp * 3, w, h);
		
		
		mainPanel.add(confirmButton);
		mainPanel.add(cancelButton);
		mainPanel.add(Staff_Info);
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
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 520, 570);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, 680, 570);
		Staff_Info = new JLabel();
		mainPanel = new MainPanel();
		ID = new JTextField();
		account = new JTextField();
		password = new JTextField();
		name = new JTextField();
		position = new JTextField();
		city = new JTextField();
		businessHall = new JTextField();
	}
	
	  class StaffInfoActionListener implements ActionListener {
	       StaffInfoPanel container;
		       
	        public StaffInfoActionListener(StaffInfoPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		           if(e.getSource() == confirmButton){
		        	   
		           }else if(e.getSource() == cancelButton){
		        	   
		           }
		           
		        	   

		            container.repaint();
		        }
		    }
}
