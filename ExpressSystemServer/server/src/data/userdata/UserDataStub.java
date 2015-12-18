package src.data.userdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.userdataservice.UserDataService;
import src.po.UserPO;

public class UserDataStub implements UserDataService{

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

	@Override
	public void InitialInsert(ArrayList<UserPO> User) throws RemoteException {
		System.out.println("initialize successfully!!");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<UserPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
