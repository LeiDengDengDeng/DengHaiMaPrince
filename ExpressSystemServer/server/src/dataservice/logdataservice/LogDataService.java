package src.dataservice.logdataservice;

import src.po.LogPO;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author dell
 *
 */
public interface LogDataService extends Remote{
	
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
