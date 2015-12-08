package src.presentation.commodityui.storageoutsheetui;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import src.vo.StorageInSheetVO;

public abstract class storageOutButton extends JButton {
//	private static ImageIcon image=null ;
//	protected StorageInSheetVO vo;
	StorageOutSheetPanel panel;
	public storageOutButton(StorageOutSheetPanel panel) {
		this.panel=panel;
		this.addListener(panel);
	}
	public storageOutButton() {
	}
	abstract ImageIcon getImageIcon();
	abstract ImageIcon getImageIconEnter();
	
	void draw(ImageIcon image) {
		this.setIcon(getImageIcon());
		this.setSize(getImageIcon().getIconWidth(), getImageIcon().getIconWidth());
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);

	}
	int getIconWidth(){
		return getImageIcon().getIconWidth();
	}
	abstract void addListener(StorageOutSheetPanel panel);
}
