package src.data.staffmanagedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.po.StaffInfoPO;

public class StaffManageData_Stub implements StaffManageDataService{

	@Override
	public StaffInfoPO find(long StaffId) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find successfully!");
		return new StaffInfoPO(000000, 000000, "aaaa", "Echo", "Manager", null);
	}

	@Override
	public ArrayList<StaffInfoPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find all successfully!");
		ArrayList<StaffInfoPO> staffInfoPOs = new ArrayList<StaffInfoPO>();
		staffInfoPOs.add(new StaffInfoPO(000000, 000000, "aaaa", "Echo", "Manager", null));
		return staffInfoPOs;
	}

	@Override
	public void insert(StaffInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("insert successfully!");
	}

	@Override
	public void update(StaffInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update successfully!");
		
	}

	@Override
	public void delete(StaffInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("delete successfully!");
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish successfully!");
		
	}

}
