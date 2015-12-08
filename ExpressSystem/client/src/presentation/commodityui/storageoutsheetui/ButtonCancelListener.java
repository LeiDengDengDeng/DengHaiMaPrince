package src.presentation.commodityui.storageoutsheetui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

public class ButtonCancelListener extends CommodityMouseListener {
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldTransNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxTransportForm;
	ButtonCancel buttonCancel;

	public ButtonCancelListener(storageOutButton button) {
		super(button);
		buttonCancel = (ButtonCancel) button;
		textFieldName = buttonCancel.textFieldName;
		textFieldNum = buttonCancel.textFieldNum;
		comboBoxDestination = buttonCancel.comboBoxDestination;
		comboBoxTransportForm = buttonCancel.comboBoxTransportForm;
		textFieldTransNumber = buttonCancel.textFieldTransNumber;
		// TODO Auto-generated constructor stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		panel.remove(textFieldName);
		panel.remove(textFieldNum);
		panel.remove(comboBoxDestination);
		panel.remove(textFieldTransNumber);
		panel.remove(comboBoxTransportForm);
		panel.remove(button);
		if(panel.formList.size()-1 >= 0){
			panel.remove(panel.formList.get(panel.formList.size()-1));
		}
		panel.remove(buttonCancel.textAdd);
		panel.remove(buttonCancel.listener.buttonConfirm);
		panel.remove(buttonCancel.buttonAdd);
		panel.drawCommodity();
		panel.repaint();

	}

}
