package src.presentation.userui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.presentation.util.MyButton;


public class ChangePasswordPanel {
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	static final int x = 360;
	static final int y = 164;
	static final int w = 200;
	static final int h = 16;
	static final int linesp = 49;
	
	
	private static final ImageIcon PASSWORD_ICON = new ImageIcon("images/user_passwordHead.png");
	private static final ImageIcon CANCEL_ICON= new ImageIcon("images/cancel.png");
	private static final ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	
//	JFrame frame;
	public MyPanel myPanel;
	private JLabel head;
	private JTextField oldpassField;
	private JTextField newpassField;
	private JTextField confirmField;
	MyButton confirmButton;
	MyButton cancelButton;
	
	String oldpass;
	String newpass;
	String confirmpass;
	
	public ChangePasswordPanel(){
		componentsInstantiation();
		initial();
		
	}
	
	public void componentsInstantiation(){
//		frame = new JFrame();
		myPanel = new MyPanel();
		head = new JLabel();
		oldpassField = new JTextField();
		newpassField = new JTextField();
		confirmField = new JTextField();
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 610, 580);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, 700, 580);
		
	}
	
	public void initial(){
		myPanel.setBounds(0, 0, WIDTH, HEIGHT);
		myPanel.setLayout(null);
		
		head.setIcon(PASSWORD_ICON);
		head.setBounds(0, 0, PASSWORD_ICON.getIconWidth(), PASSWORD_ICON.getIconHeight());
		
		oldpassField.setBounds(x, y, w, h);
		newpassField.setBounds(x, y + linesp * 2, w, h);
		confirmField.setBounds(x + 10, y + linesp * 4, w, h);
		
		
		myPanel.add(head);
		myPanel.add(oldpassField);
		myPanel.add(newpassField);
		myPanel.add(confirmField);
		myPanel.add(confirmButton);
		myPanel.add(cancelButton);
		
		
	}
	
	public void getPass(){
		oldpass = oldpassField.getText();
		newpass = newpassField.getText();
		confirmpass = confirmField.getText();
		
		
	}
	
	
}
