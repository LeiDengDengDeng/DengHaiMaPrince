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
		// TODO �Զ����ɵĹ��캯�����
	}

//	@Override
//	public AccountDataService getAccountData() {
//		// TODO �Զ����ɵķ������
//		return null;
//	}
//
//	@Override
//	public BeginInfoDataService getBeginInfoData() {
//		// TODO �Զ����ɵķ������
//		return null;
//	}
//
//	@Override
//	public CommodityDataService getCommodityData() {
//		// TODO �Զ����ɵķ������
//		return null;
//	}
//
//	@Override
//	public InstitutionDataService getInstitutionData() {
//		// TODO �Զ����ɵķ������
//		return null;
//	}

	@Override
	public LogDataService getLogData() {
		// TODO �Զ����ɵķ������
		return null;
//		return (logData != null) ? logData : (logData = new LogData());
	}

//	@Override
//	public NonUserDataService getNonUserData() {
//		// TODO �Զ����ɵķ������
//		return null;
//	}

	@Override
	public SheetDataService getSheetData() {
		// TODO �Զ����ɵķ������
		return null;
//		return (sheetData != null) ? sheetData : (sheetData = new SheetData());
	}

//	@Override
//	public StaffManageDataService getStaffManageData() {
//		// TODO �Զ����ɵķ������
//		return null;
//	}
//
//	@Override
//	public UserDataService getUserData() {
//		// TODO �Զ����ɵķ������
//		return null;
//	}

}
