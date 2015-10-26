package src.dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.LogPO;

/**
 * @author dell
 *
 */
public interface LogDataService {
	
	/**
	 * 根据ID返回LogPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public LogPO find(long id) throws RemoteException;

	/**
	 * 返回所有LogPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LogPO> findAll() throws RemoteException;
	
	/**
	 * 在数据库中增加一个po记录
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(LogPO po) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
