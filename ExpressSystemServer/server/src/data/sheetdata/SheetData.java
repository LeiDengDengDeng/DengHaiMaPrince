package src.data.sheetdata;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import src.data.logdata.MyObjectOutputStream;
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
		// TODO 自动生成的方法存根
		ObjectInputStream os = null;

		try {
			os = new ObjectInputStream(new FileInputStream(map.get(type)));

			for (SheetPO po = null; po != null;) {
				po = (SheetPO) os.readObject();
				if (po.getID() == id) {
					os.close();
					return po;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO 自动生成的 catch 块
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<SheetPO> sheets = new ArrayList<SheetPO>();
		ObjectInputStream os = null;

		try {
			os = new ObjectInputStream(new FileInputStream(map.get(type)));

			for (;;) {
				SheetPO po = (SheetPO) os.readObject();
				if (po == null)
					break;
				sheets.add(po);
			}
			os.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO 自动生成的 catch 块
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return sheets;
	}

	public void insert(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		ObjectOutputStream oos = null;
		MyObjectOutputStream moos = null;
		File file = new File(map.get(po.getType()));

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			moos = new MyObjectOutputStream(new FileOutputStream(file, true));
			if (file.length() == 0) {
				oos.writeObject(po);
				oos.flush();
				oos.close();
			} else {
				moos.writeObject(po);
				moos.flush();
				moos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			System.out.println("LogFile not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void update(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根

	}

	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根

	}

}
