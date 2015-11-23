package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.DriverPO;

public interface DriverDataService extends Remote{
	/**
	 * 根据id返回DriverPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public DriverPO findDriverPO(long id) throws RemoteException;
	
	/**
	 * 返回所有DriverPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverPO> findsDriverPO() throws RemoteException;
	
	/**
	 * 在数据库中增加一个DriverPO记录
	 * @param dpo
	 * @throws RemoteException
	 */
	public void insert(DriverPO dpo) throws RemoteException;
	
	/**
	 * 更新一个DriverPO
	 * @param dpo
	 * @throws RemoteException
	 */
	public void update(DriverPO dpo) throws RemoteException;
	
	/**
	 * 删除一个DriverPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteDriverPO(long id) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}
