package src.presentation.userui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PasswordPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int WIDTH = 641;
	private final static int HEIGHT = 572;
	private final static int x = 80;
	private final static int y = 40;
	private final static ImageIcon PASSWORDINFO_ICON = new ImageIcon("images/password_Info.png");
	private final static ImageIcon CONFIRM_ICON = new ImageIcon("images/确认.png");
	private final static ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/确认enter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/取消.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/取消enter.png");
	
	private JFrame frame;
	private JLabel confirmButton;
	private JLabel cancelButton;
	private JLabel password_Info;
	private JTextField oldPass;
	private JTextField newPass;
	private JTextField confirmPass;
//	String old;
//	String update;
//	String confirm;
	MainPanel mainPanel;
	
	
	public PasswordPanel(){
//		this.old = old;
//		this.update = update;
//		this.confirm = confirm;
		componentsInstantiation();
		initial();
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PasswordPanel passwordPanel = new PasswordPanel();
//
//	}
	
	
//	public void run(){
//        frame.setBounds(0, 0, 850, 646);
//        frame.setContentPane(this);
//        frame.setVisible(true);
////        frame.setResizable(false);
//	}
	
	public void initial(){
		mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
		mainPanel.setLayout(null);
		
		oldPass.setBounds(350, 100, 2*x, 2*y/5);
		newPass.setBounds(350, 180, 2*x, 2*y/5);
		confirmPass.setBounds(360, 260, 2*x, 2*y/5);
		

		password_Info.setIcon(PASSWORDINFO_ICON);
		password_Info.setBounds(0, 0, 
				PASSWORDINFO_ICON.getIconWidth(), PASSWORDINFO_ICON.getIconHeight());
		
		//确认
		confirmButton.setIcon(CONFIRM_ICON);
		confirmButton.setBounds(520, 570, 
				CONFIRM_ICON.getIconWidth(), CONFIRM_ICON.getIconHeight());
		confirmButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				confirmButton.setIcon(CONFIRM_ICON);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				confirmButton.setIcon(CONFIRMENTER_ICON);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//取消
		cancelButton.setIcon(CANCEL_ICON);
		cancelButton.setBounds(680, 570, 
				CANCEL_ICON.getIconWidth(), CANCEL_ICON.getIconHeight());
		cancelButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				cancelButton.setIcon(CANCEL_ICON);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				cancelButton.setIcon(CANCELENTER_ICON);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				UserFrame userFrame = new UserFrame();
			}
		});
		
		
		
		mainPanel.add(confirmButton);
		mainPanel.add(cancelButton);
		mainPanel.add(oldPass);
		mainPanel.add(newPass);
		mainPanel.add(confirmPass);
		mainPanel.add(password_Info);
		
//		frame.setContentPane(mainPanel);
//		frame.setVisible(true);
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
		confirmButton = new JLabel();
		cancelButton = new JLabel();
		password_Info = new JLabel();
		mainPanel = new MainPanel();
		oldPass = new JTextField();
		newPass = new JTextField();
		confirmPass = new JTextField();

	}
	
//	public void paintComponent(Graphics g){
//		
//		Image image = new ImageIcon("images/password_Nobutton.png").getImage();
//
//		
//		g.drawImage(image,0,0,this);
//		
//	}

}
