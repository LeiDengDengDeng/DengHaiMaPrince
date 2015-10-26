package src.data.nonUserdata;

import java.rmi.RemoteException;

import src.dataservice.nonUserdataservice.NonUserDataService;
import src.po.DriverPO;
import src.po.TruckPO;

public class NonUserData_Stub implements NonUserDataService{

	@Override
	public TruckPO findTruckPO(long id) throws RemoteException {
		System.out.println("�ɹ��ҵ�TruckPO!");
		TruckPO tpo = new TruckPO(025000000, 10, "��A 00000");
		return tpo;
	}

	@Override
	public DriverPO finDriverPO(long id) throws RemoteException {
		System.out.println("�ɹ��ҵ�DriverPO!");
		DriverPO dpo = new DriverPO(025000000, "Ҷ����", 2015, 10, 26, "321002201510268888", "1318889999", 2015);
		return dpo;
	}

	@Override
	public void finish() throws RemoteException {
		System.out.println("�ɹ�����commodity����ʹ��!");
		
	}

}
