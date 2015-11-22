package src.presentation.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LeftButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private final static int WIDTH = 143;
//	private final static int HEIGHT = 87;
	private Image image;
	
	public LeftButton(){
		image = new ImageIcon("").getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
	}

}
