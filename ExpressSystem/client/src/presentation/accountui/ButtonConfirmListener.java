package src.presentation.accountui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import src.presentation.mainui.PanelController;

public class ButtonConfirmListener extends AccountMouseListener {
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldAmount;
	ButtonConfirm buttonConfirm;
	public ButtonConfirmListener(AccountButton button) {
		super(button);
		buttonConfirm = (ButtonConfirm) button;
		textFieldName = buttonConfirm.textFieldName;
		textFieldNum = buttonConfirm.textFieldNum;
		textFieldAmount = buttonConfirm.textFieldAmount;
		// TODO Auto-generated constructor stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String name = textFieldName.getText();
		long num=Long.parseLong(textFieldNum.getText());
		double amount=Double.parseDouble(textFieldAmount.getText());

		panel.accountBL.addAccount(name,num,amount);
		PanelController.refreshPresentPanel();

	}

}
