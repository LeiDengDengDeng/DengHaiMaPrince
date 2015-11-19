package src.data.sheetdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import src.dataservice.sheetdataservice.SheetDataService;
import src.enums.SheetType;
import src.po.SheetPO;

public class SheetData implements SheetDataService {
	private final static HashMap<SheetType, String> map;

	static {
		map = new HashMap<SheetType, String>();
		map.put(SheetType.CONSTANT, "constant.ser");
		map.put(SheetType.ORDER_SHEET, "orderSheet.ser");
		map.put(SheetType.PAYMENT_SHEET, "paymentSheet.ser");
		map.put(SheetType.STORAGE_IN_SHEET, "storageInSheet.ser");
		map.put(SheetType.STORAGE_OUT_SHEET, "storageOutSheet.ser");
	}

	public SheetPO find(long id, SheetType type) throws RemoteException {
		// TODO �Զ����ɵķ������

		ObjectInputStream os = null;

		try {
			os = new ObjectInputStream(new FileInputStream(map.get(type)));

			for (;;) {
				SheetPO sheet = (SheetPO) os.readObject();
			}
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	public void insert(SheetPO po) throws RemoteException {
		// TODO �Զ����ɵķ������

	}

	public void update(SheetPO po) throws RemoteException {
		// TODO �Զ����ɵķ������

	}

	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������

	}

}
