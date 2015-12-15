package src.data.commoditydata;
import java.rmi.RemoteException;

import src.po.StoragePO;

public class StorageData_Driver {

	public static void main(String[] args) throws RemoteException {
		StorageData storageData = new StorageData();
		StoragePO spo1 = new StoragePO("南京", 1000, 200, 200, 200, 200, 0.9, 250, 250, 
				250, 250, null);
		StoragePO spo2 = new StoragePO("上海", 1000, 200, 200, 200, 200, 0.9, 250, 250, 
				250, 250, null);
		storageData.insert(spo1);
		storageData.insert(spo2);
		storageData.delete("上海");
//		storageData.update("南京", spo2);
//		System.out.println(storageData.finds().size());
//		System.out.println(storageData.finds().get(0).getCity() + " "
//				+ storageData.finds().get(1).getCity());
//		System.out.println(storageData.finds().get(0).getCity());
	}
}
