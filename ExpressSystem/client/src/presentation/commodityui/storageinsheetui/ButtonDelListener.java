package src.presentation.commodityui.storageinsheetui;

import java.awt.event.MouseEvent;

public class ButtonDelListener extends CommodityMouseListener {

	public ButtonDelListener(storageInButton button) {
		super(button);
		// TODO Auto-generated constructor stub
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		this.panel.commodityBL.delAccount(button.vo.getID());
		for (int i = 0; i < panel.nameList.size(); i++) {
			System.out.println("666 " + panel.nameList.size());
			System.out.println("6666 " + panel.goodsNames.size());
			panel.remove(panel.nameList.get(i));
			panel.remove(panel.numList.get(i));
			panel.remove(panel.rowNumberList.get(i));
			panel.remove(panel.shelfNumberList.get(i));
			panel.remove(panel.seatNumberList.get(i));
			panel.remove(panel.destinationList.get(i));
			panel.remove(panel.AreaNumberList.get(i));
			panel.remove(panel.formList.get(i));
			panel.remove(panel.buttonDelList.get(i));
			panel.remove(panel.TextDelList.get(i));
			
		}
		panel.remove(panel.buttonAdd);
		panel.remove(panel.TextAdd);
		this.panel.drawCommodity();
		this.panel.repaint();
		
	}

}
