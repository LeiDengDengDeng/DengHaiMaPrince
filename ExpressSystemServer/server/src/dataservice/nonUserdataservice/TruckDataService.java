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
	public TruckPO findTruckPO(String id) throws RemoteException;
	
	/**
	 * ����Ӫҵ�����Ʒ�������������
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TruckPO> findsTruckPO(String id) throws RemoteException;
	
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
	 * @param id
	 * @param tpo
	 * @throws RemoteException
	 */
	public void update(String id,TruckPO tpo) throws RemoteException;
	
	/**
	 * ɾ��һ��TruckPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteTruckPO(String id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}
