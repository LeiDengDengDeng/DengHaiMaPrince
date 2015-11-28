package src.presentation.accountui;

import java.awt.TextField;
import java.awt.event.MouseEvent;

public class ButtonAddListener extends AccountMouseListener {

	public ButtonAddListener(AccountButton button, AccountPanel panel) {
		super(button, panel);
		// TODO Auto-generated constructor stub
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int i = panel.accounts.size();
		int Name_x = panel.Word_x -3;
		int Name_y = panel.Word_y + panel.wordToword - ((panel.formHeight - panel.font) >> 1) + panel.formHeight * i+2;
		int Num_x=panel.Word_x + panel.wordToNum-3;
		int Amount_x=panel.Word_x + panel.wordToAmount;
		int Confirm_x=panel.Word_x + panel.wordToAmount+20;
		int width = 50;
		int height = panel.formHeight-4;
		int button_x = button.getLocation().x;
		int button_y = button.getLocation().y + panel.width;
		int text_x=panel.TextAdd.getLocation().x;
		int text_y = panel.TextAdd.getLocation().y + panel.width;
		//name
		TextField textFieldName = new TextField();
		textFieldName.setBounds(Name_x, Name_y, width, height);
		textFieldName.setFont(panel.myFont);
		//num
		TextField textFieldNum = new TextField();
		textFieldNum.setBounds(Num_x, Name_y, panel.numWidth, height);
		textFieldNum.setFont(panel.myFont);
		//amount
		TextField textFieldAmount = new TextField();
		textFieldAmount.setBounds(Amount_x, Name_y, panel.amountWidth, height);
		textFieldAmount.setFont(panel.myFont);
		//button
		ButtonConfirm buttonConfirm=new ButtonConfirm(panel);
		buttonConfirm.setLocation(Confirm_x, Name_y);
		
		button.setLocation(button_x, button_y);
		panel.TextAdd.setLocation(text_x,text_y);
		panel.add(textFieldName);
		panel.add(textFieldNum);
		panel.add(textFieldAmount);
		panel.drawForm(i,panel.isfirst);
		panel.repaint();

	}

}
