package src.presentation.commodityui.storageinsheetui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import src.presentation.accountui.TextLabel;

public class ButtonAddListener extends CommodityMouseListener {
	int i;
	TextField textFieldName;
	TextField textFieldNum;
	TextField textFieldRowNumber;
	TextField textFieldShelfNumber;
	TextField textFieldSeatNumber;
	JComboBox comboBoxDestination;
	JComboBox comboBoxAreaNumber;
	ButtonConfirm buttonConfirm;
	ButtonCancel buttonCancel;
	TextLabel textAdd;

	public ButtonAddListener(storageInButton button) {
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
		int Area_x = panel.Word_x + panel.wordToArea;
		int Row_x = panel.Word_x + panel.wordToRow;
		int Shelf_x = panel.Word_x + panel.wordToShelf;
		int Seat_x = panel.Word_x + panel.wordToSeat;
		int Confirm_x = panel.Word_x + panel.wordToSeat + panel.SeatWidth + panel.del_x;
		int width = 50;
		int height = panel.formHeight - 4;
		int button_x = panel.Word_x + panel.wordToSeat + panel.SeatWidth + panel.del_x + button.getIconWidth() + 20
				+ (panel.font + 1) * 2;
		int button_y = panel.Word_y + panel.wordToword + panel.width * (i + 1) + ((panel.formHeight - panel.font) >> 1);
		int text_x = panel.Word_x + panel.wordToSeat + panel.SeatWidth + panel.del_x + button.getIconWidth() + 50
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
		//Area
		String[] area = {"航运区","汽运区","铁运区","机动区"};
		comboBoxAreaNumber = new JComboBox(area);
		comboBoxAreaNumber.setBounds(Area_x, Name_y, panel.AreaWidth, height);
		comboBoxAreaNumber.setFont(panel.myFont);
		panel.AreaNumberList.add(comboBoxAreaNumber);
		//Row
		textFieldRowNumber = new TextField();
		textFieldRowNumber.setBounds(Row_x, Name_y, panel.RowWidth, height);
		textFieldRowNumber.setFont(panel.myFont);
		//Shelf
		textFieldShelfNumber = new TextField();
		textFieldShelfNumber.setBounds(Shelf_x, Name_y, panel.ShelfWidth, height);
		textFieldShelfNumber.setFont(panel.myFont);
		//Seat
		textFieldSeatNumber = new TextField();
		textFieldSeatNumber.setBounds(Seat_x, Name_y, panel.SeatWidth, height);
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
		panel.add(comboBoxAreaNumber);
		panel.add(textFieldRowNumber);
		panel.add(textFieldShelfNumber);
		panel.add(textFieldSeatNumber);
		panel.add(buttonConfirm);
		panel.add(buttonCancel);
//		panel.drawForm(i);
		panel.repaint();
		button.setVisible(false);
		textAdd.setVisible(false);
	}

}
