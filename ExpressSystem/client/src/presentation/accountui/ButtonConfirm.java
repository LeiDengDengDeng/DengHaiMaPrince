package src.presentation.accountui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonConfirm extends AccountButton {

	JTextField textFieldName;
	JTextField textFieldNum;
	JTextField textFieldAmount;
	ButtonAdd buttonAdd;
	JLabel textAdd;
	ButtonAddListener listener;
	private static ImageIcon image = new ImageIcon("images/account_confirm.png");
	private static ImageIcon imageEnter = new ImageIcon("images/account_confirmEnter.png");

	public ButtonConfirm(ButtonAddListener listener) {
		
		this.listener=listener;
		this.textAdd = listener.textAdd;
		buttonAdd = (ButtonAdd)listener.button;
		textFieldName = listener.textFieldName;
		textFieldNum = listener.textFieldNum;
		textFieldAmount = listener.textFieldAmount;
		this.panel = listener.panel;
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
		ButtonConfirmListener listener = new ButtonConfirmListener(this);
		this.addMouseListener(listener);
	}
}