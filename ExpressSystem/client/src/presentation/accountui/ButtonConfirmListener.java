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
				//�ɹ�����
				new TipDialog(null, "", true, "�����˻��ɹ�", true);
				PanelController.refreshPresentPanel();
				
				
			}
			else{
				new TipDialog(null, "", true, "�����˻�ʧ�ܣ�������", false);
				//ʧ�ܵ���
			}
		}
		else{
			//��Ϣ���󵯴�
			new TipDialog(null, "", true, "��Ϣ��д����", false);
		}

	}

}
