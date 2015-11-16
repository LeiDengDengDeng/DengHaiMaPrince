package src.businesslogic.sheetbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.SheetBLService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.po.ConstantPO;
import src.po.SheetPO;
import src.vo.SheetVO;

public class Sheet implements SheetBLService {

	SheetDataService sheetData;

	public Sheet(SheetDataService sheetData) {
		this.sheetData = sheetData;
	}

	@Override
	public SheetVO checkSheet(long ID) {
		// TODO 自动生成的方法存根
		try {
			if (sheetData.find(ID) != null) {
				SheetPO sheet = sheetData.find(ID);
//				SheetVO sheetVal = transformPO(sheet);
				return TransformPOAndVO.getVO(sheet);
			} 
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void examineSheet(long ID, boolean passed) {
		// TODO 自动生成的方法存根

	}

	@Override
	public boolean confirmSheet(SheetVO sheet, SheetType type) {
		// TODO 自动生成的方法存根
		try {
			sheetData.insert(TransformPOAndVO.getPO(sheet, type));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void formulateConstant(ArrayList<Double> distant, double price) {
		// TODO 自动生成的方法存根
		ConstantPO constant = new ConstantPO(distant, price);
		try {
			sheetData.insert(constant);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}