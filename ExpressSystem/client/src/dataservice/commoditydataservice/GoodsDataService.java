package src.dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.enums.GoodsType;
import src.po.GoodsPO;

public interface GoodsDataService extends Remote{
	/**
	 * 根据id返回GoodsPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public GoodsPO findGoodsPO(long id) throws RemoteException;
	
	/**
	 * 根据type返回一组GoodsPO
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsPO> finds(GoodsType type) throws RemoteException;
	
	/**
	 * 返回所有GoodsPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<GoodsPO> finds() throws RemoteException;
	
	/**
	 * 在数据库中增加一个GoodsPO记录
	 * @param gpo
	 * @throws RemoteException
	 */
	public void insert(GoodsPO gpo) throws RemoteException;
	
	/**
	 * 更新一个GoodsPO
	 * @param gpo
	 * @throws RemoteException
	 */
	public void update(GoodsPO gpo) throws RemoteException;
	
	/**
	 * 删除一个GoodsPO
	 * @param id
	 * @throws RemoteException
	 */
	public void delete(long id) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
