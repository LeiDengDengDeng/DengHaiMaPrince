package src.presentation.staffmanageui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.presentation.util.MyButton;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class Staff_InfoPanel extends JPanel{
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 95;
	static final int y = 58;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 49;
	static final int columnsp = 250;
	static final int coordinate_X = 150;
	static final int coordinate_Y = 90;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private static final ImageIcon DELETE_ICON = new ImageIcon("images/delete.png");
	private static final ImageIcon DELETEENTER_ICON = new ImageIcon("images/delete_Enter.png");
	
	StaffInfoVO staffInfoVO;

	JFrame frame;
	
	MyButton confirmButton;
	MyButton deleteButton;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
	
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
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/staff_InfoBG.png");
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 450, coordinate_Y + 480,false);
		deleteButton = new MyButton(DELETE_ICON, DELETEENTER_ICON, coordinate_X + 350, coordinate_Y + 480,false);
	}
	
	public void initial(){
		// 设置标题
		frame.setUndecorated(true);
		frame.setSize(850, 646);
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
		this.setLayout(null);

		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
        this.add(confirmButton);
        this.add(deleteButton);
        this.add(ID);
        this.add(account);
        this.add(password);
        this.add(name);
        this.add(position);
        this.add(city);
        this.add(businessHall);
        this.add(imageLabel);
        this.setOpaque(false);
		
		frame.setContentPane(this);
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
				
		name.setBounds(coordinate_X + x, coordinate_Y + y, w, h);
		position.setBounds(coordinate_X + x + columnsp, coordinate_Y + y, w, h);
		ID.setBounds(coordinate_X + x, coordinate_Y + y + linesp, w, h);
		account.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 2, w, h);
		password.setBounds(coordinate_X + x + columnsp, coordinate_Y + y + linesp * 2, w, h);
		city.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 3 , w, h);
		businessHall.setBounds(coordinate_X + x + columnsp + 20, coordinate_Y + y + linesp * 3, w, h);
				
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
