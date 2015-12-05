package src.businesslogic.presheetbl;

import java.util.ArrayList;

import src.enums.SheetType;
import src.businesslogicservice.presheetblservice.PreSheetBLService;
import src.vo.ConstantVO;

public class SheetBLService_Driver {
	
	public void drive(PreSheetBLService sheetBLService){
		sheetBLService.checkSheet(00001);
		sheetBLService.examineSheet(00001,true);
//		sheetBLService.fillSheet(SheetType.ORDER_SHEET, 00001);
//		sheetBLService.fillSheet(SheetType.ORDER_SHEET, 00002);
//		sheetBLService.isLegal(SheetInfoType.COURIER_NUMBER, "0000000001");
//		sheetBLService.isLegal(SheetInfoType.COURIER_NUMBER, "1");
		sheetBLService.confirmSheet(null, SheetType.ORDER_SHEET);
		ConstantVO constant = new ConstantVO(10	,10, "ÄÏ¾©-³¤É³");
		ArrayList<ConstantVO> list = new ArrayList<ConstantVO>();
		list.add(constant);
		sheetBLService.formulateConstant(list);
	}

}
