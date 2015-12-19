package src.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import src.data.Institutiondata.InstitutionData;
import src.data.accountdata.AccountData;
import src.data.beginInfodata.BeginInfoData;
import src.data.commoditydata.GoodsData;
import src.data.commoditydata.StorageData;
import src.data.logdata.LogData;
import src.data.nonUserdata.BusinessHallData;
import src.data.nonUserdata.DriverData;
import src.data.nonUserdata.IntermediateCenterData;
import src.data.nonUserdata.TruckData;
import src.data.sheetdata.SheetData;
import src.data.staffmanagedata.StaffManageData;
import src.data.userdata.UserData;
import src.dataservice.accountdataservice.AccountDataService;
import src.dataservice.beginInfodataservice.BeginInfoDataService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.nonUserdataservice.BusinessHallDataService;
import src.dataservice.nonUserdataservice.DriverDataService;
import src.dataservice.nonUserdataservice.IntermediateCenterDataService;
import src.dataservice.nonUserdataservice.TruckDataService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.dataservice.userdataservice.UserDataService;

public class ServerMain {

	public static void main(String[] args) {

		try {
			LogDataService logData = new LogData();
			SheetDataService sheetData = new SheetData();
			AccountDataService accountData = new AccountData();
			BeginInfoDataService beginInfoData=new BeginInfoData();
			UserDataService userData = new UserData();
			StaffManageDataService staffManageData = new StaffManageData();
			InstitutionDataService institutionData = new InstitutionData();
			StorageDataService storageData = new StorageData();
			GoodsDataService goodsData = new GoodsData();
			BusinessHallDataService businessHallData = new BusinessHallData();
			IntermediateCenterDataService intermediateCenterData = new IntermediateCenterData();
			DriverDataService driverData = new DriverData();
			TruckDataService truckData = new TruckData();
			LocateRegistry.createRegistry(6600);
			Naming.rebind("rmi://127.0.0.1:6600/logData", logData);
			Naming.rebind("rmi://127.0.0.1:6600/sheetData", sheetData);
			Naming.rebind("rmi://127.0.0.1:6600/accountData", accountData);
			Naming.rebind("rmi://127.0.0.1:6600/userData", userData);
			Naming.rebind("rmi://127.0.0.1:6600/staffManageData", staffManageData);
			Naming.rebind("rmi://127.0.0.1:6600/institutionData", institutionData);
			Naming.rebind("rmi://127.0.0.1:6600/storageData", storageData);
			Naming.rebind("rmi://127.0.0.1:6600/goodsData", goodsData);
			Naming.rebind("rmi://127.0.0.1:6600/businessHallData", businessHallData);
			Naming.rebind("rmi://127.0.0.1:6600/intermediateCenterData", intermediateCenterData);
			Naming.rebind("rmi://127.0.0.1:6600/driverData", driverData);
			Naming.rebind("rmi://127.0.0.1:6600/truckData", truckData);
			Naming.rebind("rmi://127.0.0.1:6600/beginInfoData",beginInfoData);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("Server Ready!");

	}

}
