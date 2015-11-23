package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.IntermediateCenterPO;


public interface IntermediateCenterDataService extends Remote{
	/**
	 * ����id����IntermediateCenterPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public IntermediateCenterPO findIntermediateCenterPO(String id) throws RemoteException;
	
	/**
	 * ��������IntermediateCenterPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<IntermediateCenterPO> findsIntermediateCenterPO() throws RemoteException;
	
	/**
	 * �����ݿ�������һ��IntermediateCenterPO��¼
	 * @param tpo
	 * @throws RemoteException
	 */
	public void insert(IntermediateCenterPO ipo) throws RemoteException;
	
	/**
	 * ɾ��һ��IntermediateCenterPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteIntermediateCenterPO(String id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
