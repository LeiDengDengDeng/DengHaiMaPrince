package src.presentation.accountui;

import javax.swing.ImageIcon;

import src.vo.AccountVO;

public class ButtonConfirm extends AccountButton {

	private static ImageIcon image = new ImageIcon("images/account_confirm.png");
	private static ImageIcon imageEnter = new ImageIcon("images/account_confirmEnter.png");
	public ButtonConfirm(AccountVO vo,AccountPanel panel) {
		super(vo,panel);
		this.draw(image);
		// TODO Auto-generated constructor stub
	}
	public ButtonConfirm(AccountPanel panel){
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
		ButtonConfirmListener listener=new ButtonConfirmListener(this, panel);
		this.addMouseListener(listener);
	}
}