package src.data.nonUserdata;
import java.rmi.RemoteException;

import src.po.BussinessHallPO;

public class BusinessHallData_Driver {
	public static void main(String[] args) throws RemoteException {
		BusinessHallData businessHallData = new BusinessHallData();
		BussinessHallPO bpo1 = new BussinessHallPO("���Ӫҵ��", "020000",null,null);
		BussinessHallPO bpo2 = new BussinessHallPO("����Ӫҵ��", "020001",null,null);
//		businessHallData.insert(bpo1);
//		businessHallData.insert(bpo2);
//		businessHallData.deleteBussinessHallPO("010004");
//		System.out.println(businessHallData.findsBussinessHallPO().size());
		System.out.println("city�� " + businessHallData.findBussinessHallPOByCity("����").size());
//		System.out.println("driver: " + businessHallData.findBussinessHallPOByCity("����").get(1).getTrucks().size());
//		System.out.println(businessHallData.findsBussinessHallPO().get(0).getHallName());
//		System.out.println(businessHallData.findsBussinessHallPO().get(0)
//				.getHallName() + " " + businessHallData.findsBussinessHallPO()
//				.get(1).getHallName());
//		System.out.println(businessHallData.findsBussinessHallPO().get(0)
//				.getHallName());
	}
}
