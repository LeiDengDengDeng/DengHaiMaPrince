package src.main;

import src.businesslogic.accountbl.AccountBLServece_Driver;
import src.businesslogic.accountbl.AccountBLService_Stub;
import src.businesslogic.sheetbl.SheetBLService_Driver;
import src.businesslogic.sheetbl.SheetBLService_Stub;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.sheetblservice.SheetBLService;

public class ExpressSystem {
	
	public static void main(String[] args){
		AccountBLService accountBLService_Stub = new AccountBLService_Stub();
		AccountBLServece_Driver accountDriver = new AccountBLServece_Driver();
		accountDriver.drive(accountBLService_Stub);
		
		SheetBLService sheetBLService_Stub = new SheetBLService_Stub();
		SheetBLService_Driver sheetDriver = new SheetBLService_Driver();
		sheetDriver.drive(sheetBLService_Stub);
		
	}

}
