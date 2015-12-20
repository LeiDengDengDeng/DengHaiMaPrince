package src.data.nonUserdata;
import java.rmi.RemoteException;

import src.po.BussinessHallPO;

public class BusinessHallData_Driver {
	public static void main(String[] args) throws RemoteException {
		BusinessHallData businessHallData = new BusinessHallData();
		BussinessHallPO bpo1 = new BussinessHallPO("鼓楼营业厅", "025000",null,null);
		BussinessHallPO bpo2 = new BussinessHallPO("仙林营业厅", "025001",null,null);
//		businessHallData.insert(bpo1);
//		businessHallData.insert(bpo2);
//		businessHallData.deleteBussinessHallPO("025000");
		System.out.println(businessHallData.findsBussinessHallPO().size());
		System.out.println("city： " + businessHallData.findBussinessHallPOByCity("南京").size());
		System.out.println("driver: " + businessHallData.findBussinessHallPOByCity("南京").get(1).getTrucks().size());
		System.out.println(businessHallData.findsBussinessHallPO().get(0).getHallName());
//		System.out.println(businessHallData.findsBussinessHallPO().get(0)
//				.getHallName() + " " + businessHallData.findsBussinessHallPO()
//				.get(1).getHallName());
//		System.out.println(businessHallData.findsBussinessHallPO().get(0)
//				.getHallName());
	}
}
