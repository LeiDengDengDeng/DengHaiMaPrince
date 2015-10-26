package src.dataservice.nonUserdataservice;

import java.rmi.RemoteException;

import src.po.DriverPO;
import src.po.TruckPO;

/**
 * 非用户数据操作的接口
 * @author Potter
 *
 */
public interface NonUserDataService {
	
	/**
	 * 根据id返回TruckPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public TruckPO findTruckPO(long id) throws RemoteException;
	
	/**
	 * 根据id返回DriverPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public DriverPO finDriverPO(long id) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;

}
