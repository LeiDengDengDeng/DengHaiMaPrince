package src.main;

import src.businesslogic.accountbl.AccountBLService_Driver;
import src.businesslogic.accountbl.AccountBLService_Stub;
import src.businesslogic.beginInfobl.BeginInfoBLService_Driver;
import src.businesslogic.beginInfobl.BeginInfoBLService_Stub;
import src.businesslogic.logbl.LogBLService_Driver;
import src.businesslogic.logbl.LogBLService_Stub;
import src.businesslogic.sheetbl.SheetBLService_Driver;
import src.businesslogic.sheetbl.SheetBLService_Stub;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.sheetblservice.SheetBLService;

public class ExpressSystem {
	
	public static void main(String[] args){
		System.out.println("----------AccountDriver----------");
		AccountBLService accountBLService_Stub = new AccountBLService_Stub(logBLService_Stub);
		AccountBLService_Driver accountDriver = new AccountBLService_Driver();
		accountDriver.drive(accountBLService_Stub);
		
		System.out.println("----------SheetDriver----------");
		SheetBLService sheetBLService_Stub = new SheetBLService_Stub();
		SheetBLService_Driver sheetDriver = new SheetBLService_Driver();
		sheetDriver.drive(sheetBLService_Stub);
		
		System.out.println("----------LogDriver----------");
		LogBLService logBLService_Stub = new LogBLService_Stub();
		LogBLService_Driver logDriver = new LogBLService_Driver();
		logDriver.drive(logBLService_Stub);
		
		System.out.println("----------BeginInfoDriver----------");
		BeginInfoBLService beginInfoBLService_Stub = new BeginInfoBLService_Stub();
		BeginInfoBLService_Driver beginInfoDriver = new BeginInfoBLService_Driver();
		beginInfoDriver.drive(beginInfoBLService_Stub);
	}

}
