package src.data.nonUserdata;
import java.rmi.RemoteException;

import src.po.BussinessHallPO;

public class BusinessHallData_Driver {
	public static void main(String[] args) throws RemoteException {
		BusinessHallData businessHallData = new BusinessHallData();
		BussinessHallPO bpo1 = new BussinessHallPO("��¥Ӫҵ��", 025000000);
		BussinessHallPO bpo2 = new BussinessHallPO("����Ӫҵ��", 025000001);
//		businessHallData.insert(bpo1);
//		businessHallData.insert(bpo2);
//		businessHallData.deleteBussinessHallPO("��¥Ӫҵ��");
		System.out.println(businessHallData.findsBussinessHallPO().size());
//		System.out.println(businessHallData.findsBussinessHallPO().get(0)
//				.getHallName() + " " + businessHallData.findsBussinessHallPO()
//				.get(1).getHallName());
		System.out.println(businessHallData.findsBussinessHallPO().get(0)
				.getHallName());
	}
}
