package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.BussinessHallPO;

public interface BusinessHallDataService extends Remote{
	/**
	 * ����id����BussinessHallPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public BussinessHallPO findBussinessHallPO(String id) throws RemoteException;
	
	/**
	 * ��������BussinessHallPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BussinessHallPO> findsBussinessHallPO() throws RemoteException;
	
	/**
	 * �����ݿ�������һ��BussinessHallPO��¼
	 * @param tpo
	 * @throws RemoteException
	 */
	public void insert(BussinessHallPO bpo) throws RemoteException;
	
	/**
	 * ɾ��һ��BussinessHallPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteBussinessHallPO(String id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
	
}
