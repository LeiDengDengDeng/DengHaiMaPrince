package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.TruckPO;

/**
 * �������ݲ����Ľӿ�
 * @author Potter
 *
 */
public interface TruckDataService extends Remote{
	/**
	 * ����id����TruckPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public TruckPO findTruckPO(long id) throws RemoteException;
	
	/**
	 * ��������TruckPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TruckPO> findsTruckPO() throws RemoteException;
	
	/**
	 * �����ݿ�������һ��TruckPO��¼
	 * @param tpo
	 * @throws RemoteException
	 */
	public void insert(TruckPO tpo) throws RemoteException;
	
	/**
	 * ����һ��TruckPO
	 * @param tpo
	 * @throws RemoteException
	 */
	public void update(TruckPO tpo) throws RemoteException;
	
	/**
	 * ɾ��һ��TruckPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteTruckPO(long id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}
