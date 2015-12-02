package src.presentation.staffmanageui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StaffManagePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		
		Image image = new ImageIcon("images/staffManage_BG.png").getImage();
		
		g.drawImage(image,0,0,this);
		
	}

}
