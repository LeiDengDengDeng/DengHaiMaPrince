package src.presentation.accountui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import src.businesslogic.util.CommonUtil;
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
		String num = textFieldNum.getText();
		if ((name.length() != 0) && (CommonUtil.isValidNumberString(num, 19))
				&& (textFieldAmount.getText().length() != 0)) {
			
			double amount=Double.parseDouble(textFieldAmount.getText());
			
			if(panel.accountBL.addAccount(name, num, amount)){
				//≥…π¶µØ¥∞
			}
			else{
				// ß∞‹µØ¥∞
			}
		}
		else{
			//–≈œ¢¥ÌŒÛµØ¥∞
		}
		PanelController.refreshPresentPanel();

	}

}
