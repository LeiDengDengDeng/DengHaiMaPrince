package src.presentation.commodityui.storageoutsheetui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

import src.enums.GoodsType;
import src.presentation.util.TipDialog;

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
		String num = textFieldNum.getText();
		String destinationString = comboBoxDestination.getSelectedItem().toString();
		String transportForm = comboBoxTransportForm.getSelectedItem().toString();
		String transNumber = textFieldTransNumber.getText();
		if(name.equals("")||num.equals("")||transNumber.equals("")){
			new TipDialog(null, "", true, "出库信息未填写完整！", false);
		}
		else if((!isNumeric(num))||(num.length() != 16)){
			new TipDialog(null, "", true, "快递编号格式不正确！", false);
		}
		else if((!isNumeric(transNumber))||(transNumber.length() != 19)){
			new TipDialog(null, "", true, "中转单编号或汽运编号格式不正确！", false);
		}
		else {
			panel.goodsNames.add(name);
			panel.expressNumbers.add(num);
			panel.transNumbers.add(transNumber);
			panel.destinations.add(destinationString);
			if(transportForm.equals("飞机")){
				panel.transportForms.add(GoodsType.EXPRESS);
			}
			else if(transportForm.equals("汽车")){
				panel.transportForms.add(GoodsType.STANDARD);
			}
			else if(transportForm.equals("火车")){
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

	public boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		   System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }
}
