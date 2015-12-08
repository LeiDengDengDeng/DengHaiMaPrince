package src.presentation.commodityui.storageinsheetui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

public class ButtonCancelListener extends CommodityMouseListener {
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldRowNumber;
	TextField textFieldShelfNumber;
	TextField textFieldSeatNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxAreaNumber;
	ButtonCancel buttonCancel;

	public ButtonCancelListener(storageInButton button) {
		super(button);
		buttonCancel = (ButtonCancel) button;
		textFieldName = buttonCancel.textFieldName;
		textFieldNum = buttonCancel.textFieldNum;
		textFieldRowNumber = buttonCancel.textFieldRowNumber;
		textFieldShelfNumber = buttonCancel.textFieldShelfNumber;
		textFieldSeatNumber = buttonCancel.textFieldSeatNumber;
		comboBoxDestination = buttonCancel.comboBoxDestination;
		comboBoxAreaNumber = buttonCancel.comboBoxAreaNumber;
		// TODO Auto-generated constructor stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		panel.remove(textFieldName);
		panel.remove(textFieldNum);
		panel.remove(textFieldRowNumber);
		panel.remove(textFieldShelfNumber);
		panel.remove(textFieldSeatNumber);
		panel.remove(comboBoxDestination);
		panel.remove(comboBoxAreaNumber);
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
