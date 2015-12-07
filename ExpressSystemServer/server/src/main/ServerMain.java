package src.main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import src.data.accountdata.AccountData;
import src.data.logdata.LogData;
import src.data.sheetdata.SheetData;
import src.dataservice.accountdataservice.AccountDataService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.sheetdataservice.SheetDataService;

public class ServerMain {

	public static void main(String[] args) {

		try {
			LogDataService logData = new LogData();
			SheetDataService sheetData = new SheetData();
			AccountDataService accountData = new AccountData();
			LocateRegistry.createRegistry(6600);
			Naming.rebind("rmi://127.0.0.1:6600/logData", logData);
			Naming.rebind("rmi://127.0.0.1:6600/sheetData", sheetData);
			Naming.rebind("rmi://127.0.0.1:6600/accountData", accountData);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("Server Ready!");

	}

}
