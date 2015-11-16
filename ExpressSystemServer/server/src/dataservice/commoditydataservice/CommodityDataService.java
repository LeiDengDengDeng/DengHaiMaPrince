package src.dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.enums.GoodsType;
import src.po.GoodsPO;
import src.po.StoragePO;

/**
 * 库存数据操作的接口
 * @author Potter
 *
 */
public interface CommodityDataService {

	/**
	 * 根据id返回GoodsPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public GoodsPO findGoodsPO(long id) throws RemoteException;
	
	/**
	 * 根据id返回StoragePO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public StoragePO findStoragePO(long id)  throws RemoteException;
	
	/**
	 * 根据type返回一组GoodsPO
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsPO> finds(GoodsType type) throws RemoteException;
	
	/**
	 * 在数据库中增加一个GoodsPO记录
	 * @param gpo
	 * @throws RemoteException
	 */
	public void insert(GoodsPO gpo) throws RemoteException;
	
	/**
	 * 在数据库中增加一个StoragePO记录
	 * @param spo
	 * @throws RemoteException
	 */
	public void insert(StoragePO spo) throws RemoteException;
	
	/**
	 * 更新一个GoodsPO
	 * @param gpo
	 * @throws RemoteException
	 */
	public void update(GoodsPO gpo) throws RemoteException;
	
	/**
	 * 更新一个StoragePO
	 * @param spo
	 * @throws RemoteException
	 */
	public void update(StoragePO spo) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
