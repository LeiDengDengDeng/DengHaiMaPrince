package src.presentation.institutionui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.logbl.Log;
import src.businesslogic.logbl.LogBLService_Driver;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.staffmanagebl.Salary;
import src.businesslogic.userbl.User;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.InstitutionVO;
import src.vo.SalaryVO;
import src.vo.UserVO;

public class changeSalaryPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 95;
	static final int y = 63;
	static final int w = 100;
	static final int h = 16;
	static final int linesp = 49;
	static final int coordinate_X = 40;
	static final int coordinate_Y = 40;
	
	
	private static final ImageIcon CANCEL_ICON= new ImageIcon("images/cancel.png");
	private static final ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	
	private JTextField basicField;
	private JTextField eachPayField;
	private JTextField commissionField;
	MyButton confirmButton;
	MyButton cancelButton;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
    
    InstitutionVO institutionVO;
	UserVO userVO;
	User user;
	Log log;
	LogIn logIn;
	Salary salary;
	int basic;
	int eachPay;
	int commission;
	
	public changeSalaryPanel(UserVO userVO,InstitutionVO institutionVO){
		log = new Log();
		user = new User(log);
		logIn = new LogIn(user); 
		salary = new Salary(user,log);
		
		this.institutionVO = institutionVO;
		this.userVO = userVO;
		componentsInstantiation();
		initial();
		
		buttonActionListener listener = new buttonActionListener(this);
        confirmButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
		
	}
	
//	public void paintComponent(Graphics g){
//		
//		Image image = new ImageIcon("images/password_BG.png").getImage();
//		
//		g.drawImage(image,0,0,this);
//		
//	}
	
	public void componentsInstantiation(){
		bkgImg = new ImageIcon("images/institution_salary.png");
		imageLabel = new JLabel();
		basicField = new JTextField(String.valueOf(userVO.getSalary().getBasic()));
		eachPayField = new JTextField(String.valueOf(userVO.getSalary().getEachPay()));
		commissionField = new JTextField(String.valueOf(userVO.getSalary().getCommission()));
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 350, coordinate_Y + 210,false);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, coordinate_X + 450, coordinate_Y + 210,false);
		
	}

	public void initial(){
		this.setLayout(null);
		
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
		basicField.setBounds(coordinate_X + x, coordinate_Y + y, w, h);
		eachPayField.setBounds(coordinate_X + x, coordinate_Y + y + linesp, w, h);
		commissionField.setBounds(coordinate_X + x + 20, coordinate_Y + y + linesp * 2, w - 20, h);

		
		this.add(basicField);
		this.add(eachPayField);
		this.add(commissionField);
		this.add(confirmButton);
		this.add(cancelButton);
		this.add(imageLabel);
		this.setOpaque(false);
		
		
	}
	
	class buttonActionListener implements ActionListener {
	       changeSalaryPanel container;
		       
	        public buttonActionListener(changeSalaryPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(e.getSource() == cancelButton){
		        		PanelController.setPresentPanel(new StaffPanel(userVO,institutionVO));
		        		
		        	}else if (e.getSource() == confirmButton) {
		        		basic = Integer.parseInt(basicField.getText());
		        		eachPay = Integer.parseInt(eachPayField.getText());
		        		commission = Integer.parseInt(commissionField.getText());
//		        		System.out.println(basic + " " + eachPay + " " + commission);
		        		if(commission < 0 || commission > 100){
		        			TipDialog tipDialog = new TipDialog(null, "", true,
									"��ɷ�ΧΪ0����100��", false);
		        		}else{
		        			SalaryVO salaryVO = new SalaryVO(basic);
		        			salaryVO.setEachPay(eachPay);
		        			salaryVO.setCommission(commission);
		        			salary.changeSalary(userVO.getpersonalID(), salaryVO);
		        		}
		        		PanelController.setPresentPanel(new 
		        				StaffPanel(user.getPersonalInfo(userVO.getpersonalID()),institutionVO));
		        	}
		        }
	}
}
