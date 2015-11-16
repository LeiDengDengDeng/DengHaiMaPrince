package src.dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.enums.GoodsType;
import src.po.GoodsPO;
import src.po.StoragePO;

/**
 * ������ݲ����Ľӿ�
 * @author Potter
 *
 */
public interface CommodityDataService {

	/**
	 * ����id����GoodsPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public GoodsPO findGoodsPO(long id) throws RemoteException;
	
	/**
	 * ����id����StoragePO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public StoragePO findStoragePO(long id)  throws RemoteException;
	
	/**
	 * ����type����һ��GoodsPO
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsPO> finds(GoodsType type) throws RemoteException;
	
	/**
	 * �����ݿ�������һ��GoodsPO��¼
	 * @param gpo
	 * @throws RemoteException
	 */
	public void insert(GoodsPO gpo) throws RemoteException;
	
	/**
	 * �����ݿ�������һ��StoragePO��¼
	 * @param spo
	 * @throws RemoteException
	 */
	public void insert(StoragePO spo) throws RemoteException;
	
	/**
	 * ����һ��GoodsPO
	 * @param gpo
	 * @throws RemoteException
	 */
	public void update(GoodsPO gpo) throws RemoteException;
	
	/**
	 * ����һ��StoragePO
	 * @param spo
	 * @throws RemoteException
	 */
	public void update(StoragePO spo) throws RemoteException;
	
	/**
	 * �����־û����ݿ��ʹ��
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
