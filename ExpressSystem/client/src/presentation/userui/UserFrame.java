package src.presentation.userui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.zip.Inflater;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import src.businesslogic.logbl.Log;
import src.po.SalaryPO;
import src.presentation.accountui.AccountPanel;
import src.vo.UserVO;

public class UserFrame {
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	static final int x = 308;
	static final int y = 112;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 63;
	static final int columnsp = 310;
	private static final ImageIcon PASSWORD = new ImageIcon("images/user_password.png");
	private static final ImageIcon PASSWORDENTER = new ImageIcon("images/user_passwordEnter.png");
	private static final ImageIcon PERSONALINFO_ICON = new ImageIcon("images/user_Info.png");
	private static final ImageIcon CONFIRMMANAGE_ICON = new ImageIcon("images/user_confirmManage.png");
	private static final ImageIcon CONFIRMMANAGEENTER_ICON = new ImageIcon("images/user_confirmManageEnter.png");
	
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private JFrame userFrame;
	private JLabel passwordButton;
	private JLabel confirmManageButton;
	private JLabel infoJLabel;
	MainPanel panel;
	UserVO userVO;
	
	private	JLabel ID;
	private	JLabel account;
	private	JLabel password;
	private	JLabel name;
	private	JLabel position;
	private	JLabel salary;
	private	JLabel city;
	private	JLabel businessHall;
	
	public UserFrame(){
		userVO = new UserVO(100000, 100000, "aaaaaa", "张三", "快递员",
				null, new SalaryPO(3000), "南京", "鼓楼营业厅");
		getInfo(userVO);
		componentsInstantiation();
		initial();
	}
	
	
	public static void main(String[] args){
		UserFrame u = new UserFrame();
	}
	
	public void componentsInstantiation(){
		userFrame  = new JFrame();
		panel = new MainPanel();
		passwordButton = new JLabel();
		confirmManageButton = new JLabel();
		infoJLabel = new JLabel();
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
		
		
		infoJLabel.setIcon(PERSONALINFO_ICON);
		infoJLabel.setBounds(0, 0, 
				PERSONALINFO_ICON.getIconWidth(), PERSONALINFO_ICON.getIconHeight());;
		
		
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
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				passwordButton.setIcon(PASSWORDENTER);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//跳转到修改密码界面
				PasswordPanel passwordPanel = new PasswordPanel();
				userFrame.setContentPane(passwordPanel.mainPanel);
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
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				confirmManageButton.setIcon(CONFIRMMANAGEENTER_ICON);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		
		panel.add(passwordButton);
		panel.add(confirmManageButton);
		panel.add(infoJLabel);
		panel.add(ID);
		panel.add(account);
		panel.add(password);
		panel.add(name);
		panel.add(position);
		panel.add(city);
		panel.add(businessHall);
		panel.add(salary);
		
		
		
		userFrame.setContentPane(panel);
		userFrame.setVisible(true);
	
	}
	

//	public void changePassword(){
//
////		userFrame.repaint();
//	}
	
	
	//获得个人信息
	public void getInfo(UserVO userVO){
		ID = new JLabel(String.valueOf(userVO.getpersonalID()));
		account = new JLabel(String.valueOf(userVO.getpersonalAccount()));
		password = new JLabel(userVO.getMyPassword());
		name = new JLabel(userVO.getpersonalName());
		position = new JLabel(userVO.getMyPosition());
		salary = new JLabel(String.valueOf(userVO.getSalary().getTotal()));
		city = new JLabel(userVO.getCity());
		businessHall = new JLabel(userVO.getBusinessHall());
		
		name.setBounds(x, y, w, h);
		position.setBounds(x + columnsp, y, w, h);
		ID.setBounds(x, y + linesp, w, h);
		account.setBounds(x, y + linesp * 2, w, h);
		password.setBounds(x + columnsp, y + linesp * 2, w, h);
		city.setBounds(x, y + linesp * 3, w, h);
		businessHall.setBounds(x + columnsp + 20, y + linesp * 3, w, h);
		salary.setBounds(x, y + linesp * 6 + 32, w, h);
		
		name.setFont(myFont);
		name.setForeground(Color.WHITE);
		position.setFont(myFont);
		position.setForeground(Color.WHITE);
		ID.setFont(myFont);
		ID.setForeground(Color.WHITE);
		account.setFont(myFont);
		account.setForeground(Color.WHITE);
		password.setFont(myFont);
		password.setForeground(Color.WHITE);
		city.setFont(myFont);
		city.setForeground(Color.WHITE);
		businessHall.setFont(myFont);
		businessHall.setForeground(Color.WHITE);
		salary.setFont(myFont);
		salary.setForeground(Color.WHITE);
		
		
		
		
	}
	
	
	
	
}
