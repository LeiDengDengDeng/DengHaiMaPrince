package src.presentation.staffmanageui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.presentation.userui.UserFrame;
import src.vo.StaffInfoVO;

public class StaffList extends JPanel{
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	private static final ImageIcon DELETE_ICON = new ImageIcon("images/search.png");
	private static final ImageIcon LOOK_ICON = new ImageIcon("images/searchClicked.png");
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);

	ArrayList<StaffInfoVO> Staffs;
	MyPanel myPanel;
	private JFrame frame;
	
	public StaffList(){
		componentsInstantiation();
		initial();
	}
	
	
	public static void main(String[] args){
		StaffList u = new StaffList();
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
		myPanel.setBounds(0, 0, WIDTH, HEIGHT);
		myPanel.setLayout(null);
		
		frame.setContentPane(myPanel);
		frame.setVisible(true);
		
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
		myPanel = new MyPanel();
	}
	

}
