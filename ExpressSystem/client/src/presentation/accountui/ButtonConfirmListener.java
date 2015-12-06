package src.presentation.accountui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

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
		panel.remove(textFieldName);
		panel.remove(textFieldNum);
		panel.remove(textFieldAmount);
		panel.remove(buttonConfirm);
		panel.remove(buttonConfirm.listener.buttonCancel);
		panel.remove(panel.formList.get(panel.formList.size()-1));
		panel.remove(buttonConfirm.buttonAdd);
		panel.remove(buttonConfirm.textAdd);
		panel.drawAccount();
		panel.repaint();

	}

}
