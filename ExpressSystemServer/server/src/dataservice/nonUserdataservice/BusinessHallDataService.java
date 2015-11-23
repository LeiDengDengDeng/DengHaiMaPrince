package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.BussinessHallPO;

public interface BusinessHallDataService extends Remote{
	/**
	 * 根据id返回BussinessHallPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public BussinessHallPO findBussinessHallPO(String id) throws RemoteException;
	
	/**
	 * 返回所有BussinessHallPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BussinessHallPO> findsBussinessHallPO() throws RemoteException;
	
	/**
	 * 在数据库中增加一个BussinessHallPO记录
	 * @param tpo
	 * @throws RemoteException
	 */
	public void insert(BussinessHallPO bpo) throws RemoteException;
	
	/**
	 * 删除一个BussinessHallPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteBussinessHallPO(String id) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}
