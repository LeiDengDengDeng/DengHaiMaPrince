package src.presentation.staffmanageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.presentation.util.MyButton;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class Staff_InfoPanel {
	
	private final static int WIDTH = 850;
	private final static int HEIGHT = 646;
	static final int x = 315;
	static final int y = 130;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 53;
	static final int columnsp = 250;
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private final static ImageIcon STAFFINFOHEAD_ICON = new ImageIcon("images/staff_InfoHead.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private static final ImageIcon DELETE_ICON = new ImageIcon("images/删除.png");
	private static final ImageIcon DELETEENTER_ICON = new ImageIcon("images/删除1.png");
	
	JFrame frame;
	MainPanel panel;
	MyButton confirmButton;
	MyButton deleteButton;
	StaffInfoVO staffInfoVO;
	private JLabel head;
	private	JLabel ID;
	private	JLabel account;
	private	JLabel password;
	private	JLabel name;
	private	JLabel position;
//	private	JLabel salary;
	private	JLabel city;
	private	JLabel businessHall;
	
	
	public Staff_InfoPanel(StaffInfoVO staffInfoVO){
		this.staffInfoVO = staffInfoVO;
		componentsInstantiation();
		getInfo(staffInfoVO);
		initial();
	}
	
	public static void main(String[] args){
		Staff_InfoPanel staff_InfoPanel = new Staff_InfoPanel(new StaffInfoVO(100000, 100000, 
				"aaaaaa", "张三", "快递员", null, "南京", "鼓楼营业厅"));
	}

	
	public void componentsInstantiation(){
		frame = new JFrame();
		panel = new MainPanel();
		head = new JLabel();
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 700, 580,false);
		deleteButton = new MyButton(DELETE_ICON, DELETEENTER_ICON, 610, 580,false);
	}
	
	public void initial(){
		// 设置标题
		frame.setUndecorated(true);
		frame.setSize(WIDTH, HEIGHT);
		// 不允许用户改变窗口大小
		frame.setResizable(false);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		final int x = (screen.width - WIDTH) >> 1;
		final int y = ((screen.height - HEIGHT) >> 1) - 32;

		frame.setLocation(x, y);
		// 设置默认panel
		panel.setBounds(0, 0, WIDTH, HEIGHT);
		panel.setLayout(null);
		
		head.setIcon(STAFFINFOHEAD_ICON);
		head.setBounds(0, 0, 
				STAFFINFOHEAD_ICON.getIconWidth(), STAFFINFOHEAD_ICON.getIconHeight());
		
		panel.add(head);
		panel.add(confirmButton);
		panel.add(deleteButton);
		panel.add(ID);
		panel.add(account);
		panel.add(password);
		panel.add(name);
		panel.add(position);
		panel.add(city);
		panel.add(businessHall);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		
		
	}
	//获得员工信息
	public void getInfo(StaffInfoVO staffInfoVO){
		ID = new JLabel(String.valueOf(staffInfoVO.getID()));
		account = new JLabel(String.valueOf(staffInfoVO.getAccount()));
		password = new JLabel(staffInfoVO.getPassword());
		name = new JLabel(staffInfoVO.getStaffName());
		position = new JLabel(staffInfoVO.getPosition());
		city = new JLabel(staffInfoVO.getCity());
		businessHall = new JLabel(staffInfoVO.getBusinessHall());
				
		name.setBounds(x, y, w, h);
		position.setBounds(x + columnsp, y, w, h);
		ID.setBounds(x, y + linesp, w, h);
		account.setBounds(x, y + linesp * 2, w, h);
		password.setBounds(x + columnsp, y + linesp * 2, w, h);
		city.setBounds(x, y + linesp * 3 - 1, w, h);
		businessHall.setBounds(x + columnsp + 20, y + linesp * 3 - 1, w, h);
				
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
			}

}
