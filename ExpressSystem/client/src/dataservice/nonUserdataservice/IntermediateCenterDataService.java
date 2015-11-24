package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.IntermediateCenterPO;


public interface IntermediateCenterDataService extends Remote{
	/**
	 * 根据id返回IntermediateCenterPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public IntermediateCenterPO findIntermediateCenterPO(String id) throws RemoteException;
	
	/**
	 * 返回所有IntermediateCenterPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<IntermediateCenterPO> findsIntermediateCenterPO() throws RemoteException;
	
	/**
	 * 在数据库中增加一个IntermediateCenterPO记录
	 * @param tpo
	 * @throws RemoteException
	 */
	public void insert(IntermediateCenterPO ipo) throws RemoteException;
	
	/**
	 * 删除一个IntermediateCenterPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteIntermediateCenterPO(String id) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
