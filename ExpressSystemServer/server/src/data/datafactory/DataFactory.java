package src.data.datafactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import src.data.logdata.LogData;
import src.data.sheetdata.SheetData;
import src.dataservice.accountdataservice.AccountDataService;
import src.dataservice.beginInfodataservice.BeginInfoDataService;
import src.dataservice.commoditydataservice.CommodityDataService;
import src.dataservice.datafactoryservice.DataFactoryService;
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.nonUserdataservice.NonUserDataService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.dataservice.userdataservice.UserDataService;

public class DataFactory extends UnicastRemoteObject implements DataFactoryService {


	private LogDataService logData;
	private SheetDataService sheetData;

	public DataFactory() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

//	@Override
//	public AccountDataService getAccountData() {
//		// TODO 自动生成的方法存根
//		return null;
//	}
//
//	@Override
//	public BeginInfoDataService getBeginInfoData() {
//		// TODO 自动生成的方法存根
//		return null;
//	}
//
//	@Override
//	public CommodityDataService getCommodityData() {
//		// TODO 自动生成的方法存根
//		return null;
//	}
//
//	@Override
//	public InstitutionDataService getInstitutionData() {
//		// TODO 自动生成的方法存根
//		return null;
//	}

	@Override
	public LogDataService getLogData() {
		// TODO 自动生成的方法存根
		return null;
//		return (logData != null) ? logData : (logData = new LogData());
	}

//	@Override
//	public NonUserDataService getNonUserData() {
//		// TODO 自动生成的方法存根
//		return null;
//	}

	@Override
	public SheetDataService getSheetData() {
		// TODO 自动生成的方法存根
		return null;
//		return (sheetData != null) ? sheetData : (sheetData = new SheetData());
	}

//	@Override
//	public StaffManageDataService getStaffManageData() {
//		// TODO 自动生成的方法存根
//		return null;
//	}
//
//	@Override
//	public UserDataService getUserData() {
//		// TODO 自动生成的方法存根
//		return null;
//	}

}
