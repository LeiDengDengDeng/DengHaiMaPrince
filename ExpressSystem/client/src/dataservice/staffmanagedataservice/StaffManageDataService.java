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
	 * ����ID����UserPO
	 * @param StaffId
	 * @return
	 * @throws RemoteException
	 */
	public UserPO find(long StaffId) throws RemoteException;
		
	/**
	 * ��������StaffInfoPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> finds() throws RemoteException;
		
	 /**
	 * �����ݿ�������һ��po��¼
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(UserPO po) throws RemoteException;
		
	/**
	 * ����һ��po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(UserPO po) throws RemoteException;
	
	/**
	 * ɾ��һ��po
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(UserPO po) throws RemoteException;
		
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
	

}
