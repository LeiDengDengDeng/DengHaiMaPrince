package src.presentation.institutionui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import src.presentation.util.MyButton;
import src.vo.InstitutionVO;

public class AddInstitutionPanel {
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 115;
	static final int y = 40;
	static final int w = 180;
	static final int h = 16;
	static final int linesp = 48;
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	
	JFrame frame;
	MainPanel mainPanel;
	
	MyButton confirmButton;
	MyButton deleteButton;
	
	private JTextField institutionID;
	private JTextField institutionName;
	private JTextArea institutionfunction;
	
	long ID;
	String name;
	String function;
	
	
	public AddInstitutionPanel(){
		componentsInstantiation();
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
		final int coo_x = (screen.width - WIDTH) >> 1;
		final int coo_y = ((screen.height - HEIGHT) >> 1) - 32;

		frame.setLocation(coo_x, coo_y);
		// 设置默认panel
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
		
		institutionID.setBounds(x, y, w, h);
		institutionName.setBounds(x, y + linesp, w, h);
		institutionfunction.setBounds(x + 20, y + linesp * 2 + 2, w , h * 3);
		
		
		
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
		institutionID = new JTextField();
		institutionName = new JTextField();
		institutionfunction = new JTextArea(3, 1);
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 450, 220,false);
		deleteButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, 350, 220,false);
		
		
	}
	public void getInstitutionInfo(InstitutionVO institutionVO){
		ID = Long.parseLong(institutionID.getText());
		name = institutionName.getText();
		function = institutionfunction.getText();
		

		
	}
	public static void main(String[] args) {
		AddInstitutionPanel p = new AddInstitutionPanel();
		}
}
