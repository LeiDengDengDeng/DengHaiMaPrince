package src.data.staffmanagedata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.data.logdata.MyObjectOutputStream;
import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.po.UserPO;

public class StaffManageDataStub implements StaffManageDataService{

//	private static final String UserFILE_PATH = "user.ser";
//	File file = new File(UserFILE_PATH);
	
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
	
//	public static void main(String[] args){
//		StaffManageData staffManageData = new StaffManageData();
//		try {
//			staffManageData.insert(new UserPO(100000, 100000, "aaaa", "Echo", "Manager", null));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
