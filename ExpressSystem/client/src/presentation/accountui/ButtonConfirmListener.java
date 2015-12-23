package src.presentation.accountui;

import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import src.businesslogic.util.CommonUtil;
import src.presentation.mainui.PanelController;
import src.presentation.util.TipDialog;

public class ButtonConfirmListener extends AccountMouseListener {
	JTextField textFieldName;
	JTextField textFieldNum;
	JTextField textFieldAmount;
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
		String num = textFieldNum.getText().trim();
		if ((name.length() != 0) && (CommonUtil.isValidNumberString(num, 19))
				&& (textFieldAmount.getText().length() != 0)) {
			
			double amount=Double.parseDouble(textFieldAmount.getText());
			
			if(panel.accountBL.addAccount(name, num, amount)){
				//成功弹窗
				new TipDialog(null, "", true, "增加账户成功", true);
				PanelController.refreshPresentPanel();
				
				
			}
			else{
				new TipDialog(null, "", true, "增加账户失败，请重试", false);
				//失败弹窗
			}
		}
		else{
			//信息错误弹窗
			new TipDialog(null, "", true, "信息填写出错", false);
		}

	}

}
