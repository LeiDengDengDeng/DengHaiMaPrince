package src.data.sheetdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.sheetdataservice.SheetDataService;
import src.enums.SheetType;
import src.po.PaymentSheetPO;
import src.po.SheetPO;

public class SheetData_Stub implements SheetDataService {

	public SheetPO find(long id, SheetType type) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功找到Sheet!");
		SheetPO po = new PaymentSheetPO("0", 0, "0", "0", "0", "0",1000000001);
		return po;
	}

	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功找到一组Sheet!");
		ArrayList<SheetPO> sheets = new ArrayList<SheetPO>();
		SheetPO po = new PaymentSheetPO("0", 0, "0", "0", "0", "0",1000000001);
		sheets.add(po);
		return sheets;
	}

	public void insert(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功插入Sheet!");
	}

	public void update(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功更新Sheet!");
	}

	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功结束Sheet数据使用!");
	}

}
