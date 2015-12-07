package src.dataservice.datafactoryservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import src.dataservice.accountdataservice.AccountDataService;
import src.dataservice.beginInfodataservice.BeginInfoDataService;
import src.dataservice.commoditydataservice.CommodityDataService;
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.nonUserdataservice.NonUserDataService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.dataservice.userdataservice.UserDataService;

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
