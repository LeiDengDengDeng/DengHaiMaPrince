package src.presentation.accountui;

import java.awt.event.MouseEvent;

public class ButtonDelListener extends AccountMouseListener {

	public ButtonDelListener(AccountButton button) {
		super(button);
		// TODO Auto-generated constructor stub
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.panel.accountBL.delAccount(button.vo.getID());
		for (int i = 0; i < panel.amountList.size(); i++) {
			panel.remove(panel.nameList.get(i));
			panel.remove(panel.numList.get(i));
			panel.remove(panel.amountList.get(i));
			panel.remove(panel.formList.get(i));
			panel.remove(panel.buttonDelList.get(i));
			panel.remove(panel.TextDelList.get(i));
			
		}
		panel.remove(panel.buttonAdd);
		panel.remove(panel.TextAdd);
		this.panel.drawAccount();
		this.panel.repaint();
		
	}

}
