package src.presentation.userui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.internal.runners.TestMethod;

import src.presentation.institutionui.Institution_InfoPanel;
import src.presentation.institutionui.changeSalaryPanel;
import src.presentation.mainui.MainFrame;
import src.presentation.staffmanageui.StaffListPanel;
import src.presentation.staffmanageui.Staff_InfoPanel;
import src.vo.InstitutionVO;
import src.vo.SalaryVO;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class testmain extends JFrame{

	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	JLabel background = new JLabel(new ImageIcon("images/mainFrame.png"));
	
	public testmain(){
   		// ���ñ���
		this.setUndecorated(true);
		this.setSize(850, 646);
		// �������û��ı䴰�ڴ�С
		this.setResizable(false);
		// �����Ļ��С
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// ���ô���λ��
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
//		test.setContentPane(new Staff_InfoPanel(new StaffInfoVO(100000, 100000, "aaaaaa",
//						"����", "����Ա", null, null, null)));
//		test.setContentPane(new UserPanel(new UserVO(100000, 100000, "aaaaaa"
//				, "����", "���Ա", null, new SalaryVO(3000), null, null)));
//		test.setContentPane(new ChangePasswordPanel(new UserVO(100000, 100000, "aaaaaa"
//				, "����", "���Ա", null, new SalaryVO(3000), null, null)));
//		test.setContentPane(new changeSalaryPanel(new UserVO(100000, 100000, "aaaaaa"
//				, "����", "���Ա", null, new SalaryVO(3000), null, null)));
		test.setContentPane(new Institution_InfoPanel(new InstitutionVO("Ӫҵ��",
				100000, null, "������ת�����")));
		
//		ArrayList<StaffInfoVO> staffInfoVOs = new ArrayList<StaffInfoVO>();
//		for(int i = 0;i < 50; i++)
//			staffInfoVOs.add(new StaffInfoVO(100000, 100000, "aaaaaa",
//					"����", "����Ա", null, null, null));
//		StaffListPanel staffListPanel = new StaffListPanel(staffInfoVOs);
		
		
//		test.setContentPane(staffListPanel);
		test.setVisible(true);
		
	
	}
}