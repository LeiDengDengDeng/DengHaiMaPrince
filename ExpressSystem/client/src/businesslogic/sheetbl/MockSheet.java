package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.dataservice.sheetdataservice.SheetDataService;

public class MockSheet extends Sheet{

	public MockSheet(SheetDataService sheetData) {
		super(sheetData);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public void formulateConstant(ArrayList<Double> distant, double price) {
		System.out.println("����������");
	}

}
