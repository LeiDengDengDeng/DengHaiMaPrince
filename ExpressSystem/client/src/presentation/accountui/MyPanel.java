package src.presentation.accountui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	JButton account;
	private static final Image IMG=new ImageIcon("F:/软工二/BackGround1.png").getImage(); 
	private static final ImageIcon IMGbutton=new ImageIcon("F:/软工二/ButtonA.png"); 
	public MyPanel(){
		this.setLayout(null);
		account=new JButton();
//		account.setBounds(50, 20, 144, 45);
		account.setLocation(50, 90);
		account.setSize(IMGbutton.getIconWidth(), IMGbutton.getIconHeight());
		account.setIcon(IMGbutton);
		this.add(account);
	}
	
	public void paintComponent(Graphics g){
    //调用父类
    super.paintComponent(g);
   //循环刷新游戏画面
    g.drawImage(IMG,0, 0, 850, 646, null);
    //返回焦点
	
   }
		
} 