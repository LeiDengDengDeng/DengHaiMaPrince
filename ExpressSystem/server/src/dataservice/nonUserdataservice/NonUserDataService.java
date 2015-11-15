package src.dataservice.nonUserdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.BussinessHallPO;
import src.po.DriverPO;
import src.po.GoodsPO;
import src.po.TruckPO;
import src.vo.TruckInfoVO;

/**
 * ���û����ݲ����Ľӿ�
 * @author Potter
 *
 */
public interface NonUserDataService extends Remote{
	
	/**
	 * ����id����TruckPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public TruckPO findTruckPO(long id) throws RemoteException;
	
	/**
	 * ����id����DriverPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public DriverPO findDriverPO(long id) throws RemoteException;
	
	/**
	 * ����id����BussinessHallPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public BussinessHallPO findBussinessHallPO(long id) throws RemoteException;
	
	/**
	 * ��������TruckPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TruckPO> findsTruckPO() throws RemoteException;
	
	/**
	 * ��������DriverPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverPO> findsDriverPO() throws RemoteException;
	
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
	 * �����ݿ�������һ��DriverPO��¼
	 * @param dpo
	 * @throws RemoteException
	 */
	public void insert(DriverPO dpo) throws RemoteException;
	
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
	 * ����һ��DriverPO
	 * @param dpo
	 * @throws RemoteException
	 */
	public void update(DriverPO dpo) throws RemoteException;
	
	/**
	 * ɾ��һ��TruckPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteTruckPO(long id) throws RemoteException;
	
	/**
	 * ɾ��һ��DriverPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteDriverPO(long id) throws RemoteException;
	
	/**
	 * ɾ��һ��BussinessHallPO
	 * @param id
	 * @throws RemoteException
	 */
	public void deleteBussinessHallPO(long id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;

}
