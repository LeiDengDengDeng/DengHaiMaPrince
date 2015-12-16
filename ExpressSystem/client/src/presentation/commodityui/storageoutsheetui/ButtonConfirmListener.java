package src.presentation.commodityui.storageoutsheetui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

import src.enums.GoodsType;

public class ButtonConfirmListener extends CommodityMouseListener {
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldTransNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxTransportForm;
	ButtonConfirm buttonConfirm;
	public ButtonConfirmListener(storageOutButton button) {
		super(button);
		buttonConfirm = (ButtonConfirm) button;
		textFieldName = buttonConfirm.textFieldName;
		textFieldNum = buttonConfirm.textFieldNum;
		comboBoxDestination = buttonConfirm.comboBoxDestination;
		comboBoxTransportForm = buttonConfirm.comboBoxTransportForm;
		textFieldTransNumber = buttonConfirm.textFieldTransNumber;
		// TODO Auto-generated constructor stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String name = textFieldName.getText();
		long num = Long.parseLong(textFieldNum.getText());
		String destinationString = comboBoxDestination.getSelectedItem().toString();
		String transportForm = comboBoxTransportForm.getSelectedItem().toString();
		long transNumber = Long.parseLong(textFieldTransNumber.getText());
		panel.goodsNames.add(name);
		panel.expressNumbers.add(num);
		panel.transNumbers.add(transNumber);
		panel.destinations.add(destinationString);
		if(transportForm.equals("·É»ú")){
			panel.transportForms.add(GoodsType.EXPRESS);
		}
		else if(transportForm.equals("Æû³µ")){
			panel.transportForms.add(GoodsType.STANDARD);
		}
		else if(transportForm.equals("»ð³µ")){
			panel.transportForms.add(GoodsType.ECONOMIC);
		}
		
		
//		panel.accountBL.addAccount(name,num,amount);
		panel.remove(textFieldName);
		panel.remove(textFieldNum);
		panel.remove(textFieldTransNumber);
//		panel.remove(comboBoxDestination);
//		panel.remove(comboBoxAreaNumber);
		panel.remove(buttonConfirm);
		panel.remove(buttonConfirm.listener.buttonCancel);
		if(panel.formList.size()-1 >= 0){
			panel.remove(panel.formList.get(panel.formList.size()-1));
		}
		panel.remove(buttonConfirm.buttonAdd);
		panel.remove(buttonConfirm.textAdd);
		panel.drawCommodity();
		panel.repaint();

	}

}
