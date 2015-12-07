package src.presentation.beginInfoui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BeginInfoButton extends JButton{
	ImageIcon img;
	ImageIcon imgEnter;
	protected BeginInfoButton (ImageIcon img,ImageIcon imgEnter,Point p){
		this.img=img;
		this.imgEnter=imgEnter;
		this.setIcon(img);
		this.setBounds(p.x, p.y, img.getIconWidth(), img.getIconHeight());
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.addListener();
	}
	private void addListener(){
		this.addMouseListener(new MouseListener() {
			
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
				((BeginInfoButton)e.getSource()).setIcon(img);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				((BeginInfoButton)e.getSource()).setIcon(imgEnter);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//			((BeginInfoButton)e.getSource()).setIcon(imgEnter);
				
			}
		});
	}
	
}
