package src.data.nonUserdata;
import java.rmi.RemoteException;

import src.po.IntermediateCenterPO;

public class IntermediateCenterData_Driver {
	public static void main(String[] args) throws RemoteException {
		IntermediateCenterData intermediateCenterData = new IntermediateCenterData();
		IntermediateCenterPO ipo1 = new IntermediateCenterPO("�Ͼ�", null, null);
		IntermediateCenterPO ipo2 = new IntermediateCenterPO("�Ϻ�", null, null);
//		intermediateCenterData.insert(ipo1);
//		intermediateCenterData.insert(ipo2);
//		intermediateCenterData.deleteIntermediateCenterPO("�Ϻ�");
//		System.out.println(intermediateCenterData.findsIntermediateCenterPO()
//				.get(0).getCity() + " " + intermediateCenterData.findsIntermediateCenterPO()
//				.get(1).getCity());
//		System.out.println(intermediateCenterData.findsIntermediateCenterPO()
//				.get(0).getCity());
	}

}
