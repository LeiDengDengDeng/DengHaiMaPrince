package src.dataservice.staffmanagedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.InstitutionPO;
import src.po.StaffInfoPO;


/**
 * @author  samsung
 */
public interface StaffManageDataService {
	/**
	 * ����ID����StaffInfoPO
	 * @param StaffId
	 * @return
	 * @throws RemoteException
	 */
	public StaffInfoPO find(long StaffId) throws RemoteException;
		
	/**
	 * ��������StaffInfoPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StaffInfoPO> finds() throws RemoteException;
		
	 /**
	 * �����ݿ�������һ��po��¼
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(StaffInfoPO po) throws RemoteException;
		
	/**
	 * ����һ��po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(StaffInfoPO po) throws RemoteException;
	
	/**
	 * ɾ��һ��po
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(StaffInfoPO po) throws RemoteException;
		
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;

}
