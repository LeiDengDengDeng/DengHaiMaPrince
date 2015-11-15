package src.businesslogic.nonUserbl;

import src.businesslogicservice.nonUserblservice.NonUserBLService;
import src.po.DriverPO;
import src.po.TruckPO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

public class NonUserBLService_Driver {
	
	public void drive(NonUserBLService nonUserBLService){
		TruckInfoVO tvo = new TruckInfoVO(025000000, 10, "À’A00000");
		DriverInfoVO dvo = new DriverInfoVO(025000000, "“∂¡º≥Ω", 2015, 11, 5, 
				"321002000100010000", "88888888888", Sex.MALE, 2015);
		
		nonUserBLService.getTruckInfo(0);
		nonUserBLService.getAllTruckInfo();
		nonUserBLService.addTruckInfo(tvo);
		nonUserBLService.deleteTruckInfo(0);
		nonUserBLService.changeTruckInfo(0);
		nonUserBLService.getDriverInfo(0);
		nonUserBLService.getAllDriverInfo();
		nonUserBLService.addDriverInfo(dvo);
		nonUserBLService.deleteDriverInfo(0);
		nonUserBLService.changeDriverInfo(0);
		
	}

}
