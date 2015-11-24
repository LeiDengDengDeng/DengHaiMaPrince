package src.dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.StoragePO;

public interface StorageDataService extends Remote{
	/**
	 * 根据id返回StoragePO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public StoragePO findStoragePO(String id) throws RemoteException;
	
	/**
	 * 返回所有StoragePO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StoragePO> finds() throws RemoteException;
	
	/**
	 * 在数据库中增加一个StoragePO记录
	 * @param spo
	 * @throws RemoteException
	 */
	public void insert(StoragePO spo) throws RemoteException;
	
	/**
	 * 更新一个StoragePO
	 * @param spo
	 * @throws RemoteException
	 */
	public void update(StoragePO spo) throws RemoteException;
	
	/**
	 * 删除一个StoragePO
	 * @param id
	 * @throws RemoteException
	 */
	public void delete(String id) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
	
}
