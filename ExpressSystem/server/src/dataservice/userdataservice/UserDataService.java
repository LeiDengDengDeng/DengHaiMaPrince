package src.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import src.po.UserPO;


/**
 * @author  samsung
 */
public interface UserDataService extends Remote{

	/**
	 * 根据ID返回UserPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public UserPO find(long UserId) throws RemoteException;
	
	/**
	 * 更新一个po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(UserPO po) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
