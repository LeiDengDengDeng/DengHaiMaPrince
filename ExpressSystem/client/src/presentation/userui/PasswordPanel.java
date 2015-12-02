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

public class PasswordPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int WIDTH = 641;
	private final static int HEIGHT = 572;
	private final static int x = 80;
	private final static int y = 40;
	private final static ImageIcon CONFIRM_ICON = new ImageIcon("images/确认.png");
	private final static ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/确认enter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/取消.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/取消enter.png");
	
	private JFrame frame;
	private JLabel confirmButton;
	private JLabel cancelButton;
//	private StaffManagePanel staffManagePanel;
	private JTextArea oldPass;
	private JTextArea newPass;
	private JTextArea confirmPass;
	
	
	public PasswordPanel(){
		componentsInstantiation();
		initial();
//		run();
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
		this.setLayout(null);
		
		oldPass.setBounds(350, 100, 2*x, y/2);
		newPass.setBounds(350, 180, 2*x, y/2);
		confirmPass.setBounds(360, 260, 2*x, y/2);

		
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
				confirmButton.setBounds(520, 570, 
						CONFIRM_ICON.getIconWidth(), CONFIRM_ICON.getIconHeight());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				confirmButton.setIcon(CONFIRMENTER_ICON);
				confirmButton.setBounds(520, 570, 
						CONFIRMENTER_ICON.getIconWidth(), CONFIRMENTER_ICON.getIconHeight());
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
				cancelButton.setBounds(680, 570, 
						CANCEL_ICON.getIconWidth(), CANCEL_ICON.getIconHeight());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				cancelButton.setIcon(CANCELENTER_ICON);
				cancelButton.setBounds(680, 570, 
						CANCELENTER_ICON.getIconWidth(), CANCELENTER_ICON.getIconHeight());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		this.add(confirmButton);
		this.add(cancelButton);
		this.add(oldPass);
		this.add(newPass);
		this.add(confirmPass);
//		staffManagePanel.add(oldPass);
//		frame.add(staffManagePanel);
		
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
//		staffManagePanel = new StaffManagePanel();
		confirmButton = new JLabel();
		cancelButton = new JLabel();
		oldPass = new JTextArea();
		newPass = new JTextArea();
		confirmPass = new JTextArea();
		
		
	}
	
	public void paintComponent(Graphics g){
		
		Image image = new ImageIcon("images/password_Nobutton.png").getImage();

		
		g.drawImage(image,0,0,this);
		
	}

}
