package src.dataservice.datafactoryservice;

import src.dataservice.logdataservice.LogDataService;
import src.dataservice.sheetdataservice.SheetDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataFactoryService extends Remote{

//	public AccountDataService getAccountData() throws RemoteException;

//	public BeginInfoDataService getBeginInfoData() throws RemoteException;

//	public CommodityDataService getCommodityData() throws RemoteException;

//	public InstitutionDataService getInstitutionData() throws RemoteException;

	public LogDataService getLogData() throws RemoteException;

//	public NonUserDataService getNonUserData() throws RemoteException;

	public SheetDataService getSheetData() throws RemoteException;

//	public StaffManageDataService getStaffManageData() throws RemoteException;

//	public UserDataService getUserData() throws RemoteException;

}
