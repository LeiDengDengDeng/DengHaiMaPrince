package src.presentation.commodityui.storageinsheetui;

import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ButtonCancel extends storageInButton {
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldRowNumber;
	TextField textFieldShelfNumber;
	TextField textFieldSeatNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxAreaNumber;
	ButtonAdd buttonAdd;
	TextLabel textAdd;
	ButtonAddListener listener;
	private static ImageIcon image = new ImageIcon("images/account_cancel.png");
	private static ImageIcon imageEnter = new ImageIcon("images/account_cancelEnter.png");
	public ButtonCancel(ButtonAddListener listener) {
		this.listener = listener;
		this.textAdd = listener.textAdd;
		this.textFieldName = listener.textFieldName;
		this.textFieldNum = listener.textFieldNum;
		this.textFieldRowNumber = listener.textFieldRowNumber;
		this.textFieldShelfNumber = listener.textFieldShelfNumber;
		this.textFieldSeatNumber = listener.textFieldSeatNumber;
		this.comboBoxDestination = listener.comboBoxDestination;
		this.comboBoxAreaNumber = listener.comboBoxAreaNumber;
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
	void addListener(StorageInSheetPanel panel) {
		// TODO Auto-generated method stub
		ButtonCancelListener listener=new ButtonCancelListener(this);
		this.addMouseListener(listener);
	}
}