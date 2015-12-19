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
	static final int coordinate_X = 230;
	static final int coordinate_Y = 100;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private static final ImageIcon CHANGE_ICON = new ImageIcon("images/user_InfoChange.png");
	private static final ImageIcon CHANGEENTER_ICON = new ImageIcon("images/user_InfoChangeEnter.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");

	
	UserVO userVO;
	MyButton change;
	MyButton confirm;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
    
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
	
//	public void paintComponent(Graphics g){
//		
//		Image image = new ImageIcon("images/user_InfoBG.png").getImage();
//		
//		g.drawImage(image,0,0,this);
//		
//	}
//	
	
	public void initial(){
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());

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
		this.add(imageLabel);

		this.setLayout(null);
		this.setOpaque(false);
		
		
		
		
	}
	
	public void componentsInstantiation(){
		imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/user_InfoBG.png");
		change = new MyButton(CHANGE_ICON, CHANGEENTER_ICON, coordinate_X + 350, coordinate_Y + 480,false);
		confirm = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 450, coordinate_Y + 480,false);

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
			
			name.setBounds(coordinate_X + x, coordinate_Y + y, w, h);
			position.setBounds(coordinate_X + x + columnsp, coordinate_Y + y, w, h);
			ID.setBounds(coordinate_X + x, coordinate_Y + y + linesp, w, h);
			account.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 2, w, h);
			password.setBounds(coordinate_X + x + columnsp, coordinate_Y + y + linesp * 2, w, h);
			city.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 3 - 1, w, h);
			salary.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 4, w, h);
			businessHall.setBounds(coordinate_X + x + columnsp + 20, coordinate_Y + y + linesp * 3 - 1, w, h);
			
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
	
//	public static void main(String[] args) {
//		new UserPanel(new UserVO(100000, 100000, "aaaaaa", "张三", "快递员",
//				null, new SalaryPO(3000), "南京", "鼓楼营业厅"));
//		
//	}
	
	class buttonActionListener implements ActionListener {
	       UserPanel container;
		       
	        public buttonActionListener(UserPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(e.getSource() == change){
		        		ChangePasswordPanel change = new ChangePasswordPanel(userVO);
//		        		container.frame.setContentPane(change);
		        		
		        	}
		        	else if (e.getSource() == confirm) {
						
					}
		        	container.repaint();
		        	
		        }
	}

}
