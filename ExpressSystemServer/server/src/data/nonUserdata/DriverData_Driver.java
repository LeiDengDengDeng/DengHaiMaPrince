package src.data.nonUserdata;
import java.rmi.RemoteException;

import src.enums.Sex;
import src.po.DriverPO;

public class DriverData_Driver {
	public static void main(String[] args) throws RemoteException {
	DriverData driverData = new DriverData();
	DriverPO dpo1 = new DriverPO(025000000, "“∂¡º≥Ω", 2015, 11, 5, 
			"321002000100010000", "88888888888", Sex.MALE, 2015);
	DriverPO dpo2 = new DriverPO(025000001, "’‘»’ÃÏ", 2015, 11, 5, 
			"321002000100010000", "88888888888", Sex.MALE, 2015);
//	driverData.insert(dpo1);
//	driverData.insert(dpo2);
//	driverData.deleteDriverPO(025000001);
	System.out.println(driverData.findsDriverPO().size());
//	System.out.println(driverData.findsDriverPO().get(0).getName() + " "
//			+ driverData.findsDriverPO().get(1).getName());
	System.out.println(driverData.findsDriverPO().get(0).getName());
}
}
