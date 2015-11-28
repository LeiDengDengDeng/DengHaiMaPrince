package src.presentation.accountui;

import javax.swing.ImageIcon;

import src.vo.AccountVO;

public class ButtonMod extends AccountButton {
	private static ImageIcon image = new ImageIcon("images/account_mod.png");
	private static ImageIcon imageEnter = new ImageIcon("images/account_modEnter.png");
	public ButtonMod(AccountVO vo,AccountPanel panel) {
		super(vo,panel);
		this.draw(image);
		// TODO Auto-generated constructor stub
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
		ButtonModListener listener=new ButtonModListener(this, panel);
		this.addMouseListener(listener);
	}
}
