package src.presentation.userui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{

	public void paintComponent(Graphics g){
		
		Image image = new ImageIcon("images/background.png").getImage();
		
		g.drawImage(image,0,0,this);
		
	}

}
