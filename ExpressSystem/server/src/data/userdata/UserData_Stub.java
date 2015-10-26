package src.data.userdata;

import java.rmi.RemoteException;

import src.dataservice.userdataservice.UserDataService;
import src.po.UserPO;

public class UserData_Stub implements UserDataService{

	@Override
	public UserPO find(long UserId) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find user successfully!");
		return new UserPO(000000, 000000, "aaaa", "Echo", "Manager", null, 5000);
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update user successfully!");
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finish successfully!");
	}

}
