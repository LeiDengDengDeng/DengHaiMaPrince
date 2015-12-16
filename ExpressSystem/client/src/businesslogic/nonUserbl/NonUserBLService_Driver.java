package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.nonUserblservice.NonUserBLService;
import src.po.DriverPO;
import src.po.TruckPO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

public class NonUserBLService_Driver {
	
	public void drive(NonUserBLService nonUserBLService){
//		TruckInfoVO tvo = new TruckInfoVO(025000000, 10, "À’A00000");
//		DriverInfoVO dvo = new DriverInfoVO(025000000, "“∂¡º≥Ω", 2015, 11, 5, 
//				"321002000100010000", "88888888888", Sex.MALE, 2015);
//		
//		nonUserBLService.getTruckInfo(0);
//		nonUserBLService.getAllTruckInfo();
//		nonUserBLService.addTruckInfo(tvo);
//		nonUserBLService.deleteTruckInfo(0);
//		nonUserBLService.changeTruckInfo(0);
//		nonUserBLService.getDriverInfo(0);
//		nonUserBLService.getAllDriverInfo();
//		nonUserBLService.addDriverInfo(dvo);
//		nonUserBLService.deleteDriverInfo(0);
//		nonUserBLService.changeDriverInfo(0);
//		
	}
	
	public static void main(String[] args) {
		Log log = null;
//		BussinessHall bussinessHall = new BussinessHall(log);
//		Driver driver = new Driver(log);
//		IntermediateCenter intermediateCenter = new IntermediateCenter(log);
		Truck truck = new Truck(log);
//		System.out.println(bussinessHall.getBussinessHallInfo("œ…¡÷”™“µÃ¸")
//				.getHallId());
//		System.out.println(driver.getDriverInfo(025000000).getName());
//		System.out.println(intermediateCenter.getcity());
//		System.out.println(truck.getTruckInfo(025000001).getLicensePlateNum());
		ArrayList<TruckInfoVO> tvolist = new ArrayList<TruckInfoVO>();
		TruckInfoVO tvo1 = new TruckInfoVO(025000000, 10, "À’A00000");
		TruckInfoVO tvo2 = new TruckInfoVO(025000001, 10, "À’A00001");
		tvolist.add(tvo1);
		tvolist.add(tvo2);
		truck.initTruck(tvolist);
	}

}
