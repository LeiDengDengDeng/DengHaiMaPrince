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
	public void InitialInsert(ArrayList<UserPO> User) throws RemoteException;
	
	/**
	 * ����һ��po
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public void insert(UserPO po) throws RemoteException;
	
	/**
	 * ɾ��һ��po
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public void delete(UserPO po) throws RemoteException;
	
	/**
	 * ����ID����UserPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public UserPO find(long UserId) throws RemoteException;
	
	
	/**
	 * �������po
	 * @param 
	 * @return	
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> finds() throws RemoteException;
	
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
