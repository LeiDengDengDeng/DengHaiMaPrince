package src.presentation.userui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.callback.ConfirmationCallback;
import javax.security.auth.login.Configuration;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.presentation.staffmanageui.StaffListPanel;
import src.presentation.staffmanageui.changeAuthorityPanel;

public class ChangePasswordPanel {
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	static final int x = 315;
	static final int y = 130;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 53;
	
	
	private static final ImageIcon PASSWORD_ICON = new ImageIcon("images/user_passwordHead.png");
	
//	JFrame frame;
	MyPanel myPanel;
	private JLabel head;
	private JTextField oldpassField;
	private JTextField newpassField;
	private JTextField confirmField;
	
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
		
	}
	
	public void initial(){
		myPanel.setBounds(0, 0, WIDTH, HEIGHT);
		myPanel.setLayout(null);
		
		head.setIcon(PASSWORD_ICON);
		head.setBounds(0, 0, PASSWORD_ICON.getIconWidth(), PASSWORD_ICON.getIconHeight());
		
		oldpassField.setBounds(x, y, w, h);
		newpassField.setBounds(x, y + linesp, w, h);
		confirmField.setBounds(x, y, w, h);
		
		
		myPanel.add(head);
		myPanel.add(oldpassField);
		myPanel.add(newpassField);
		myPanel.add(confirmField);
		
		
	}
	
	
}
