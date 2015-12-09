package src.presentation.institutionui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.presentation.util.MyButton;
import src.vo.InstitutionVO;

public class Institution_InfoPanel {
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 115;
	static final int y = 33;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 48;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private static final ImageIcon DELETE_ICON = new ImageIcon("images/delete.png");
	private static final ImageIcon DELETEENTER_ICON = new ImageIcon("images/delete_Enter.png");
	
	InstitutionVO institutionVO;
	
	JFrame frame;
	MainPanel mainPanel;
	
	MyButton confirmButton;
	MyButton deleteButton;
	
	private JLabel institutionID;
	private JLabel institutionName;
	private JLabel institutionfunction;
	
	
	public Institution_InfoPanel(InstitutionVO institutionVO){
		this.institutionVO = institutionVO;
		componentsInstantiation();
		getInstitutionInfo(institutionVO);
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
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
		
		
		
		mainPanel.add(institutionID);
		mainPanel.add(institutionName);
		mainPanel.add(institutionfunction);
		mainPanel.add(confirmButton);
		mainPanel.add(deleteButton);
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
		mainPanel = new MainPanel();
		institutionID = new JLabel();
		institutionName = new JLabel();
		institutionfunction = new JLabel();
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 450, 220,false);
		deleteButton = new MyButton(DELETE_ICON, DELETEENTER_ICON, 350, 220,false);
		
		
	}
	public void getInstitutionInfo(InstitutionVO institutionVO){
		institutionID = new JLabel(String.valueOf(institutionVO.getInstitutionID()));
		institutionName = new JLabel(institutionVO.getInstitutionName());
		institutionfunction = new JLabel(institutionVO.getFunction());
		
		institutionID.setBounds(x, y, w, h);
		institutionID.setFont(myFont);
		institutionID.setForeground(Color.WHITE);
		institutionName.setBounds(x, y + linesp, w, h);
		institutionName.setFont(myFont);
		institutionName.setForeground(Color.WHITE);
		institutionfunction.setBounds(x + 20, y + linesp * 2 + 2, w , h);
		institutionfunction.setFont(myFont);
		institutionfunction.setForeground(Color.WHITE);
		
	}
	public static void main(String[] args) {
		Institution_InfoPanel p = new Institution_InfoPanel(new
				InstitutionVO("财务部", 100000, null, "负责财务管理"));
	}
	

}
