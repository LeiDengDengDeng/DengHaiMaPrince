package src.businesslogic.sheetbl;

import src.po.OrderSheetPO;
import src.po.SheetPO;
import src.vo.OrderSheetVO;
import src.vo.SheetVO;

public class TransformPOAndVO {

	public static SheetVO getVO(SheetPO sheet) {
		SheetVO sheetVal = null;
		switch (sheet.getType()) {
		case ORDER_SHEET:
			sheetVal = new OrderSheetVO(
					((OrderSheetPO) sheet).getCourierNumber(),
					((OrderSheetPO) sheet).getSenderName(),
					((OrderSheetPO) sheet).getSenderAddress(),
					((OrderSheetPO) sheet).getSenderOrganization());
			break;
		default:
			break;
		}
		return sheetVal;
	}

	public static SheetPO getPO(SheetVO sheet, SheetType type) {
		return null;
	}

}
