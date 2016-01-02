package src.presentation.institutionui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.institutionbl.Institution;
import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.businesslogic.userbl.User;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.InstitutionVO;
import src.vo.UserVO;

public class changeStaff_InfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7132007588856630656L;
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 80;
	static final int y = 40;
	static final int w = 130;
	static final int h = 30;
	static final int linesp = 53;
	static final int columnsp = 250;
	static final int coordinate_X = 40;
	static final int coordinate_Y = 40;
	
	Font myFont = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");

	Institution institution;
	User user;
	Log log;
	IntermediateCenter intermediateCenter;
	UserVO userVO;
	InstitutionVO institutionVO;
	MyButton cancelButton;
	MyButton confirmbuButton;
	MyButton modifyButton;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
    
	private	JLabel ID;
	private	JLabel account;
	private	JLabel password;
	private	JLabel name;
	private	JTextField position;
	private	JLabel salary;
	private	JComboBox<String> city;
	private	JTextField businessHall;
	
	long staffID;
	long staffAccount;
	String staffPassword;
	String staffName;
	String staffPosition;
	String staffCity;
	String staffbusinessHall;
	
	public changeStaff_InfoPanel(UserVO userVO,InstitutionVO institutionVO){
		this.institutionVO = institutionVO;
		this.userVO = userVO;
		componentsInstantiation();
		getPrimaryInfo(userVO);
		initial();
		
		buttonActionListener listener = new buttonActionListener(this);
        cancelButton.addActionListener(listener);
        confirmbuButton.addActionListener(listener);
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
		this.add(cancelButton);
		this.add(confirmbuButton);
		this.add(modifyButton);
		this.add(imageLabel);

		this.setLayout(null);
		this.setOpaque(false);
		
		
		
		
	}
	
	public void componentsInstantiation(){
		log = new Log();
		user = new User(log);
		institution = new Institution(log);
		intermediateCenter = new IntermediateCenter(log);
		imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/user_InfoBG.png");
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, coordinate_X + 350, coordinate_Y + 480,false);
		confirmbuButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 450, coordinate_Y + 480,false);
		modifyButton = new MyButton(new ImageIcon("images/modify_icon.png"), 
				new ImageIcon("images/modify_iconEnter.png"), coordinate_X + x + w / 2, coordinate_Y + y + linesp * 4 + 5,false);
	}
	
	//��ø�����Ϣ
	public void getPrimaryInfo(UserVO userVO){
		ID = new JLabel(String.valueOf(userVO.getpersonalID()));
		account = new JLabel(String.valueOf(userVO.getpersonalAccount()));
		password = new JLabel(userVO.getMyPassword());
		name = new JLabel(userVO.getpersonalName());
		position = new JTextField(userVO.getMyPosition());
		salary = new JLabel(String.valueOf(userVO.getSalary().getTotal()));
		city = new JComboBox<String>();
		city.setModel(new DefaultComboBoxModel<String>(getCitys()));
		if(userVO.getCity() == null) city.setSelectedItem("��");
		else city.setSelectedItem(userVO.getCity());
		
		if(userVO.getBusinessHall() == null) businessHall = new JTextField("��");
		else businessHall = new JTextField(userVO.getBusinessHall());
			
		name.setBounds(coordinate_X + x, coordinate_Y + y, w, h);
		position.setBounds(coordinate_X + x + columnsp, coordinate_Y + y + 7, w + 20, 20);
		ID.setBounds(coordinate_X + x, coordinate_Y + y + linesp, w, h);
		account.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 2, w, h);
		password.setBounds(coordinate_X + x + columnsp, coordinate_Y + y + linesp * 2, w, h);
		city.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 3 + 2, 60, 24);
		salary.setBounds(coordinate_X + x, coordinate_Y + y + linesp * 4 + 5, w / 2, 20);
		businessHall.setBounds(coordinate_X + x + columnsp + 13, coordinate_Y + y + linesp * 3 + 6, w - 20, 20);
			
		name.setFont(myFont);
		name.setForeground(Color.WHITE);
		position.setFont(myFont);
		ID.setFont(myFont);
		ID.setForeground(Color.WHITE);
		account.setFont(myFont);
		account.setForeground(Color.WHITE);
		password.setFont(myFont);
		password.setForeground(Color.WHITE);
		city.setFont(myFont);
		businessHall.setFont(myFont);
		salary.setFont(myFont);
		salary.setForeground(Color.WHITE);
		
		setAuthority();
	}
	
	//��ó����б�
		public String[] getCitys(){
			ArrayList<String> citys = intermediateCenter.getcity();
			String[] cityList = new String[citys.size() + 1];
			cityList[0] = "��";
			for(int i = 0;i < citys.size();i++)
				cityList[i + 1] = citys.get(i);
			return cityList;
			
		}
		
	//�����д����Ϣ
		public void getInfo(){
			staffID = userVO.getpersonalID();
			staffAccount = userVO.getpersonalID();
			staffPassword = userVO.getMyPassword();
			staffName = userVO.getpersonalName();
			staffPosition = position.getText();
			staffCity = (String) city.getSelectedItem();
			staffbusinessHall = businessHall.getText();
			
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
		
	class buttonActionListener implements ActionListener {
	       changeStaff_InfoPanel container;
		       
	        public buttonActionListener(changeStaff_InfoPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(e.getSource() == cancelButton){
		        		PanelController.setPresentPanel(new StaffPanel(userVO,institutionVO));
		        	} else if (e.getSource() == confirmbuButton) {
		        		if(ID.getText().length() == 0 || account.getText().length() == 0
			        			   || password.getText().length() == 0 || name.getText().length() == 0
			        			   || position.getText().length() == 0){
			        		   TipDialog tipDialog = new TipDialog(null, "", true, "��������д��", false);
			           		}else{
			           			getInfo();
			           			if(businessHall.getText().length() == 0)
			           				staffbusinessHall = null;
			           			if(city.getSelectedItem().equals("��"))
			           				staffCity = null;
			           			//���¸�����Ϣ
			           			user.changeInfo(new UserVO(staffID, staffAccount, staffPassword,
			           					staffName, staffPosition, userVO.getAuthority(),
			           					userVO.getSalary(), staffCity, staffbusinessHall));
			           			//����Ա���б�
			           			ArrayList<UserVO> userVOs = new ArrayList<UserVO>();
			           			for(int i = 0;i < institutionVO.getStaff().size();i++){
									if(institutionVO.getStaff().get(i).getpersonalID() == userVO.getpersonalID()){
										userVOs.add(user.getPersonalInfo(userVO.getpersonalID()));
									}
									else userVOs.add(institutionVO.getStaff().get(i));
								}
			           			institutionVO.setStaff(userVOs);
			           			//���»�����Ϣ
			           			institution.changeInstitutionInfo(institutionVO);
			           		}
		        		PanelController.setPresentPanel(new 
		        				StaffPanel(user.getPersonalInfo(userVO.getpersonalID()),institutionVO));
					} else if(e.getSource() == modifyButton) {
						PanelController.setPresentPanel(new changeSalaryPanel(userVO,institutionVO));
					}
		        	
		        }
	}

}
