package src.presentation.accountui;

import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import src.presentation.mainui.PanelController;

public class ButtonCancelListener extends AccountMouseListener {
	JTextField textFieldName;
	JTextField textFieldNum;
	JTextField textFieldAmount;
	ButtonCancel buttonCancel;

	public ButtonCancelListener(AccountButton button) {
		super(button);
		buttonCancel = (ButtonCancel) button;
		textFieldName = buttonCancel.name;
		textFieldNum = buttonCancel.num;
		textFieldAmount = buttonCancel.amount;
		// TODO Auto-generated constructor stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PanelController.refreshPresentPanel();

	}

}
