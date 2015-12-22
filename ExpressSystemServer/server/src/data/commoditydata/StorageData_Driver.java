package src.data.commoditydata;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.enums.GoodsType;
import src.po.GoodsPO;
import src.po.StoragePO;

public class StorageData_Driver {

	public static void main(String[] args) throws RemoteException {
		StorageData storageData = new StorageData();
		ArrayList<String> logisticsState = new ArrayList<String>();
		logisticsState.add("南京到扬州");
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		GoodsPO goodsPO1 = new GoodsPO(logisticsState, 3, 3.0, 3.0, 3.0, 
				3.0, 3.0, "血吼", GoodsType.ECONOMIC, GoodsType.PAPERPAKAGE,
				"0000000000000001", "2015-12-20", "扬州", GoodsType.RAIL, 103, 103, 103, 
				001, "0250201510250000000", 
				"0250201510250000000");
		GoodsPO goodsPO2 = new GoodsPO(logisticsState, 3, 3.0, 3.0, 3.0, 
				3.0, 3.0, "灰烬使者", GoodsType.ECONOMIC, GoodsType.PAPERPAKAGE,
				"0000000000000000", "2015-12-20", "扬州", GoodsType.RAIL, 003, 003, 003, 
				001, "0250201510250000000",
				"0250201510250000000");
		gpos.add(goodsPO1);
		gpos.add(goodsPO2);
		StoragePO spo1 = new StoragePO("南京", 1000, 200, 200, 200, 200, 0.9, 250, 250, 
				250, 250, gpos);
		StoragePO spo2 = new StoragePO("上海", 1000, 200, 200, 200, 200, 0.9, 250, 250, 
				250, 250, gpos);
//		storageData.insert(spo1);
//		storageData.insert(spo2);
//		storageData.delete("上海");
//		storageData.update("南京", spo2);
		System.out.println(storageData.finds().size());
//		System.out.println(storageData.finds().get(0).getCity() + " "
//				+ storageData.finds().get(1).getCity());
		System.out.println(storageData.findStoragePO("南京").getAlarmScale());
		System.out.println(storageData.finds().get(0).getCity());
	}
}
