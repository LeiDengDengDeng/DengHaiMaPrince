package src.dataservice.positiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.AuthorityPO;

/**
 * @author  samsung
 */
public interface PositionDataService extends Remote{
	/**
	 * ����Ȩ��
	 * @throws RemoteException
	 */
	public void insert(AuthorityPO authorityPO) throws RemoteException;
	
	/**
	 * ����ְλ���Ȩ��
	 * @throws RemoteException
	 */
	public AuthorityPO find(String position) throws RemoteException;
	
	/**
	 * �������Ȩ��
	 * @throws RemoteException
	 */
	public ArrayList<AuthorityPO> finds() throws RemoteException;
	
	/**
	 * ɾ��Ȩ��
	 * @throws RemoteException
	 */
	public void delete(String position) throws RemoteException;
	
	/**
	 * ����Ȩ��
	 * @throws RemoteException
	 */
	public void update(AuthorityPO authorityPO) throws RemoteException;
}
