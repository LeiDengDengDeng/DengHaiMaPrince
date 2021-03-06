package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.vo.SheetVO;
import src.vo.StorageInitVO;

public class MockCommodity extends Commodity{

	public MockCommodity(Log log,String storageId) {
		super(log);
	}
	
	public String getStorageId() {
		return "艾泽拉斯";
	}
	
	public void changeStorageInInfo(ArrayList<SheetVO> svolist) {
		System.out.println("已收到库存信息");
	}
	
	public void initStorageInfo(StorageInitVO sivo) {
		System.out.println("库存信息已初始化");
	}

}
