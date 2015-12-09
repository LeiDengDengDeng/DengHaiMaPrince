package src.presentation.userui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.po.SalaryPO;
import src.presentation.staffmanageui.StaffListPanel;
import src.presentation.util.MyButton;
import src.vo.UserVO;


public class UserPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 80;
	static final int y = 40;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 53;
	static final int columnsp = 250;
	static final int coordinate_X = 300;
	static final int coordinate_Y = 130;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private static final ImageIcon CHANGE_ICON = new ImageIcon("images/user_InfoChange.png");
	private static final ImageIcon CHANGEENTER_ICON = new ImageIcon("images/user_InfoChangeEnter.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");

	
	JFrame frame;
	UserVO userVO;
	MyButton change;
	MyButton confirm;
	private	JLabel ID;
	private	JLabel account;
	private	JLabel password;
	private	JLabel name;
	private	JLabel position;
	private	JLabel salary;
	private	JLabel city;
	private	JLabel businessHall;
	
	public UserPanel(UserVO userVO){
		this.userVO = userVO;
		getInfo(userVO);
		componentsInstantiation();
		initial();
		
		buttonActionListener listener = new buttonActionListener(this);
        change.addActionListener(listener);
        confirm.addActionListener(listener);
	}
	
	public void paintComponent(Graphics g){
		
		Image image = new ImageIcon("images/user_InfoBG.png").getImage();
		
		g.drawImage(image,0,0,this);
		
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
		
		frame.setLayout(null);
		// 设置默认panel
		this.setLayout(null);
		this.setBounds(0, 0, WIDTH, HEIGHT);
		
		
		this.add(ID);
		this.add(account);
		this.add(password);
		this.add(name);
		this.add(position);
		this.add(city);
		this.add(businessHall);
		this.add(salary);
		this.add(change);
		this.add(confirm);
		
		frame.setContentPane(this);
		frame.setVisible(true);
		
		
		
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
		change = new MyButton(CHANGE_ICON, CHANGEENTER_ICON, 350, 480,false);
		confirm = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 450, 480,false);

	}
	
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
			city.setBounds(x, y + linesp * 3 - 1, w, h);
			salary.setBounds(x, y + linesp * 4, w, h);
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
			salary.setFont(myFont);
			salary.setForeground(Color.WHITE);
		}
	
	public static void main(String[] args) {
		new UserPanel(new UserVO(100000, 100000, "aaaaaa", "张三", "快递员",
				null, new SalaryPO(3000), "南京", "鼓楼营业厅"));
		
	}
	
	class buttonActionListener implements ActionListener {
	       UserPanel container;
		       
	        public buttonActionListener(UserPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(e.getSource() == change){
		        		ChangePasswordPanel change = new ChangePasswordPanel(userVO);
		        		container.frame.setContentPane(change);
		        		
		        	}
		        	else if (e.getSource() == confirm) {
						
					}
		        	container.repaint();
		        	
		        }
	}

}
