package src.data.sheetdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;
import src.dataservice.sheetdataservice.SheetDataService;
import src.po.PaymentSheetPO;
import src.po.SheetPO;

public class SheetData_Stub implements SheetDataService {

	@Override
	public SheetPO find(long id) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功找到Sheet!");
		SheetPO po = new PaymentSheetPO("0", 0, "0", "0", "0", "0");
		return po;
	}

	@Override
	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功找到一组Sheet!");
		ArrayList<SheetPO> sheets = new ArrayList<SheetPO>();
		SheetPO po = new PaymentSheetPO("0", 0, "0", "0", "0", "0");
		sheets.add(po);
		return sheets;
	}

	@Override
	public void insert(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功插入Sheet!");
	}

	@Override
	public void update(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功更新Sheet!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功结束Sheet数据使用!");
	}

}
