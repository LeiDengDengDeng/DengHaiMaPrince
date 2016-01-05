package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.TruckPO;

/**
 * 车辆数据操作的接口
 * @author Potter
 *
 */
public interface TruckDataService extends Remote{
	/**
	 * 根据id返回TruckPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public TruckPO findTruckPO(String id) throws RemoteException;
	
	/**
	 * 根据营业厅名称返回其所属车辆
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TruckPO> findsTruckPO(String id) throws RemoteException;
	
	/**
	 * 返回所有TruckPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TruckPO> findsTruckPO() throws RemoteException;
	
	/**
	 * 在数据库中增加一个TruckPO记录
	 * @param tpo
	 * @throws RemoteException
	 */
	public void insert(TruckPO tpo) throws RemoteException;
	
	/**
	 * 更新一个TruckPO
	 * @param id
	 * @param tpo
	 * @throws RemoteException
	 */
	public void update(String id,TruckPO tpo) throws RemoteException;
	
	/**
	 * 删除一个TruckPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteTruckPO(String id) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}
