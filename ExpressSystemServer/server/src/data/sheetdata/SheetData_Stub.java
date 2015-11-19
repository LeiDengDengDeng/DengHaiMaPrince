package src.data.sheetdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.sheetdataservice.SheetDataService;
import src.enums.SheetType;
import src.po.PaymentSheetPO;
import src.po.SheetPO;

public class SheetData_Stub implements SheetDataService {

	public SheetPO find(long id, SheetType type) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ��ҵ�Sheet!");
		SheetPO po = new PaymentSheetPO("0", 0, "0", "0", "0", "0",1000000001);
		return po;
	}

	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ��ҵ�һ��Sheet!");
		ArrayList<SheetPO> sheets = new ArrayList<SheetPO>();
		SheetPO po = new PaymentSheetPO("0", 0, "0", "0", "0", "0",1000000001);
		sheets.add(po);
		return sheets;
	}

	public void insert(SheetPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ�����Sheet!");
	}

	public void update(SheetPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ�����Sheet!");
	}

	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ�����Sheet����ʹ��!");
	}

}
