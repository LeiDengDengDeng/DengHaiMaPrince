package src.presentation.commodityui.storageoutsheetui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import src.presentation.accountui.TextLabel;

public class ButtonAddListener extends CommodityMouseListener {
	int i;
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldTransNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxTransportForm;
	ButtonConfirm buttonConfirm;
	ButtonCancel buttonCancel;
	TextLabel textAdd;

	public ButtonAddListener(storageOutButton button) {
		super(button);
		this.panel = button.panel;

		this.initial();
		// TODO Auto-generated constructor stub
	}

	public void initial() {
		i = panel.goodsNames.size();
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.initial();
		int Name_x = panel.Word_x - 25;
		int Name_y = panel.Word_y + panel.wordToword - ((panel.formHeight - panel.font) >> 1) + panel.formHeight * i
				+ 2;
		int Num_x = panel.Word_x + panel.wordToNum - 40;
		int Destination_x = panel.Word_x + panel.wordToDestination;
		int TransportForm_x = panel.Word_x + panel.wordToTransportForm;
		int TransNumber_x = panel.Word_x + panel.wordToTransNumber;
		int Confirm_x = panel.Word_x + panel.wordToTransNumber + panel.TransNumberWidth + panel.del_x;
		int width = 50;
		int height = panel.formHeight - 4;
		int button_x = panel.Word_x + panel.wordToTransNumber + panel.TransNumberWidth + panel.del_x + button.getIconWidth() + 20
				+ (panel.font + 1) * 2;
		int button_y = panel.Word_y + panel.wordToword + panel.width * (i + 1) + ((panel.formHeight - panel.font) >> 1);
		int text_x = panel.Word_x + panel.wordToTransNumber + panel.TransNumberWidth + panel.del_x + button.getIconWidth() + 50
				+ (panel.font + 1) * 2;

		int text_y = panel.Word_y + panel.wordToword + panel.width * (i + 1) + ((panel.formHeight - panel.font) >> 1)
				+ ((panel.formHeight - panel.font) >> 2);
		// name
		textFieldName = new TextField();
		textFieldName.setBounds(Name_x, Name_y, width, height);
		textFieldName.setFont(panel.myFont);
		// num
		textFieldNum = new TextField();
		textFieldNum.setBounds(Num_x, Name_y, panel.numWidth, height);
		textFieldNum.setFont(panel.myFont);
		//destination
		String[] destination = {"南京","上海","广州","北京"};
		comboBoxDestination = new JComboBox(destination);
		comboBoxDestination.setBounds(Destination_x, Name_y, panel.destinationWidth, height);
		comboBoxDestination.setFont(panel.myFont);
		panel.destinationList.add(comboBoxDestination);
		//transportForm
		String[] TransportForm = {"飞机","火车","汽车"};
		comboBoxTransportForm = new JComboBox(TransportForm);
		comboBoxTransportForm.setBounds(TransportForm_x, Name_y, panel.TransportFormWidth, height);
		comboBoxTransportForm.setFont(panel.myFont);
		panel.transportFormList.add(comboBoxTransportForm);
		//transNumber
		textFieldTransNumber = new TextField();
		textFieldTransNumber.setBounds(TransNumber_x, Name_y, panel.TransNumberWidth, height);
		//textAdd
		this.textAdd = panel.TextAdd;
		textAdd.setLocation(text_x, text_y);
		// buttonCancel
		buttonCancel = new ButtonCancel(this);
		buttonCancel.setLocation(Confirm_x + panel.del_x + 10,
				Name_y - (buttonCancel.getIcon().getIconHeight() >> 1) + 2);

		// buttonConfirm
		buttonConfirm = new ButtonConfirm(this);
		buttonConfirm.setLocation(Confirm_x, Name_y - (buttonConfirm.getIcon().getIconHeight() >> 1) + 2);
		button.setLocation(button_x, button_y);

		panel.add(textFieldName);
		panel.add(textFieldNum);
		panel.add(comboBoxDestination);
		panel.add(comboBoxTransportForm);
		panel.add(textFieldTransNumber);
		panel.add(buttonConfirm);
		panel.add(buttonCancel);
//		panel.drawForm(i);
		panel.repaint();
		button.setVisible(false);
		textAdd.setVisible(false);
	}

}
