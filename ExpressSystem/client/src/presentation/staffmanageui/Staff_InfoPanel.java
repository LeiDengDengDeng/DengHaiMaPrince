package src.presentation.staffmanageui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.logbl.Log;
import src.businesslogic.positionbl.Position;
import src.businesslogic.staffmanagebl.StaffManage;
import src.businesslogic.userbl.User;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.vo.StaffInfoVO;

public class Staff_InfoPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6708767785258883280L;
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 95;
	static final int y = 58;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 49;
	static final int columnsp = 250;
	static final int coordinate_X = 40;
	static final int coordinate_Y = 40;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private static final ImageIcon DELETE_ICON = new ImageIcon("images/delete.png");
	private static final ImageIcon DELETEENTER_ICON = new ImageIcon("images/delete_Enter.png");
	
	StaffInfoVO staffInfoVO;
	StaffManage staffManage;
	Log log;
	
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
		buttonActionListener listener = new buttonActionListener(this);
		
        componentsInstantiation();
		getInfo(staffInfoVO);
		initial();

		confirmButton.addActionListener(listener);
		deleteButton.addActionListener(listener);
	}
	
//	public static void main(String[] args){
//		Staff_InfoPanel staff_InfoPanel = new Staff_InfoPanel(new StaffInfoVO(100000, 100000, 
//				"aaaaaa", "张三", "快递员", null, "南京", "鼓楼营业厅"));
//	}

	
	public void componentsInstantiation(){
		log = new Log();
		staffManage = new StaffManage(log, new Position(new User(log),log));
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/staff_InfoBG.png");
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 450, coordinate_Y + 480,false);
		deleteButton = new MyButton(DELETE_ICON, DELETEENTER_ICON, coordinate_X + 350, coordinate_Y + 480,false);
	}
	
	public void initial(){
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

        this.setLayout(null);
        this.setOpaque(false);
		
		
	}
	//获得员工信息
	public void getInfo(StaffInfoVO staffInfoVO){
		ID = new JLabel(String.valueOf(staffInfoVO.getID()));
		account = new JLabel(String.valueOf(staffInfoVO.getAccount()));
		password = new JLabel(staffInfoVO.getPassword());
		name = new JLabel(staffInfoVO.getStaffName());
		position = new JLabel(staffInfoVO.getPosition());
		
		if(staffInfoVO.getCity() == null) city = new JLabel("无");
		else city = new JLabel(staffInfoVO.getCity());
		
		if(staffInfoVO.getBusinessHall() == null) businessHall = new JLabel("无");
		else businessHall = new JLabel(staffInfoVO.getBusinessHall());
				
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
		
		setAuthority();
	}
	
	//权限
	public void setAuthority(){
		int sp = 30;
		for(int i = 0; i < staffInfoVO.getAuthority().size();i++){
			JLabel authority = null;
//			this.add(authority);
			switch (staffInfoVO.getAuthority().get(i)) {
			case 1:authority = new JLabel("员工账号管理");break;
			case 2:authority = new JLabel("中转中心接收与派件");break;
			case 3:authority = new JLabel("营业厅接收与派件");break;
			case 4:authority = new JLabel("收款单填写");break;
			case 5:authority = new JLabel("车辆装车管理");break;
			case 6:authority = new JLabel("飞机、火车、汽车装运管理");break;
			case 7:authority = new JLabel("记录订单信息");break;	
			case 8:authority = new JLabel("收货信息");break;
			case 9:authority = new JLabel("仓库管理");break;
			case 10:authority = new JLabel("车辆、司机信息管理");break;
			case 11:authority = new JLabel("经营情况查询");break;
			case 12:authority = new JLabel("人员机构管理");break;
			case 13:authority = new JLabel("审批单据");break;
			case 14:authority = new JLabel("付款单填写");break;
			case 15:authority = new JLabel("账户管理");break;
			case 16:authority = new JLabel("成本管理");break;
			case 17:authority = new JLabel("结算管理");break;
			case 18:authority = new JLabel("修改权限");break;
			case 19:authority = new JLabel("查看日志");break;
			case 20:authority = new JLabel("制定常量");break;
			case 21:authority = new JLabel("期初建账");break;
			default:
				break;
			}
			authority.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 4 + i * sp, w, h);
			authority.setFont(myFont);
			authority.setForeground(Color.WHITE);
			this.add(authority);
		}				
	}
	
	
	class buttonActionListener implements ActionListener {
		Staff_InfoPanel container;
		       
	        public buttonActionListener(Staff_InfoPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(e.getSource() == confirmButton){
		        		PanelController.setPresentPanel(new StaffListPanel());
		        	}
		        	else if (e.getSource() == deleteButton) {
						staffManage.deleteStaff(staffInfoVO.getID());
						PanelController.setPresentPanel(new StaffListPanel());
					}
		        	
		        	
		        }
	}

}
