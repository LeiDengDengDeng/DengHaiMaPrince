package src.data.userdata;

import java.rmi.RemoteException;

import src.dataservice.userdataservice.UserDataService;
import src.po.UserPO;

public class UserData_Stub implements UserDataService{

	public UserPO find(long UserId) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find user successfully!");
		return new UserPO(000000, 000000, "aaaa", "Echo", "Manager", null);
	}

	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update user successfully!");
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish successfully!");
	}

}