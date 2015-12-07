package src.presentation.accountui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

public class ButtonCancelListener extends AccountMouseListener {
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldAmount;
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
		panel.remove(textFieldName);
		panel.remove(textFieldNum);
		panel.remove(textFieldAmount);
		panel.remove(button);
		panel.remove(panel.formList.get(panel.formList.size()-1));
		panel.remove(buttonCancel.textAdd);
		panel.remove(buttonCancel.listener.buttonConfirm);
		panel.remove(buttonCancel.buttonAdd);
		panel.drawAccount();
		panel.repaint();

	}

}
