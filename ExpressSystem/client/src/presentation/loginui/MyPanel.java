package src.presentation.loginui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g){
		
		Image image = new ImageIcon("images/logIn_BG.png").getImage();
		
		g.drawImage(image,0,0,this);
		
	}

}
