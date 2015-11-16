package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.SheetBLService;

public class SheetBLService_Driver {
	
	public void drive(SheetBLService sheetBLService){
		sheetBLService.checkSheet(00001);
		sheetBLService.examineSheet(00001,true);
//		sheetBLService.fillSheet(SheetType.ORDER_SHEET, 00001);
//		sheetBLService.fillSheet(SheetType.ORDER_SHEET, 00002);
//		sheetBLService.isLegal(SheetInfoType.COURIER_NUMBER, "0000000001");
//		sheetBLService.isLegal(SheetInfoType.COURIER_NUMBER, "1");
		sheetBLService.confirmSheet(null, SheetType.ORDER_SHEET);
		ArrayList<Double> distant = new ArrayList<Double>();
		distant.add(10.0);
		sheetBLService.formulateConstant(distant, 10);
	}

}
