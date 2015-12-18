package src.data.nonUserdata;
import java.rmi.RemoteException;

import src.po.TruckPO;

public class TruckData_Driver {
	public static void main(String[] args) throws RemoteException {
		TruckData truckData = new TruckData();
		TruckPO tpo1 = new TruckPO("025000000", 10, "ËÕA00000");
		TruckPO tpo2 = new TruckPO("025000001", 10, "ËÕA00001");
//		truckData.insert(tpo1);
//		truckData.insert(tpo2);
//		truckData.deleteTruckPO(025000000);
		System.out.println(truckData.findsTruckPO().size());
//		System.out.println(truckData.findsTruckPO().get(0).getLicensePlateNum() 
//				+ " " + truckData.findsTruckPO().get(1).getLicensePlateNum());
		System.out.println(truckData.findsTruckPO().get(0).getLicensePlateNum());
		System.out.println("ÓªÒµÌü£º " + truckData.findsTruckPO("025000").size());
	}

}
