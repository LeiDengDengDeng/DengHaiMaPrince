package src.presentation.userui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	static final int x = 315;
	static final int y = 130;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 53;
	static final int columnsp = 250;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private static final ImageIcon HEAD_ICON = new ImageIcon("images/user_InfoHead.png");
	private static final ImageIcon CHANGE_ICON = new ImageIcon("images/user_InfoChange.png");
	private static final ImageIcon CHANGEENTER_ICON = new ImageIcon("images/user_InfoChangeEnter.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");

	
	JFrame frame;
	MyPanel myPanel;
	UserVO userVO;
	MyButton change;
	MyButton confirm;
	private JLabel headJLabel;
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
		myPanel.setLayout(null);
		myPanel.setBounds(0, 0, WIDTH, HEIGHT);
		
		headJLabel.setIcon(HEAD_ICON);
		headJLabel.setBounds(0, 0, HEAD_ICON.getIconWidth(), HEAD_ICON.getIconHeight());
		
		myPanel.add(headJLabel);
		myPanel.add(ID);
		myPanel.add(account);
		myPanel.add(password);
		myPanel.add(name);
		myPanel.add(position);
		myPanel.add(city);
		myPanel.add(businessHall);
		myPanel.add(salary);
		myPanel.add(change);
		myPanel.add(confirm);
		
		frame.add(myPanel);
		frame.setVisible(true);
		
		
		
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
		myPanel = new MyPanel();
		headJLabel = new JLabel();
		change = new MyButton(CHANGE_ICON, CHANGEENTER_ICON, 610, 580);
		confirm = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 700, 580);

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
		        		ChangePasswordPanel change = new ChangePasswordPanel();
		        		container.frame.setContentPane(change.myPanel);
		        	}
		        	else if (e.getSource() == confirm) {
						
					}
		        	container.setVisible(true);
		        	
		        }
	}

}
