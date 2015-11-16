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
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void examineSheet(long ID, boolean passed) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public SheetVO fillSheet(SheetType type, long ID) {
		// TODO �Զ����ɵķ������
		try {
			if (sheetData.find(ID) != null) {
				SheetPO sheet = sheetData.find(ID);
				SheetVO sheetVal = transformPO(sheet);
				return sheetVal;
			} else
				return null;

		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isLegal(SheetInfoType type, Object info) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean confirmSheet(SheetVO sheet, SheetType type, boolean confirmed) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void formulateConstant(ArrayList<Double> distant, double price) {
		// TODO �Զ����ɵķ������

		ConstantPO constant = new ConstantPO(distant, price);
		try {
			sheetData.insert(constant);
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public SheetVO transformPO(SheetPO sheet){
		return null;
	}

}
