package src.dataservice.institutiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.InstitutionPO;

/**
 * @author  samsung
 */
public interface InstitutionDataService {

		
	/**
	 * 根据ID返回InstitutionPO
	 * @param InstitutionId
	 * @return
	 * @throws RemoteException
	 */
	public InstitutionPO find(long InstitutionId) throws RemoteException;
		
	/**
	 * 返回所有InstitutionPO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<InstitutionPO> finds() throws RemoteException;
		
	 /**
	 * 在数据库中增加一个po记录
	 * @param po
	 * @throws RemoteException
	 */
	public void insert(InstitutionPO po) throws RemoteException;
		
	/**
	 * 更新一个po
	 * @param po
	 * @throws RemoteException
	 */
	public void update(InstitutionPO po) throws RemoteException;
	
	/**
	 * 删除一个po
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(InstitutionPO po) throws RemoteException;
		
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
