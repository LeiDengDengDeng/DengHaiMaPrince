package src.presentation.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Created by dell on 2015/11/27. 用途
 */
public class ConfirmButton extends JButton {
	ImageIcon unclickedImage = new ImageIcon("images/confirm.png");
	ImageIcon clickedImage = new ImageIcon("images/confirmClicked.png");

	// x,y对应距顶点的宽和长
	public ConfirmButton(int x, int y) {
		this.setIcon(unclickedImage);
        this.setBounds(x, y, unclickedImage.getIconWidth(), unclickedImage.getIconHeight());
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				unclicked(e);	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(e);	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				unclicked(e);	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				clicked(e);	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked(e);			
			}
			
			private void clicked(MouseEvent e) {
		        ((JButton) e.getSource()).setIcon(clickedImage);
		    }

		    private void unclicked(MouseEvent e) {
		        ((JButton) e.getSource()).setIcon(unclickedImage);
		    }
        });

	}
}
