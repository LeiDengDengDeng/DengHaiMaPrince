package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.DriverPO;

public interface DriverDataService extends Remote{
	/**
	 * ����id����DriverPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public DriverPO findDriverPO(long id) throws RemoteException;
	
	/**
	 * ��������DriverPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverPO> findsDriverPO() throws RemoteException;
	
	/**
	 * �����ݿ�������һ��DriverPO��¼
	 * @param dpo
	 * @throws RemoteException
	 */
	public void insert(DriverPO dpo) throws RemoteException;
	
	/**
	 * ����һ��DriverPO
	 * @param dpo
	 * @throws RemoteException
	 */
	public void update(DriverPO dpo) throws RemoteException;
	
	/**
	 * ɾ��һ��DriverPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteDriverPO(long id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}
