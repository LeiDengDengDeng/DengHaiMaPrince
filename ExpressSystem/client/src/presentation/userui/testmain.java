package src.presentation.userui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.junit.internal.runners.TestMethod;

import src.presentation.mainui.MainFrame;
import src.presentation.staffmanageui.StaffListPanel;
import src.presentation.staffmanageui.Staff_InfoPanel;
import src.vo.SalaryVO;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class testmain extends JFrame{

	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	
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
		
		this.setLayout(null);
//		frame.setContentPane(this);
	}
	
    public testmain getFrame() {
        return this;
    }
	
	public static void main(String[] args) {
		testmain test = new testmain();
//		test.setContentPane(new Staff_InfoPanel(new StaffInfoVO(100000, 100000, "aaaaaa",
//						"张三", "管理员", null, null, null)));
//		test.setContentPane(new UserPanel(new UserVO(100000, 100000, "aaaaaa"
//				, "张三", "快递员", null, new SalaryVO(3000), null, null)));

		ArrayList<StaffInfoVO> staffInfoVOs = new ArrayList<StaffInfoVO>();
		for(int i = 0;i < 50; i++)
			staffInfoVOs.add(new StaffInfoVO(100000, 100000, "aaaaaa",
					"张三", "管理员", null, null, null));
		StaffListPanel staffListPanel = new StaffListPanel(staffInfoVOs);
		
		
		test.setContentPane(staffListPanel);
		test.setVisible(true);
		
	
	}
}
