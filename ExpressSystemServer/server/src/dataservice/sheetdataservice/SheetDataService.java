package src.dataservice.sheetdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.enums.SheetType;
import src.po.SheetPO;

/**
 * @author dell
 *
 */
public interface SheetDataService {
	/**
	 * 根据ID返回SheetPO
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public SheetPO find(long id) throws RemoteException;
	
	/**
	 * 根据type返回一组SheetPO
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SheetPO> finds(SheetType type) throws RemoteException;
	
	/**
	 * 在数据库中增加一个po记录
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(SheetPO po) throws RemoteException;

	/**
	 * 更新一个po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(SheetPO po) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
