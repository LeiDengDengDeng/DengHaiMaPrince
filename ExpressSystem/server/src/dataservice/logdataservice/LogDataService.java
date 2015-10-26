package src.dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.LogPO;

/**
 * @author dell
 *
 */
public interface LogDataService {
	
	/**
	 * ����ID����LogPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public LogPO find(long id) throws RemoteException;

	/**
	 * ��������LogPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LogPO> findAll() throws RemoteException;
	
	/**
	 * �����ݿ�������һ��po��¼
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(LogPO po) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
