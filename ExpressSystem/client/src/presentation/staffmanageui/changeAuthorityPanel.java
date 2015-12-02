package src.presentation.staffmanageui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class changeAuthorityPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int WIDTH = 641;
	private final static int HEIGHT = 572;
	private final static int x = 80;
	private final static int y = 40;
	
	private JFrame frame;
	private JTextArea authority;
	private JScrollPane scroll;
	
	public changeAuthorityPanel(){
		
		 componentsInstantiation();
	     initial();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		changeAuthorityPanel changeAuthority = new changeAuthorityPanel();
		changeAuthority.run();

	}
	
	public void run(){
       
	}
	
	public void initial(){
		 frame.setBounds(0, 0, 870, 690);
	     frame.setContentPane(this);
	     frame.setVisible(true);
//	     frame.setResizable(false);
	     
	     authority.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
	     authority.setText("总经理 ：\n"
					+ "管理员 ：\n"
					+ "财务人员 ：\n"
					+ "中转中心仓库管理人员 ：\n"
					+ "中转中心业务员 ：\n"
					+ "营业厅业务员 ：\n"
					+ "快递员 ：\n");
	     authority.setLineWrap(true);
	     scroll.setBounds(250, 120, 500, 400);
		 scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
		 frame.add(authority);
		 frame.add(scroll);
	
	}

	public void componentsInstantiation(){
		frame = new JFrame();
		authority = new JTextArea();
		scroll = new JScrollPane(authority);
		
	}
	
	public void paintComponent(Graphics g){
		
		Image image = new ImageIcon("images/AdministratorBG.png").getImage();
		
		g.drawImage(image,0,0,this);
		
	}
}
