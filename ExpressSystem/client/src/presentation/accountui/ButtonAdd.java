package src.presentation.accountui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import src.vo.AccountVO;

public class ButtonAdd extends AccountButton {
	private static ImageIcon image = new ImageIcon("images/account_add.png");
	private static ImageIcon imageEnter = new ImageIcon("images/account_addEnter.png");
	public ButtonAdd(AccountVO vo,AccountPanel panel) {
		super(vo,panel);
		this.draw(image);
		// TODO Auto-generated constructor stub
	}
	public ButtonAdd(AccountPanel panel){
		super();
		this.draw(image);
		this.panel=panel;
		this.addListener(panel);
		

	}
	@Override
	ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return image;
	}
	@Override
	ImageIcon getImageIconEnter() {
		// TODO Auto-generated method stub
		return imageEnter;
	}
	@Override
	void addListener(AccountPanel panel) {
		// TODO Auto-generated method stub
		ButtonAddListener listener=new ButtonAddListener(this, panel);
		this.addMouseListener(listener);
	}
}
