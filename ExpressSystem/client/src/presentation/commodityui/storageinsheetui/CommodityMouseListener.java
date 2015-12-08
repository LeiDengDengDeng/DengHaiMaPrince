package src.presentation.commodityui.storageinsheetui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CommodityMouseListener implements MouseListener {
	storageInButton button;
	StorageInSheetPanel panel;
	public CommodityMouseListener(storageInButton button){
		this.button=button;
		this.panel=button.panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.button.setIcon(button.getImageIconEnter());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.button.setIcon(button.getImageIcon());
	}

}
