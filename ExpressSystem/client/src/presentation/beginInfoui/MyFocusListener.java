package src.presentation.beginInfoui;

import java.awt.Image;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyFocusListener implements FocusListener {
	static final ImageIcon check = new ImageIcon("images/check_icon.png");
	static final ImageIcon error = new ImageIcon("images/error_icon.png");
	boolean onceGained = false;
	ImageIcon icon = new ImageIcon();
	JLabel checklabel = new JLabel(icon);
	SubPanel panel;

	public MyFocusListener(SubPanel panel) {
		super();
		this.panel = panel;
		this.panel.add(checklabel);
	}

	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if (onceGained == false) {
			checklabel.setBounds(((TextField) e.getSource()).getX() + 2 + ((TextField) e.getSource()).getWidth(),
					((TextField) e.getSource()).getY() + 2, 14, 14);
		}
		onceGained = true;
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (onceGained == true) {
			if (((TextField) e.getSource()).getText().length() !=0){
				icon.setImage(check.getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
			
			}else
				icon.setImage(error.getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
			this.panel.repaint();
		}
	}

}
