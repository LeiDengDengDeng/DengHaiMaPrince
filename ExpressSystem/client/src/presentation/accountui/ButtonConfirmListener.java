package src.presentation.accountui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

public class ButtonConfirmListener extends AccountMouseListener {
TextField textFieldName;
TextField textFieldNum;
TextField textFieldAmount;
ButtonConfirm buttonConfirm;
	public ButtonConfirmListener(AccountButton button,AccountPanel panel) {
		super(button,panel);
		buttonConfirm=(ButtonConfirm)button;
		textFieldName=buttonConfirm.name;
		textFieldNum=buttonConfirm.num;
		textFieldAmount=buttonConfirm.amount;
		// TODO Auto-generated constructor stub
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("gg");
		panel.accountBL.addAccount(textFieldName.getText(), Long.parseLong(textFieldNum.getText()), Double.parseDouble(textFieldAmount.getText()));
		panel.remove(textFieldName);

	}

}
