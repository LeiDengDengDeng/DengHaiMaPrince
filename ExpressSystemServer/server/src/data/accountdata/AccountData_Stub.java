package src.data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.accountdataservice.AccountDataService;
import src.po.AccountPO;

public class AccountData_Stub implements AccountDataService {

	public void insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert succeed!");

	}

	public void delete(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete succeed!");
	}

	public ArrayList<AccountPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Get succeed!");
		ArrayList<AccountPO> pos=new ArrayList<AccountPO>();
		pos.add(new AccountPO("Ð¡Íõ×Ó", 123412223L, 100000));
		return pos;
	}

	public void update(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update succeed!");
		
	}

}
