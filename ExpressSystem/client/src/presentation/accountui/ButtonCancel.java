package src.presentation.accountui;

import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonCancel extends AccountButton {
	public TextField name;
	TextField num;
	TextField amount;
	ButtonAdd buttonAdd;
	TextLabel textAdd;
	ButtonAddListener listener;
	private static ImageIcon image = new ImageIcon("images/account_cancel.png");
	private static ImageIcon imageEnter = new ImageIcon("images/account_cancelEnter.png");
	public ButtonCancel(ButtonAddListener listener) {
		this.listener=listener;
		this.textAdd=listener.textAdd;
		this.name=listener.textFieldName;
		this.num=listener.textFieldNum;
		this.amount=listener.textFieldAmount;
		this.panel=listener.panel;
		this.buttonAdd=(ButtonAdd)listener.button;
		this.draw(image);
		this.addListener(panel);
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
		ButtonCancelListener listener=new ButtonCancelListener(this);
		this.addMouseListener(listener);
	}
}