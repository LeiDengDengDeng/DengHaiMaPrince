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
	
	private static SheetData sheetData;

	static {
		// ��ʼ��Map
		map = new HashMap<SheetType, String>();
		map.put(SheetType.CONSTANT, "constant.ser");
		map.put(SheetType.ORDER_SHEET, "orderSheet.ser");
		map.put(SheetType.PAYMENT_SHEET, "paymentSheet.ser");
		map.put(SheetType.STORAGE_IN_SHEET, "storageInSheet.ser");
		map.put(SheetType.STORAGE_OUT_SHEET, "storageOutSheet.ser");
		map.put(SheetType.RECEIVING_MONEY_SHEET, "receivingMoneySheet.ser");
		map.put(SheetType.HALL_TRUCK_SHEET, "hallTruckSheet.ser");
		map.put(SheetType.CENTER_TRUCK_SHEET, "centerTruckSheet.ser");
		map.put(SheetType.HALL_RECEIVING_GOODS_SHEET, "hallReceivingGoodsSheet.ser");
		map.put(SheetType.CENTER_RECEIVING_GOODS_SHEET, "centerReceivingGoodsSheet.ser");
		map.put(SheetType.CENTER_GOODS_OUT_SHEET, "centerGoodsOutSheet.ser");
		map.put(SheetType.HALL_GOODS_OUT_SHEET, "hallGoodsOutSheet.ser");
	}

	private SheetData() throws RemoteException {
	}
	
	public static SheetData getSheetData(){
		if(sheetData == null)
			try {
				return sheetData = new SheetData();
			} catch (RemoteException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		return sheetData;
	}

	public SheetPO find(long id, SheetType type) throws RemoteException {
		// TODO �Զ����ɵķ������
		ObjectInputStream os = null;

		try {
			os = new ObjectInputStream(new FileInputStream(new File(
					map.get(type))));

			for (SheetPO po;;) {
				po = (SheetPO) os.readObject();
				if (po.getID() == id) {
					os.close();
					return po;
				}
			}
		} catch (EOFException e) {
			// TODO �Զ����ɵ� catch ��
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			// TODO �Զ����ɵ� catch ��
		}
		return null;
	}

	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException {
		// TODO �Զ����ɵķ������
		ArrayList<SheetPO> sheets = new ArrayList<SheetPO>();
		ObjectInputStream os = null;

		try {
			os = new ObjectInputStream(new FileInputStream(new File(
					map.get(type))));

			for (;;) {
				SheetPO po = (SheetPO) os.readObject();
				if (po == null)
					break;
				sheets.add(po);
			}
			os.close();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ�");
		} catch (EOFException e) {
			// TODO �Զ����ɵ� catch ��
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return sheets;
	}

	public void insert(SheetPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		ObjectOutputStream oos = null;
		MyObjectOutputStream moos = null;
		File file = new File(map.get(po.getType()));

		if (po.getType() != SheetType.ORDER_SHEET)
			po.setID(1000000000 + this.finds(po.getType()).size());
		System.out.println(po.getID());

		try {
			if (file.length() == 0) {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(po);
				oos.flush();
				oos.close();
			} else {
				moos = new MyObjectOutputStream(
						new FileOutputStream(file, true));
				moos.writeObject(po);
				moos.flush();
				moos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public void update(SheetPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		ObjectInputStream os = null;
		ObjectOutputStream oos = null;

		ArrayList<SheetPO> sheets = null;
		try {
			os = new ObjectInputStream(new FileInputStream(
					map.get(po.getType())));

			// ������ID��ͬ������PO
			sheets = new ArrayList<SheetPO>();
			for (;;) {
				SheetPO temp = (SheetPO) (os.readObject());
				if (temp.getID() == po.getID()) {
					sheets.add(po);
				} else
					sheets.add(temp);
			}

		} catch (EOFException e) {
			// �����ļ�ĩβ
			try {
				os.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		try {
			oos = new ObjectOutputStream(new FileOutputStream(map.get(po
					.getType())));
			if (sheets.size() != 0) // ArrayListΪ��
				for (SheetPO sheet : sheets)
					oos.writeObject(sheet);

			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������

	}

	public static void main(String[] args) throws RemoteException {
		SheetData sheet = new SheetData();
		ArrayList<SheetPO> pos = sheet.finds(SheetType.CONSTANT);
//		ConstantPO po = new ConstantPO("xx", "2015-11-11", 33, 2, "����", "����", 0);
//		sheet.insert(po);

	}
}
