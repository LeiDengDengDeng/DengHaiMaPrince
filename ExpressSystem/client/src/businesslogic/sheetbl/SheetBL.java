package src.businesslogic.sheetbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.SheetBLService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.po.ConstantPO;
import src.po.SheetPO;
import src.vo.SheetVO;

public class SheetBL implements SheetBLService {

	SheetDataService sheetData;

	public SheetBL(SheetDataService sheetData) {
		this.sheetData = sheetData;
	}

	@Override
	public SheetVO checkSheet(long ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void examineSheet(long ID, boolean passed) {
		// TODO 自动生成的方法存根

	}

	@Override
	public SheetVO fillSheet(SheetType type, long ID) {
		// TODO 自动生成的方法存根
		try {
			if (sheetData.find(ID) != null) {
				SheetPO sheet = sheetData.find(ID);
				SheetVO sheetVal = transformPO(sheet);
				return sheetVal;
			} else
				return null;

		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isLegal(SheetInfoType type, Object info) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean confirmSheet(SheetVO sheet, SheetType type, boolean confirmed) {
		// TODO 自动生成的方法存根
		return false;
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
	
	public SheetVO transformPO(SheetPO sheet){
		return null;
	}

}
