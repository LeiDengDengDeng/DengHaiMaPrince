package src.presentation.staffmanageui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import src.presentation.userui.UserPanel;

public class StaffManageFrame {
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
//	private static final ImageIcon IMG = new ImageIcon("images/staffManage_BG.png");
	private static final ImageIcon REC1 = new ImageIcon("images/account_rec1.png");
	private static final ImageIcon REC2 = new ImageIcon("images/account_rec2.png");
	private static final ImageIcon ADD_ICON = new ImageIcon("images/account_add.png");
	private static final ImageIcon ADDENTER_ICON = new ImageIcon("images/account_addEnter.png");
	private static final ImageIcon SEARCH = new ImageIcon("images/search.png");
	private static final ImageIcon SEARCHENTER = new ImageIcon("images/searchClicked.png");
	
	
	JFrame frame;
	StaffManagePanel staffManagePanel;
	JLabel addLabel;
	JLabel searchLabel;
	JLabel rec1;
	JLabel rec2;
	
	
	
	public static void main(String[] args){
		StaffManageFrame staffManageFrame = new StaffManageFrame();
		staffManageFrame.componentsInstantiation();
		staffManageFrame.initial();
	}
	
	
	
	public void componentsInstantiation(){
		frame  = new JFrame();
		staffManagePanel = new StaffManagePanel();
		addLabel = new JLabel();
		searchLabel = new JLabel();
		rec1 = new JLabel();
		rec2 = new JLabel();
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
		staffManagePanel.setBounds(0, 0, WIDTH, HEIGHT);
		staffManagePanel.setLayout(null);		
		
		
		addLabel.setIcon(ADD_ICON);
		
		
		rec1.setIcon(REC1);
		rec2.setIcon(REC2);
		
		
		searchLabel.setIcon(SEARCH);
		searchLabel.setBounds(750, 80, SEARCH.getIconWidth(), SEARCH.getIconHeight());
		searchLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				searchLabel.setIcon(SEARCH);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				searchLabel.setIcon(SEARCHENTER);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		staffManagePanel.add(addLabel);
		staffManagePanel.add(searchLabel);
		
		frame.setContentPane(staffManagePanel);
		frame.setVisible(true);
	}
	
	public void setRec(){
		
		
	}
	
}
