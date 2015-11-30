package src.presentation.accountui;

import java.awt.TextField;

import javax.swing.ImageIcon;

public class ButtonConfirm extends AccountButton {
	public TextField name;
	TextField num;
	TextField amount;
	private static ImageIcon image = new ImageIcon("images/account_confirm.png");
	private static ImageIcon imageEnter = new ImageIcon("images/account_confirmEnter.png");
	public ButtonConfirm(TextField name,TextField num,TextField amount) {
		super(name,num,amount);
		this.name=name;
		this.num=num;
		this.amount=amount;
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
		ButtonConfirmListener listener=new ButtonConfirmListener(this, panel);
		this.addMouseListener(listener);
	}
}