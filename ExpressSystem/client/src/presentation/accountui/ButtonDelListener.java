package src.presentation.accountui;

import java.awt.event.MouseEvent;

import src.presentation.mainui.PanelController;

public class ButtonDelListener extends AccountMouseListener {

	public ButtonDelListener(AccountButton button) {
		super(button);
		// TODO Auto-generated constructor stub
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.panel.accountBL.delAccount(button.vo.getID());
		PanelController.refreshPresentPanel();
		
	}

}
