package src.presentation.commodityui.storageinsheetui;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import src.vo.StorageInSheetVO;

public abstract class storageInButton extends JButton {
//	private static ImageIcon image=null ;
//	protected StorageInSheetVO vo;
	StorageInSheetPanel panel;
	public storageInButton(StorageInSheetPanel panel) {
		this.panel=panel;
		this.addListener(panel);
	}
	public storageInButton() {
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
	abstract void addListener(StorageInSheetPanel panel);
}
