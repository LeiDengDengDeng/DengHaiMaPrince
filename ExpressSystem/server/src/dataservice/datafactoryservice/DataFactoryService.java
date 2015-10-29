package src.dataservice.datafactoryservice;

import src.dataservice.accountdataservice.AccountDataService;
import src.dataservice.beginInfodataservice.BeginInfoDataService;
import src.dataservice.commoditydataservice.CommodityDataService;
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.nonUserdataservice.NonUserDataService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.dataservice.userdataservice.UserDataService;

public interface DataFactoryService {
	
	public AccountDataService getAccountData();
	
	public BeginInfoDataService getBeginInfoData();
	
	public CommodityDataService getCommodityData();
	
	public InstitutionDataService getInstitutionData();
	
	public LogDataService getLogData();
	
	public NonUserDataService getNonUserData();
	
	public SheetDataService getSheetData();
	
	public StaffManageDataService getStaffManageData();
	
	public UserDataService getUserData();

}
