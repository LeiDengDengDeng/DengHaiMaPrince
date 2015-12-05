package src.presentation.userui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import src.vo.AccountVO;
import src.vo.UserVO;

public abstract class UserButton extends JButton {
//	private static ImageIcon image=null ;
	protected UserVO vo;
	UserPanel panel;
	public UserButton(UserVO vo,UserPanel panel) {
		this.vo = vo;
		this.addListener(panel);
		this.panel = panel;
	}
	public UserButton() {
	}
	abstract ImageIcon getImageIcon();
	abstract ImageIcon getImageIconEnter();
	
	void draw(ImageIcon image) {
		this.setIcon(getImageIcon());
		this.setSize(getImageIcon().getIconWidth(), getImageIcon().getIconWidth());
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);

	}
	int getIconWidth(){
		return getImageIcon().getIconWidth();
	}
	abstract void addListener(UserPanel panel);
}
