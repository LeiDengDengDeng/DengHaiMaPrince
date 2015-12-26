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

import src.businesslogic.loginbl.LogIn;
import src.businesslogic.userbl.User;
import src.po.SalaryPO;
import src.presentation.mainui.PanelController;
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
	
	Font myFont = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private static final ImageIcon CHANGE_ICON = new ImageIcon("images/user_InfoChange.png");
	private static final ImageIcon CHANGEENTER_ICON = new ImageIcon("images/user_InfoChangeEnter.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");

	
	UserVO userVO;
	LogIn logIn;
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
	
	public UserPanel(){
		componentsInstantiation();
		this.userVO = logIn.getCurrentUser();
		getInfo(userVO);
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
		logIn = new LogIn(new User(null));
		imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/user_InfoBG.png");
		change = new MyButton(CHANGE_ICON, CHANGEENTER_ICON, coordinate_X + 350, coordinate_Y + 480,false);
		confirm = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 450, coordinate_Y + 480,false);

	}
	
	//��ø�����Ϣ
	public void getInfo(UserVO userVO){
		ID = new JLabel(String.valueOf(userVO.getpersonalID()));
		account = new JLabel(String.valueOf(userVO.getpersonalAccount()));
		password = new JLabel(userVO.getMyPassword());
		name = new JLabel(userVO.getpersonalName());
		position = new JLabel(userVO.getMyPosition());
		salary = new JLabel(String.valueOf(userVO.getSalary().getTotal()));
		
		if(userVO.getCity() == null) city = new JLabel("��");
		else city = new JLabel(userVO.getCity());
		
		if(userVO.getBusinessHall() == null) businessHall = new JLabel("��");
		else businessHall = new JLabel(userVO.getBusinessHall());
			
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
		
		setAuthority();
	}
	
	
	//Ȩ��
	public void setAuthority(){
		int sp = 30;
		for(int i = 0; i < userVO.getAuthority().size();i++){
			JLabel authority = null;
//			this.add(authority);
			switch (userVO.getAuthority().get(i)) {
			case 1:authority = new JLabel("Ա���˺Ź���");break;
			case 2:authority = new JLabel("��ת���Ľ������ɼ�");break;
			case 3:authority = new JLabel("Ӫҵ���������ɼ�");break;
			case 4:authority = new JLabel("�տ��д");break;
			case 5:authority = new JLabel("����װ������");break;
			case 6:authority = new JLabel("�ɻ����𳵡�����װ�˹���");break;
			case 7:authority = new JLabel("��¼������Ϣ");break;	
			case 8:authority = new JLabel("�ջ���Ϣ");break;
			case 9:authority = new JLabel("�ֿ����");break;
			case 10:authority = new JLabel("������˾����Ϣ����");break;
			case 11:authority = new JLabel("��Ӫ�����ѯ");break;
			case 12:authority = new JLabel("��Ա��������");break;
			case 13:authority = new JLabel("��������");break;
			case 14:authority = new JLabel("�����д");break;
			case 15:authority = new JLabel("�˻�����");break;
			case 16:authority = new JLabel("�ɱ�����");break;
			case 17:authority = new JLabel("�������");break;
			case 18:authority = new JLabel("�޸�Ȩ��");break;
			case 19:authority = new JLabel("�鿴��־");break;
			case 20:authority = new JLabel("�ƶ�����");break;
			case 21:authority = new JLabel("�ڳ�����");break;
			default:
				break;
			}
			authority.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 5 + i * sp, w, h);
			authority.setFont(myFont);
			authority.setForeground(Color.WHITE);
			this.add(authority);
		}
			
	}
		
		
//	public static void main(String[] args) {
//		new UserPanel(new UserVO(100000, 100000, "aaaaaa", "����", "���Ա",
//				null, new SalaryPO(3000), "�Ͼ�", "��¥Ӫҵ��"));
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
		        		PanelController.setPresentPanel(new ChangePasswordPanel(userVO));
		        	}
		        	else if (e.getSource() == confirm) {
						
					}
		        	
		        }
	}

}
