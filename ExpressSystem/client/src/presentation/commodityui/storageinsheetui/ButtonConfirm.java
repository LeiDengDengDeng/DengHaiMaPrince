package src.presentation.commodityui.storageinsheetui;

import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ButtonConfirm extends storageInButton {

	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldRowNumber;
	TextField textFieldShelfNumber;
	TextField textFieldSeatNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxAreaNumber;
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
		this.textFieldRowNumber = listener.textFieldRowNumber;
		this.textFieldShelfNumber = listener.textFieldShelfNumber;
		this.textFieldSeatNumber = listener.textFieldSeatNumber;
		this.comboBoxDestination = listener.comboBoxDestination;
		this.comboBoxAreaNumber = listener.comboBoxAreaNumber;
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
	void addListener(StorageInSheetPanel panel) {
		// TODO Auto-generated method stub
		ButtonConfirmListener listener = new ButtonConfirmListener(this);
		this.addMouseListener(listener);
	}
}