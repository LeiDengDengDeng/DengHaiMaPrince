package src.main;


import src.businesslogic.accountbl.AccountBLService_Driver;
import src.businesslogic.accountbl.AccountBLService_Stub;
import src.businesslogic.beginInfobl.BeginInfoBLService_Driver;
import src.businesslogic.beginInfobl.BeginInfoBLService_Stub;
import src.businesslogic.commoditybl.CommodityBLService_Driver;
import src.businesslogic.commoditybl.CommodityBLService_Stub;
import src.businesslogic.institutionbl.InstitutionBLService_Driver;
import src.businesslogic.institutionbl.InstitutionBLService_Stub;
import src.businesslogic.logbl.LogBLService_Driver;
import src.businesslogic.logbl.LogBLService_Stub;
import src.businesslogic.nonUserbl.NonUserBLService_Driver;
import src.businesslogic.nonUserbl.NonUserBLService_Stub;
import src.businesslogic.sheetbl.SheetBLService_Driver;
import src.businesslogic.sheetbl.SheetBLService_Stub;
import src.businesslogic.staffmanagebl.StaffManageBLService_Driver;
import src.businesslogic.staffmanagebl.StaffManageBLService_Stub;
import src.businesslogic.userbl.UserBLService_Driver;
import src.businesslogic.userbl.UserBLService_Stub;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.institutionblservice.InstitutionBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.NonUserBLService;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.businesslogicservice.staffmanageblservice.StaffManageBLService;
import src.businesslogicservice.userblservice.UserBLService;


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
//		SheetBLService sheetBLService_Stub = new SheetBLService_Stub(logBLService_Stub);
//		SheetBLService_Driver sheetDriver = new SheetBLService_Driver();
//		sheetDriver.drive(sheetBLService_Stub);
		
		System.out.println("----------BeginInfoDriver----------");
		BeginInfoBLService beginInfoBLService_Stub = new BeginInfoBLService_Stub(logBLService_Stub);
		BeginInfoBLService_Driver beginInfoDriver = new BeginInfoBLService_Driver();
		beginInfoDriver.drive(beginInfoBLService_Stub);
		

		System.out.println("----------CommodityDriver----------");
		CommodityBLService commodityBLService_Stub = new CommodityBLService_Stub(logBLService_Stub);
		CommodityBLService_Driver commodityDriver = new CommodityBLService_Driver();
		commodityDriver.drive(commodityBLService_Stub);
		
		System.out.println("----------NonUserDriver----------");
		NonUserBLService nonUserBLService_Stub = new NonUserBLService_Stub(logBLService_Stub);
		NonUserBLService_Driver nonUserDriver = new NonUserBLService_Driver();
		nonUserDriver.drive(nonUserBLService_Stub);


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
