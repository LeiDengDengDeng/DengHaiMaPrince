package src.data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.accountdataservice.AccountDataService;
import src.po.AccountPO;

public class AccountDataStub implements AccountDataService {

	public boolean insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert succeed!");
		return false;
	}

	public boolean delete(long id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete succeed!");
		return false;
	}

	public ArrayList<AccountPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Get succeed!");
		ArrayList<AccountPO> pos=new ArrayList<AccountPO>();
		pos.add(new AccountPO("Ð¡Íõ×Ó", 123412223L, 100000));
		return pos;
	}

	public boolean update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update succeed!");
		return false;
	}

	@Override
	public AccountPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
