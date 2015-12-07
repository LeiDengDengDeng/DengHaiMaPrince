package src.presentation.userui;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//
//	private final static int WIDTH = 641;
//	private final static int HEIGHT = 572;
//	private final static int x = 80;
//	private final static int y = 40;

	
	
//	private JButton confirmButton;
//	private JButton changeButton;
//	private JLabel myText;
//	private JLabel name;
//	private JLabel position;
//	private JLabel ID;
//	private JLabel account;
//	private JLabel password;
//	private JLabel authority;
	
//	public UserPanel(){
////		changeButton = new JButton();
////		confirmButton = new JButton();
////        
////		confirmButton.setBounds(500, 450, x, y);
////        confirmButton.setText("确认管理");
////        
////        changeButton.setBounds(380, 450, x, y);
////        changeButton.setText("修改密码");
//        
//        componentsInstantiation();
//        initial();
//        
////        this.setLayout(null);
////        this.add(confirmButton);
////        this.add(changeButton);
//
//	}
//	
//	
//	public static void main(String args[]) {
//		UserPanel myPanel = new UserPanel();
//		myPanel.run();
//		
//	}
//	
//	public void componentsInstantiation(){
////		myText = new JLabel();
////		name = new JLabel();
////		position = new JLabel();
////		ID = new JLabel();
////		account = new JLabel();
////		password = new JLabel();
////		authority = new JLabel();
//	}
//	
//	public void run(){
//		JFrame frame = new JFrame();
//        frame.setBounds(0, 0, 870, 690);
//        frame.setContentPane(this);
//        frame.setVisible(true);
////        frame.setResizable(false);
//	}
//	
//	public void initial(){
//	
////		myText.setText("个人信息");
////		myText.setBounds(20, 0, x, y);
////		
////		name.setText("姓名 : ");
////		name.setBounds(20, 30, x, y);
////		
////		position.setText("职位 : ");
////		position.setBounds(350, 30, x, y);
////		
////		ID.setText("工号 ： ");
////		ID.setBounds(20, 60, x, y);
////		
////		account.setText("帐号 ： ");
////		account.setBounds(20, 90, x, y);
////		
////		password.setText("密码 : ");
////		password.setBounds(350, 90, x, y);
////		
////		
////		
////		name.setText("顾梦蝶");
////		name.setBounds(330, 650, x, y);
//		
//		
////		this.add(myText);
////		this.add(name);
////		this.add(position);
////		this.add(ID);
////		this.add(account);
////		this.add(password);
////		this.add(authority);
//		
//	}
	
	

	public void paintComponent(Graphics g){
		
		Image image = new ImageIcon("images/background.png").getImage();
		
		g.drawImage(image,0,0,this);
		
	}

}
