package src.main;

import src.businesslogic.accountbl.AccountBLService_Driver;
import src.businesslogic.accountbl.AccountBLService_Stub;
import src.businesslogic.beginInfobl.BeginInfoBLService_Driver;
import src.businesslogic.beginInfobl.BeginInfoBLService_Stub;
import src.businesslogic.logbl.LogBLService_Driver;
import src.businesslogic.logbl.LogBLService_Stub;
import src.businesslogic.sheetbl.SheetBLService_Driver;
import src.businesslogic.sheetbl.SheetBLService_Stub;
import src.businesslogicservice.StaffManagebl.StaffManageBLService_Driver;
import src.businesslogicservice.StaffManagebl.StaffManageBLService_Stub;
import src.businesslogicservice.StaffManageblService.StaffManageBLService;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.businesslogicservice.institutionbl.InstitutionBLService_Driver;
import src.businesslogicservice.institutionbl.InstitutionBLService_Stub;
import src.businesslogicservice.institutionblService.InstitutionBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.businesslogicservice.userbl.UserBLService_Driver;
import src.businesslogicservice.userbl.UserBLService_Stub;
import src.businesslogicservice.userblService.UserBLService;

public class ExpressSystem {
	
	public static void main(String[] args){
		System.out.println("----------LogDriver----------");
		LogBLService logBLService_Stub = new LogBLService_Stub();
		LogBLService_Driver logDriver = new LogBLService_Driver();
		logDriver.drive(logBLService_Stub);

		System.out.println("----------AccountDriver----------");
		AccountBLService accountBLService_Stub = new AccountBLService_Stub(logBLService_Stub);
		AccountBLService_Driver accountDriver = new AccountBLService_Driver();
		accountDriver.drive(accountBLService_Stub);
		
		System.out.println("----------SheetDriver----------");
		SheetBLService sheetBLService_Stub = new SheetBLService_Stub(logBLService_Stub);
		SheetBLService_Driver sheetDriver = new SheetBLService_Driver();
		sheetDriver.drive(sheetBLService_Stub);
		
		System.out.println("----------BeginInfoDriver----------");
		BeginInfoBLService beginInfoBLService_Stub = new BeginInfoBLService_Stub(logBLService_Stub);
		BeginInfoBLService_Driver beginInfoDriver = new BeginInfoBLService_Driver();
		beginInfoDriver.drive(beginInfoBLService_Stub);
		
		System.out.println("----------StaffManageDriver----------");
		StaffManageBLService staffManageBLService_Stub = new StaffManageBLService_Stub();
		StaffManageBLService_Driver staffManageDriver = new StaffManageBLService_Driver();
		staffManageDriver.drive(staffManageBLService_Stub);
		
		System.out.println("----------UserDriver----------");
		UserBLService userBLService_Stub = new UserBLService_Stub();
		UserBLService_Driver userDriver = new UserBLService_Driver();
		userDriver.drive(userBLService_Stub);
		
		System.out.println("----------InstitutionDriver----------");
		InstitutionBLService institutionBLService_Stub = new InstitutionBLService_Stub();
		InstitutionBLService_Driver institutionDriver = new InstitutionBLService_Driver();
		institutionDriver.drive(institutionBLService_Stub);
	}

}
