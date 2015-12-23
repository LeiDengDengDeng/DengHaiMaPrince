package src.presentation.accountui;

import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ButtonAddListener extends AccountMouseListener {
	int i;
	JTextField textFieldName;
	JTextField textFieldNum;
	JTextField textFieldAmount;
	ButtonConfirm buttonConfirm;
	ButtonCancel buttonCancel;
	TextLabel textAdd;

	public ButtonAddListener(AccountButton button) {
		super(button);
		this.panel = button.panel;

		this.initial();
		// TODO Auto-generated constructor stub
	}

	public void initial() {
		i = panel.accounts.size();
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.initial();
		int Name_x = panel.Word_x - 3;
		int Name_y = panel.Word_y + panel.wordToword - ((panel.formHeight - panel.font) >> 1) + panel.formHeight * i
				+ 2;
		int Num_x = panel.Word_x + panel.wordToNum - 3;
		int Amount_x = panel.Word_x + panel.wordToAmount;
		int Confirm_x = panel.Word_x + panel.wordToAmount + panel.amountWidth + panel.del_x;
		int width = 50;
		int height = panel.formHeight - 4;
		int button_x = panel.Word_x + panel.wordToAmount + panel.amountWidth + panel.del_x + button.getIconWidth() + 20
				+ (panel.font + 1) * 2;
		int button_y = panel.Word_y + panel.wordToword + panel.width * (i + 1) + ((panel.formHeight - panel.font) >> 1);
		int text_x = panel.Word_x + panel.wordToAmount + panel.amountWidth + panel.del_x + button.getIconWidth() + 50
				+ (panel.font + 1) * 2;

		int text_y = panel.Word_y + panel.wordToword + panel.width * (i + 1) + ((panel.formHeight - panel.font) >> 1)
				+ ((panel.formHeight - panel.font) >> 2);
		// name
		textFieldName = new JTextField();
		textFieldName.setBounds(Name_x, Name_y, width, height);
		textFieldName.setFont(panel.myFont);
		// num
		textFieldNum = new JTextField();
		textFieldNum.setBounds(Num_x, Name_y, panel.numWidth, height);
		textFieldNum.setFont(panel.myFont);
		Document doc = textFieldNum.getDocument();
		doc.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Document doc = e.getDocument(); 
				if(doc.getLength()%5==0){
//					try {
//						textFieldNum.setText(doc.getText(0, doc.getLength()-1));
//					} catch (BadLocationException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Document doc = e.getDocument();  
//				if(doc.getLength()%5==4){
//					try {
//						textFieldNum.setText(doc.getText(0, doc.getLength())+" ");
//					} catch (BadLocationException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		// amount
		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(Amount_x, Name_y, panel.amountWidth, height);
		textFieldAmount.setFont(panel.myFont);
		// textAdd
		this.textAdd = panel.TextAdd;
		textAdd.setLocation(text_x, text_y);
		// buttonCancel
		buttonCancel = new ButtonCancel(this);
		buttonCancel.setLocation(Confirm_x + panel.del_x, Name_y - (buttonCancel.getIcon().getIconHeight() >> 1) + 2);

		// buttonConfirm
		buttonConfirm = new ButtonConfirm(this);
		buttonConfirm.setLocation(Confirm_x, Name_y - (buttonConfirm.getIcon().getIconHeight() >> 1) + 2);
		button.setLocation(button_x, button_y);

		panel.add(textFieldName);
		panel.add(textFieldNum);
		panel.add(textFieldAmount);
		panel.add(buttonConfirm);
		panel.add(buttonCancel);
		// panel.drawForm(i);
		panel.repaint();
		button.setVisible(false);
		textAdd.setVisible(false);
	}

}
