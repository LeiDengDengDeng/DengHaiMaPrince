package src.dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.StoragePO;

public interface StorageDataService extends Remote{
	/**
	 * ����id����StoragePO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public StoragePO findStoragePO(String id) throws RemoteException;
	
	/**
	 * ��������StoragePO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StoragePO> finds() throws RemoteException;
	
	/**
	 * �����ݿ�������һ��StoragePO��¼
	 * @param spo
	 * @throws RemoteException
	 */
	public void insert(StoragePO spo) throws RemoteException;
	
	/**
	 * ����һ��StoragePO
	 * @param spo
	 * @throws RemoteException
	 */
	public void update(StoragePO spo) throws RemoteException;
	
	/**
	 * ɾ��һ��StoragePO
	 * @param id
	 * @throws RemoteException
	 */
	public void delete(String id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
	
}
