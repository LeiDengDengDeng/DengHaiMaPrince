package src.presentation.userui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.internal.runners.TestMethod;

import src.businesslogic.staffmanagebl.StaffManage;
import src.businesslogic.userbl.User;
import src.presentation.institutionui.AddInstitutionPanel;
import src.presentation.institutionui.InstitutionListPanel;
import src.presentation.institutionui.Institution_InfoPanel;
import src.presentation.institutionui.changeSalaryPanel;
import src.presentation.mainui.MainFrame;
import src.presentation.staffmanageui.AccountantAuthorityPanel;
import src.presentation.staffmanageui.AddStaffPanel;
import src.presentation.staffmanageui.AdministratorAuthorityPanel;
import src.presentation.staffmanageui.BusinessAuthorityPanel;
import src.presentation.staffmanageui.CourierAuthorityPanel;
import src.presentation.staffmanageui.InterAuthorityPanel;
import src.presentation.staffmanageui.KeeperAuthorityPanel;
import src.presentation.staffmanageui.StaffListPanel;
import src.presentation.staffmanageui.Staff_InfoPanel;
import src.presentation.staffmanageui.ManagerAuthorityPanel;
import src.vo.InstitutionVO;
import src.vo.SalaryVO;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class testmain extends JFrame{

	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	JLabel background = new JLabel(new ImageIcon("images/mainFrame.png"));
	
	public testmain(){
   		// 设置标题
		this.setUndecorated(true);
		this.setSize(850, 646);
		// 不允许用户改变窗口大小
		this.setResizable(false);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		final int x = (screen.width - WIDTH) >> 1;
		final int y = ((screen.height - HEIGHT) >> 1) - 32;

		this.setLocation(x, y);
		
		background.setBounds(0, 0, 850, 646);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		
		this.setLayout(null);
//		frame.setContentPane(this);
	}
	
    public testmain getFrame() {
        return this;
    }
	
	public static void main(String[] args) {
		testmain test = new testmain();
//		User user = new User(null);
//		StaffManage staffManage = new StaffManage(null, null);
//		test.setContentPane(new Staff_InfoPanel(staffManage.getStaffInfo(100000)));
//		System.out.println(user.getPersonalInfo(100000).getAuthority().size());
//		test.setContentPane(new UserPanel());
//		test.setContentPane(new ChangePasswordPanel(new UserVO(100000, 100000, "aaaaaa"
//				, "张三", "快递员", null, new SalaryVO(3000), null, null)));
//		test.setContentPane(new changeSalaryPanel(new UserVO(100000, 100000, "aaaaaa"
//				, "张三", "快递员", null, new SalaryVO(3000), null, null)));
//		test.setContentPane(new AddStaffPanel());
		
//		ArrayList<UserVO> userVOs = new ArrayList<UserVO>();
//		for (int i = 0; i < 20; i++)
//			userVOs.add(new UserVO(100000, 100000, "aaaaaa"
//					, "张三", "快递员", null, new SalaryVO(3000), null, null));
//		test.setContentPane(new Institution_InfoPanel(new InstitutionVO("营业厅",
//				100000, userVOs, "负责中转与接收")));
//		
//		ArrayList<InstitutionVO> institutionVOs = new ArrayList<InstitutionVO>();
//		for (int i = 0; i < 17; i++)
//			institutionVOs.add(new InstitutionVO("营业厅", 100000, userVOs, "负责中转与接收"));
		test.setContentPane(new InstitutionListPanel());
		
//		ArrayList<StaffInfoVO> staffInfoVOs = new ArrayList<StaffInfoVO>();
//		for(int i = 0;i < 50; i++)
//			staffInfoVOs.add(new StaffInfoVO(100000, 100000, "aaaaaa",
//					"张三", "管理员", null, null, null));
//		StaffListPanel staffListPanel = new StaffListPanel(staffInfoVOs);
//		test.setContentPane(staffListPanel);
//		test.setContentPane(new changeAuthorityPanel());
//		test.setContentPane(new AddInstitutionPanel());
//		test.setContentPane(new CourierAuthorityPanel());
		
		test.setVisible(true);
		
	
	}
}
