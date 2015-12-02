package src.dataservice.sheetdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;
import src.po.SheetPO;

/**
 * @author dell
 * 
 */
public interface SheetDataService extends Remote{
	/**
	 * ����ID����SheetPO
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public SheetPO find(long id, SheetType type) throws RemoteException;

	/**
	 * ����type����һ��SheetPO
	 * 
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException;

	/**
	 * �����ݿ�������һ��po��¼
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(SheetPO po) throws RemoteException;

	/**
	 * ����һ��po
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public void update(SheetPO po) throws RemoteException;

	/**
	 * �����־û����ݿ��ʹ��
	 * 
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
