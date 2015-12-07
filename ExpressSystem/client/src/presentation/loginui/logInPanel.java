package src.presentation.loginui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import src.businesslogic.loginbl.LogInController;
import src.businesslogic.userbl.User;
import src.presentation.util.MyButton;

public class logInPanel extends JPanel{
	
	
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	
	JFrame frame;
	MyPanel myPanel;
	private static final ImageIcon CHECK_ICON = new ImageIcon("images/logIn_check.png");
	private static final ImageIcon CHECKENTER_ICON = new ImageIcon("images/logIn_checkEnter.png");
	private static final ImageIcon LOG_ICON = new ImageIcon("images/logIn_log.png");
	private static final ImageIcon LOGENTER_ICON = new ImageIcon("images/logIn_logEnter.png");
	
	
	MyButton checkButton;
	MyButton loginButton;
	
	private JTextField accountField;
	private JPasswordField passwordField;
	private long account;
	private String password;
	
	
	public logInPanel(){
		componentsInstantiation();
		initial();
		
	}
	

	
	public void componentsInstantiation(){
		frame = new JFrame();
		myPanel = new MyPanel();
		checkButton = new MyButton(CHECK_ICON, CHECKENTER_ICON, 370, 450);
		loginButton = new MyButton(LOG_ICON, LOGENTER_ICON, 560, 450);
		accountField = new JTextField();
		passwordField = new JPasswordField();
	}
	
	public void initial(){
		myPanel.setLayout(null);
		myPanel.setOpaque(false);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		final int x = (screen.width - WIDTH) >> 1;
		final int y = ((screen.height - HEIGHT) >> 1) - 32;

		frame.setLocation(x, y);
		
		accountField.setBounds(455, 330, 190, 20);
		passwordField.setBounds(455, 400, 190, 20);
		
		myPanel.add(checkButton);
		myPanel.add(loginButton);
		myPanel.add(accountField);
		myPanel.add(passwordField);
		
		frame.setContentPane(myPanel);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
	}
	
	public void login(){
		account = Long.parseLong(accountField.getText());
		password = passwordField.getText();
		
		
	}
	
	public static void main(String[] args){
		logInPanel logInPanel = new logInPanel();
			
		
	}
	
	

}
