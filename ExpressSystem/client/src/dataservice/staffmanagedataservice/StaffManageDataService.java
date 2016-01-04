package src.dataservice.staffmanagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.AuthorityPO;
import src.po.UserPO;


/**
 * @author  samsung
 */
public interface StaffManageDataService extends Remote{
	/**
	 * 根据ID返回UserPO
	 * @param StaffId
	 * @return
	 * @throws RemoteException
	 */
	public UserPO find(long StaffId) throws RemoteException;
		
	/**
	 * 返回所有StaffInfoPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> finds() throws RemoteException;
		
	 /**
	 * 在数据库中增加一个po记录
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(UserPO po) throws RemoteException;
		
	/**
	 * 更新一个po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(UserPO po) throws RemoteException;
	
	/**
	 * 删除一个po
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(UserPO po) throws RemoteException;
		
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
	

}
