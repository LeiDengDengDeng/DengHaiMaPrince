package src.dataservice.institutiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.InstitutionPO;

/**
 * @author  samsung
 */
public interface InstitutionDataService {

		
	/**
	 * ����ID����InstitutionPO
	 * @param InstitutionId
	 * @return
	 * @throws RemoteException
	 */
	public InstitutionPO find(long InstitutionId) throws RemoteException;
		
	/**
	 * ��������InstitutionPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<InstitutionPO> finds() throws RemoteException;
		
	 /**
	 * �����ݿ�������һ��po��¼
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(InstitutionPO po) throws RemoteException;
		
	/**
	 * ����һ��po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(InstitutionPO po) throws RemoteException;
	
	/**
	 * ɾ��һ��po
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(InstitutionPO po) throws RemoteException;
		
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
