package src.dataservice.beginInfodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import src.po.BeginInfoPO;

public interface BeginInfoDataService extends Remote {
	public void insert(BeginInfoPO po)throws RemoteException;
	public BeginInfoPO get()throws RemoteException;
}
