package src.dataservice.positiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.po.AuthorityPO;

/**
 * @author  samsung
 */
public interface PositionDataService extends Remote{
	/**
	 * 设置权限
	 * @throws RemoteException
	 */
	public void insert(AuthorityPO authorityPO) throws RemoteException;
	
	/**
	 * 根据职位获得权限
	 * @throws RemoteException
	 */
	public AuthorityPO find(String position) throws RemoteException;
	
	/**
	 * 获得所有权限
	 * @throws RemoteException
	 */
	public ArrayList<AuthorityPO> finds() throws RemoteException;
	
	/**
	 * 删除权限
	 * @throws RemoteException
	 */
	public void delete(String position) throws RemoteException;
	
	/**
	 * 更新权限
	 * @throws RemoteException
	 */
	public void update(AuthorityPO authorityPO) throws RemoteException;
}
