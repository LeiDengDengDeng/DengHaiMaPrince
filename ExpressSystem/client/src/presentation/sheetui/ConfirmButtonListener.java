package src.presentation.sheetui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmButtonListener implements ActionListener{ 
	SheetPanel panel;
	
	public ConfirmButtonListener(SheetPanel panel) {
		// TODO Auto-generated constructor stub
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		panel.confirm();
	}

}
