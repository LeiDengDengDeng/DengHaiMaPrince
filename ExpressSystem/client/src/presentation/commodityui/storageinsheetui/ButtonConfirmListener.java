package src.presentation.commodityui.storageinsheetui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

import src.enums.GoodsType;

public class ButtonConfirmListener extends CommodityMouseListener {
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldRowNumber;
	TextField textFieldShelfNumber;
	TextField textFieldSeatNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxAreaNumber;
	ButtonConfirm buttonConfirm;
	public ButtonConfirmListener(storageInButton button) {
		super(button);
		buttonConfirm = (ButtonConfirm) button;
		textFieldName = buttonConfirm.textFieldName;
		textFieldNum = buttonConfirm.textFieldNum;
		textFieldRowNumber = buttonConfirm.textFieldRowNumber;
		textFieldShelfNumber = buttonConfirm.textFieldShelfNumber;
		textFieldSeatNumber = buttonConfirm.textFieldSeatNumber;
		comboBoxDestination = buttonConfirm.comboBoxDestination;
		comboBoxAreaNumber = buttonConfirm.comboBoxAreaNumber;
		// TODO Auto-generated constructor stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String name = textFieldName.getText();
		String num=textFieldNum.getText();
		int rowNumber = Integer.parseInt(textFieldRowNumber.getText());
		int shelfNumber = Integer.parseInt(textFieldShelfNumber.getText());
		int seatNumber = Integer.parseInt(textFieldSeatNumber.getText());
		String destinationString = comboBoxDestination.getSelectedItem().toString();
		String area = comboBoxAreaNumber.getSelectedItem().toString();
		panel.goodsNames.add(name);
		panel.expressNumbers.add(num);
		panel.rowNumbers.add(rowNumber);
		panel.shelfNumbers.add(shelfNumber);
		panel.seatNumbers.add(seatNumber);
		panel.destinations.add(destinationString);
		if(area.equals("汽运区")){
			panel.areaNumbers.add(GoodsType.TRANSPORT);
		}
		else if(area.equals("航运区")){
			panel.areaNumbers.add(GoodsType.SHIPPING);
		}
		else if(area.equals("铁运区")){
			panel.areaNumbers.add(GoodsType.RAIL);
		}
		else if(area.equals("机动区")){
			panel.areaNumbers.add(GoodsType.FLXIBLE);
		}
//		panel.accountBL.addAccount(name,num,amount);
		panel.remove(textFieldName);
		panel.remove(textFieldNum);
		panel.remove(textFieldRowNumber);
		panel.remove(textFieldShelfNumber);
		panel.remove(textFieldSeatNumber);
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
