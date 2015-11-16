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
		// TODO �Զ����ɵķ������
		try {
			if (sheetData.find(ID) != null) {
				SheetPO sheet = sheetData.find(ID);
//				SheetVO sheetVal = transformPO(sheet);
				return TransformPOAndVO.getVO(sheet);
			} 
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void examineSheet(long ID, boolean passed) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public boolean confirmSheet(SheetVO sheet, SheetType type) {
		// TODO �Զ����ɵķ������
		try {
			sheetData.insert(TransformPOAndVO.getPO(sheet, type));
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return true;
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

}