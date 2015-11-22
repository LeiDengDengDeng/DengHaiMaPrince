package src.dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.UserPO;


/**
 * @author  samsung
 */
public interface UserDataService extends Remote{

	/**
	 * �ڳ�����ʱ��ʼ��
	 * @param User
	 * @return
	 * @throws RemoteException
	 */
	public void insert(ArrayList<UserPO> User) throws RemoteException;
	
	/**
	 * ����ID����UserPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public UserPO find(long UserId) throws RemoteException;
	
	/**
	 * ����һ��po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(UserPO po) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
