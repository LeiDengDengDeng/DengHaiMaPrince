package src.data.sheetdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;
import src.dataservice.sheetdataservice.SheetDataService;
import src.po.SheetPO;

public class SheetData implements SheetDataService{

	@Override
	public SheetPO find(long id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void insert(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void update(SheetPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

}
