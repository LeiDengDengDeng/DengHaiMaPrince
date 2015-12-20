package src.presentation.commodityui.storageoutsheetui;

import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import src.presentation.accountui.TextLabel;

public class ButtonCancel extends storageOutButton {
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldTransNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxTransportForm;
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
		this.comboBoxDestination = listener.comboBoxDestination;
		this.comboBoxTransportForm = listener.comboBoxTransportForm;
		this.textFieldTransNumber = listener.textFieldTransNumber;
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
	void addListener(StorageOutSheetPanel panel) {
		// TODO Auto-generated method stub
		ButtonCancelListener listener=new ButtonCancelListener(this);
		this.addMouseListener(listener);
	}
}