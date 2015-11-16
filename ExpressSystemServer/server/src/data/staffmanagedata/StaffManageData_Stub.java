package src.data.staffmanagedata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.po.UserPO;

public class StaffManageData_Stub implements StaffManageDataService{

	public UserPO find(long StaffId) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find successfully!");
		return new UserPO(000000, 000000, "aaaa", "Echo", "Manager", null);
	}

	public ArrayList<UserPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find all successfully!");
		ArrayList<UserPO> staffInfoPOs = new ArrayList<UserPO>();
		staffInfoPOs.add(new UserPO(000000, 000000, "aaaa", "Echo", "Manager", null));
		return staffInfoPOs;
	}

	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("insert successfully!");
	}

	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update successfully!");
		
	}

	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("delete successfully!");
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish successfully!");
		
	}

}
