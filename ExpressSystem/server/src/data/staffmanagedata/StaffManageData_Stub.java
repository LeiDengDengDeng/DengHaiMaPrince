package src.data.staffmanagedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.po.UserPO;

public class StaffManageData_Stub implements StaffManageDataService{

	@Override
	public UserPO find(long StaffId) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find successfully!");
		return new UserPO(000000, 000000, "aaaa", "Echo", "Manager", null);
	}

	@Override
	public ArrayList<UserPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find all successfully!");
		ArrayList<UserPO> staffInfoPOs = new ArrayList<UserPO>();
		staffInfoPOs.add(new UserPO(000000, 000000, "aaaa", "Echo", "Manager", null));
		return staffInfoPOs;
	}

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("insert successfully!");
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update successfully!");
		
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("delete successfully!");
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish successfully!");
		
	}

}
