package src.dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.AccountPO;

public interface AccountDataService extends Remote {
	public boolean insert(AccountPO po) throws RemoteException;

	public boolean delete(long ID) throws RemoteException;

	public ArrayList<AccountPO> getAll() throws RemoteException;

	public boolean update(AccountPO po) throws RemoteException;

	public AccountPO find(long id) throws RemoteException;
}
