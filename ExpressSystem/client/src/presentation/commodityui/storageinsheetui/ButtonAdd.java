package src.presentation.commodityui.storageinsheetui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import src.vo.AccountVO;
import src.vo.StorageInSheetVO;

public class ButtonAdd extends storageInButton {
	private static ImageIcon image = new ImageIcon("images/account_add.png");
	private static ImageIcon imageEnter = new ImageIcon("images/account_addEnter.png");
//	public ButtonAdd(StorageInSheetVO vo,StorageInSheetPanel panel) {
//		super(vo,panel);
//		this.draw(image);
//		// TODO Auto-generated constructor stub
//	}
	public ButtonAdd(StorageInSheetPanel panel){
		super();
		this.draw(image);
		this.panel=panel;
		this.addListener(panel);
		

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
		ButtonAddListener listener=new ButtonAddListener(this);
		this.addMouseListener(listener);
	}
}
