package src.presentation.userui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import src.businesslogic.logbl.Log;
import src.presentation.accountui.AccountPanel;

public class UserFrame {
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	private static final ImageIcon IMG = new ImageIcon("images/AdministratorBG.png");
	private static final ImageIcon PASSWORD = new ImageIcon("images/user_password.png");
	private static final ImageIcon PASSWORDENTER = new ImageIcon("images/user_passwordEnter.png");
	private static final ImageIcon CONFIRMMANAGE_ICON = new ImageIcon("images/user_confirmManage.png");
	private static final ImageIcon CONFIRMMANAGEENTER_ICON = new ImageIcon("images/user_confirmManageEnter.png");
	
	JFrame userFrame;
	UserPanel panel;
	JLabel passwordButton;
	JLabel confirmManageButton;
	
	public static void main(String[] args){
		UserFrame u = new UserFrame();
		u.componentsInstantiation();
		u.initial();
	}
	
	public void componentsInstantiation(){
		userFrame  = new JFrame();
		panel = new UserPanel();
		passwordButton = new JLabel();
		confirmManageButton = new JLabel();
	}
	
	public void initial(){
		// 设置标题
		userFrame.setUndecorated(true);
		userFrame.setSize(WIDTH, HEIGHT);
		// 不允许用户改变窗口大小
		userFrame.setResizable(false);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		final int x = (screen.width - WIDTH) >> 1;
		final int y = ((screen.height - HEIGHT) >> 1) - 32;

		userFrame.setLocation(x, y);
		// 设置默认panel
		panel.setBounds(0, 0, WIDTH, HEIGHT);
		panel.setLayout(null);
		
		
		//修改密码
		passwordButton.setIcon(PASSWORD);
		passwordButton.setBounds( x + 280, y + 550,
				PASSWORD.getIconWidth(), PASSWORD.getIconHeight());
		passwordButton.addMouseListener(new MouseListener() {
			
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
				passwordButton.setIcon(PASSWORD);
//				passwordButton.setBounds( x + 280, y + 550,
//						PASSWORD.getIconWidth(), PASSWORD.getIconHeight());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				passwordButton.setIcon(PASSWORDENTER);
//				passwordButton.setBounds(x + 280, y + 550, 
//						PASSWORDENTER.getIconWidth(), PASSWORDENTER.getIconHeight());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				changePassword();
			}
		});
		
		//确认管理
		confirmManageButton.setIcon(CONFIRMMANAGE_ICON);
		confirmManageButton.setBounds(x + 420, y + 550, 
				CONFIRMMANAGE_ICON.getIconWidth(), CONFIRMMANAGE_ICON.getIconHeight());
		confirmManageButton.addMouseListener(new MouseListener() {
			
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
				confirmManageButton.setIcon(CONFIRMMANAGE_ICON);
//				confirmManageButton.setBounds(x + 420, y + 550, 
//						CONFIRMMANAGE_ICON.getIconWidth(), CONFIRMMANAGE_ICON.getIconHeight());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				confirmManageButton.setIcon(CONFIRMMANAGEENTER_ICON);
//				confirmManageButton.setBounds(x + 420, y + 550, 
//						CONFIRMMANAGEENTER_ICON.getIconWidth(), CONFIRMMANAGEENTER_ICON.getIconHeight());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		
		panel.add(passwordButton);
		panel.add(confirmManageButton);
		
		userFrame.setContentPane(panel);
		userFrame.setVisible(true);
	
	}
	
	
	public void changePassword(){
		PasswordPanel passwordPanel = new PasswordPanel();
		userFrame.setContentPane(passwordPanel);
//		userFrame.repaint();
	}
	
	
	
	
}
