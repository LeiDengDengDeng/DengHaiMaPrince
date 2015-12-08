package src.presentation.commodityui.storageinsheetui;

import javax.swing.ImageIcon;

import src.vo.AccountVO;
import src.vo.StorageInSheetVO;

public class ButtonDel extends storageInButton {
	private ImageIcon image = new ImageIcon("images/account_del.png");
	private ImageIcon imageEnter = new ImageIcon("images/account_delEnter.png");
	public ButtonDel(StorageInSheetPanel panel) {
		super(panel);
		this.draw(image);
		// TODO Auto-generated constructor stub
	}
	@Override
	ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return image;
	}
	@Override
	ImageIcon getImageIconEnter() {
		// TODO Auto-generated method stub
		return imageEnter;
	}
	@Override
	void addListener(StorageInSheetPanel panel) {
		// TODO Auto-generated method stub
		ButtonDelListener listener=new ButtonDelListener(this);
		this.addMouseListener(listener);
	}
}
