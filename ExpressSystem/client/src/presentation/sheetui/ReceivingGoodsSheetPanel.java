package src.presentation.sheetui;

import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import src.businesslogicservice.sheetblservice.SheetBLService;

public class ReceivingGoodsSheetPanel extends SheetPanel{
	JPanel sheet;
	ArrayList<TextField> courierNumber;
	ArrayList<JComboBox> depature;
	ArrayList<JComboBox> destination;
	ArrayList<JComboBox> start;

	public ReceivingGoodsSheetPanel(SheetBLService receivingGoodsBL){
		init();
	}
	
	private void init(){
		
	}
	
	
	public void addRows() {
		for (int i = 0; i < 12; i++) {

		}
	}

	@Override
	public boolean confirm() {
		// TODO 自动生成的方法存根
		return false;
	}

}
