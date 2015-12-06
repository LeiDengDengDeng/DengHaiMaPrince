package src.presentation.accountui;

import javax.swing.ImageIcon;

import src.vo.AccountVO;

public class ButtonDel extends AccountButton {
	private ImageIcon image = new ImageIcon("images/account_del.png");
	private ImageIcon imageEnter = new ImageIcon("images/account_delEnter.png");
	public ButtonDel(AccountVO vo,AccountPanel panel) {
		super(vo, panel);
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
		ButtonDelListener listener=new ButtonDelListener(this);
		this.addMouseListener(listener);
	}
}
