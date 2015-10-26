package src.dataservice.staffmanagedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.InstitutionPO;
import src.po.StaffInfoPO;


/**
 * @author  samsung
 */
public interface StaffManageDataService {
	/**
	 * 根据ID返回StaffInfoPO
	 * @param StaffId
	 * @return
	 * @throws RemoteException
	 */
	public StaffInfoPO find(long StaffId) throws RemoteException;
		
	/**
	 * 返回所有StaffInfoPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StaffInfoPO> finds() throws RemoteException;
		
	 /**
	 * 在数据库中增加一个po记录
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(StaffInfoPO po) throws RemoteException;
		
	/**
	 * 更新一个po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(StaffInfoPO po) throws RemoteException;
	
	/**
	 * 删除一个po
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(StaffInfoPO po) throws RemoteException;
		
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;

}
