package src.presentation.userui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import src.businesslogic.loginbl.LogIn;
import src.businesslogic.userbl.User;
import src.presentation.util.MyButton;
import src.vo.UserVO;


public class ChangePasswordPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 120;
	static final int y = 61;
	static final int w = 200;
	static final int h = 16;
	static final int linesp = 61;
	static final int coordinate_X = 150;
	static final int coordinate_Y = 90;
	
	
	private static final ImageIcon CANCEL_ICON= new ImageIcon("images/cancel.png");
	private static final ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	
//	JFrame frame;
	private JPasswordField oldpassField;
	private JPasswordField newpassField;
	private JPasswordField confirmField;
	MyButton confirmButton;
	MyButton cancelButton;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
    
	UserVO userVO;
	User user = new User(null);
	LogIn logIn = new LogIn(user);
	String oldpass;
	String newpass;
	String confirmpass;
	
	public ChangePasswordPanel(UserVO userVO){
		this.userVO = userVO;
		componentsInstantiation();
		initial();
		
		buttonActionListener listener = new buttonActionListener(this);
        confirmButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
		
	}
	
//	public void paintComponent(Graphics g){
//		
//		Image image = new ImageIcon("images/password_BG.png").getImage();
//		
//		g.drawImage(image,0,0,this);
//		
//	}
	
	public void componentsInstantiation(){
//		frame = new JFrame();
		bkgImg = new ImageIcon("images/password_BG.png");
		imageLabel = new JLabel();
		oldpassField = new JPasswordField();
		newpassField = new JPasswordField();
		confirmField = new JPasswordField();
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 350, coordinate_Y + 480,false);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, coordinate_X + 450, coordinate_Y + 480,false);
		
	}

	public void initial(){
		this.setLayout(null);
		
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
		oldpassField.setBounds(coordinate_X + x, coordinate_Y + y, w, h);
		newpassField.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 2, w, h);
		confirmField.setBounds(coordinate_X + x + 10, coordinate_Y + y + linesp * 4, w, h);
		
		
		this.add(oldpassField);
		this.add(newpassField);
		this.add(confirmField);
		this.add(confirmButton);
		this.add(cancelButton);
		this.add(imageLabel);
		this.setOpaque(false);
		
		
	}
	
//	public void getPass(){
//		oldpass = oldpassField.getText();
//		newpass = newpassField.getText();
//		confirmpass = confirmField.getText();
//		if(oldpass.equals(logIn.getCurrentUser().getMyPassword())){
//			if(newpass.equals(confirmpass)){
//				logIn.getCurrentUser().setMyPassword(confirmpass);
//				user.changeInfo(logIn.getCurrentUser());
//			}
//		}
//		
//		
//	}
	class buttonActionListener implements ActionListener {
	       ChangePasswordPanel container;
		       
	        public buttonActionListener(ChangePasswordPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(e.getSource() == cancelButton){
		        		
		        	}else if (e.getSource() == confirmButton) {
		        		oldpass = oldpassField.getText();
		        		newpass = newpassField.getText();
		        		confirmpass = confirmField.getText();
		        		if(oldpass.equalsIgnoreCase(userVO.getMyPassword())){
		        			if(newpass.equalsIgnoreCase(confirmpass)){
		        				logIn.getCurrentUser().setMyPassword(confirmpass);
		        				user.changeInfo(logIn.getCurrentUser());
		        			}
		        		}
		        		UserPanel userPanel = new UserPanel(userVO);
					}
		        	
		        }
	}
	
	
}
