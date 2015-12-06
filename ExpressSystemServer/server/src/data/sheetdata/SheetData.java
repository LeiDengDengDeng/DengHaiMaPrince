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
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import src.data.logdata.MyObjectOutputStream;
import src.dataservice.sheetdataservice.SheetDataService;
import src.enums.SheetType;
import src.po.SheetPO;

public class SheetData extends UnicastRemoteObject implements SheetDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4597587729127117238L;

	private final static HashMap<SheetType, String> map;

	static {
		// 初始化Map
		map = new HashMap<SheetType, String>();
		map.put(SheetType.CONSTANT, "constant.ser");
		map.put(SheetType.ORDER_SHEET, "orderSheet.ser");
		map.put(SheetType.PAYMENT_SHEET, "paymentSheet.ser");
		map.put(SheetType.STORAGE_IN_SHEET, "storageInSheet.ser");
		map.put(SheetType.STORAGE_OUT_SHEET, "storageOutSheet.ser");
	}

	public SheetData() throws RemoteException {
	}

	public SheetPO find(long id, SheetType type) throws RemoteException {
		// TODO 自动生成的方法存根
		ObjectInputStream os = null;

		try {
			os = new ObjectInputStream(new FileInputStream(new File(map.get(type))));

			for (SheetPO po;;) {
				po = (SheetPO) os.readObject();
				if (po.getID() == id) {
					os.close();
					return po;
				}
			}
		} catch (EOFException e) {
			// TODO 自动生成的 catch 块
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			// TODO 自动生成的 catch 块
		}
		return null;
	}

	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<SheetPO> sheets = new ArrayList<SheetPO>();
		ObjectInputStream os = null;

		try {
			os = new ObjectInputStream(new FileInputStream(new File(map.get(type))));

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
		}catch(FileNotFoundException e){
			System.out.println("找不到文件");
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

		po.setID(1000000000 + this.finds(po.getType()).size());
		System.out.println(po.getID());

		try {
			if (file.length() == 0) {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(po);
				oos.flush();
				oos.close();
			} else {
				moos = new MyObjectOutputStream(new FileOutputStream(file, true));
				moos.writeObject(po);
				moos.flush();
				moos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void update(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		ObjectInputStream os = null;
		ObjectOutputStream oos = null;

		ArrayList<SheetPO> sheets = null;
		try {
			os = new ObjectInputStream(new FileInputStream(map.get(po.getType())));

			// 读出除ID相同的所有PO
			sheets = new ArrayList<SheetPO>();
			for (;;) {
				if (((SheetPO) (os.readObject())).getID() == po.getID()) {
					sheets.add(po);
					continue;
				}
				sheets.add((SheetPO) (os.readObject()));
			}

		} catch (EOFException e) {
			// 到达文件末尾
			try {
				os.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		try {
			oos = new ObjectOutputStream(new FileOutputStream(map.get(po.getType())));
			if (sheets.size() == 0) // ArrayList为空
				for (SheetPO sheet : sheets)
					oos.writeObject(sheet);

			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根

	}

}
