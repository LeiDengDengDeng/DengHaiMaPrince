package src.dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.AccountPO;

public interface AccountDataService extends Remote {
	public void insert(AccountPO po) throws RemoteException;

	public void delete(AccountPO po) throws RemoteException;
	
	public ArrayList<AccountPO> getAll() throws RemoteException;

	public void update(AccountPO po) throws RemoteException;
}
