package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.BussinessHallPO;
import src.po.DriverPO;
import src.po.GoodsPO;
import src.po.TruckPO;
import src.vo.TruckInfoVO;

/**
 * 非用户数据操作的接口
 * @author Potter
 *
 */
public interface NonUserDataService extends Remote{
	
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
	public DriverPO findDriverPO(long id) throws RemoteException;
	
	/**
	 * 根据id返回BussinessHallPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public BussinessHallPO findBussinessHallPO(long id) throws RemoteException;
	
	/**
	 * 返回所有TruckPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TruckPO> findsTruckPO() throws RemoteException;
	
	/**
	 * 返回所有DriverPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverPO> findsDriverPO() throws RemoteException;
	
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
	 * 在数据库中增加一个DriverPO记录
	 * @param dpo
	 * @throws RemoteException
	 */
	public void insert(DriverPO dpo) throws RemoteException;
	
	/**
	 * 在数据库中增加一个TruckPO记录
	 * @param tpo
	 * @throws RemoteException
	 */
	public void insert(TruckPO tpo) throws RemoteException;
	
	/**
	 * 更新一个TruckPO
	 * @param tpo
	 * @throws RemoteException
	 */
	public void update(TruckPO tpo) throws RemoteException;
	
	/**
	 * 更新一个DriverPO
	 * @param dpo
	 * @throws RemoteException
	 */
	public void update(DriverPO dpo) throws RemoteException;
	
	/**
	 * 删除一个TruckPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteTruckPO(long id) throws RemoteException;
	
	/**
	 * 删除一个DriverPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteDriverPO(long id) throws RemoteException;
	
	/**
	 * 删除一个BussinessHallPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteBussinessHallPO(long id) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;

}
