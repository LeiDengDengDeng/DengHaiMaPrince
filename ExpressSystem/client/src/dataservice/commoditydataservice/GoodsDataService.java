package src.dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.enums.GoodsType;
import src.po.GoodsPO;

public interface GoodsDataService extends Remote{
	/**
	 * ����id����GoodsPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public GoodsPO findGoodsPO(long id) throws RemoteException;
	
	/**
	 * ����type����һ��GoodsPO
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsPO> finds(GoodsType type) throws RemoteException;
	
	/**
	 * ��������GoodsPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsPO> finds() throws RemoteException;
	
	/**
	 * �����ݿ�������һ��GoodsPO��¼
	 * @param gpo
	 * @throws RemoteException
	 */
	public void insert(GoodsPO gpo) throws RemoteException;
	
	/**
	 * ����һ��GoodsPO
	 * @param gpo
	 * @throws RemoteException
	 */
	public void update(GoodsPO gpo) throws RemoteException;
	
	/**
	 * ɾ��һ��GoodsPO
	 * @param id
	 * @throws RemoteException
	 */
	public void delete(long id) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
