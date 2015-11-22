package src.businesslogic.presheetbl;

import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;
import src.businesslogicservice.presheetblservice.PreSheetBLService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.vo.ConstantVO;
import src.vo.SheetVO;

public class PreSheet implements PreSheetBLService {

	SheetDataService sheetData;

	public PreSheet(SheetDataService sheetData) {
		this.sheetData = sheetData;
	}

	@Override
	public SheetVO checkSheet(long ID) {
		// TODO 自动生成的方法存根
//		try {
//			if (sheetData.find(ID) != null) {
//				SheetPO sheet = sheetData.find(ID);
//				// SheetVO sheetVal = transformPO(sheet);
//				return TransformPOAndVO.getVO(sheet);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		return null;
	}

	@Override
	public void examineSheet(long ID, boolean passed) {
		// TODO 自动生成的方法存根

	}

	@Override
	public boolean confirmSheet(SheetVO sheet, SheetType type) {
		// TODO 自动生成的方法存根
//		try {
//			sheetData.insert(TransformPOAndVO.getPO(sheet, type));
//		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		return true;
	}

	@Override
	public void formulateConstant(ArrayList<ConstantVO> constant) {
		// TODO 自动生成的方法存根
//		ConstantPO constant = new ConstantPO(distant, price, city);
//		try {
//			sheetData.insert(constant);
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
	}

}