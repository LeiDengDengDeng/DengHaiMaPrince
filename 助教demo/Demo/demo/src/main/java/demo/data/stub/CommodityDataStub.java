package demo.data.stub;

import demo.dataservice.CommodityDataService;
import demo.po.CommodityPO;

public class CommodityDataStub implements CommodityDataService {

	public CommodityPO find(String no) {
		// TODO Auto-generated method stub
		if(no.equals("001001")){
			return new CommodityPO("001001","台灯001", "台灯", 10.0, 15.0, false);	
		}
		else if(no.equals("002001")){
			return new CommodityPO("002001","日光灯001", "日光灯", 8.5, 11.5, false);
		}
		else{
			return null;
		}
	}
	 
}
