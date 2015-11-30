package src.presentation.accountui;

import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import src.vo.AccountVO;

public abstract class AccountButton extends JButton {
//	private static ImageIcon image=null ;
	protected AccountVO vo;
	AccountPanel panel;
	public AccountButton(AccountVO vo,AccountPanel panel) {
		this.vo=vo;
		this.addListener(panel);
		this.panel=panel;
	}
	public AccountButton() {
	}
	public AccountButton(TextField name,TextField num,TextField amount) {
		
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
	abstract void addListener(AccountPanel panel);
}
