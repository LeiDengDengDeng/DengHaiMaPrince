package src.dataservice.nonUserdataservice;

import java.rmi.RemoteException;

import src.po.DriverPO;
import src.po.TruckPO;

/**
 * ���û����ݲ����Ľӿ�
 * @author Potter
 *
 */
public interface NonUserDataService {
	
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
	public DriverPO finDriverPO(long id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;

}
