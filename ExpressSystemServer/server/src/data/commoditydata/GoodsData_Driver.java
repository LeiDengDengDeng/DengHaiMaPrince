package src.data.commoditydata;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.enums.GoodsType;
import src.po.GoodsPO;

public class GoodsData_Driver {

	public static void main(String[] args) throws RemoteException {
		GoodsData goodsData = new GoodsData();
		ArrayList<String> logisticsState = new ArrayList<String>();
		logisticsState.add("南京到扬州");
		GoodsPO goodsPO1 = new GoodsPO(logisticsState, 3, 3.0, 3.0, 3.0, 
				3.0, 3.0, "血吼", GoodsType.ECONOMIC, GoodsType.PAPERPAKAGE,
				"0000000000000001", "20151215", "扬州", GoodsType.RAIL, 003, 003, 003, 
				001, "0250201510250000000", 
				"0250201510250000000");
		GoodsPO goodsPO2 = new GoodsPO(logisticsState, 3, 3.0, 3.0, 3.0, 
				3.0, 3.0, "灰烬使者", GoodsType.ECONOMIC, GoodsType.PAPERPAKAGE,
				"0000000000000000", "20151215", "扬州", GoodsType.RAIL, 003, 003, 003, 
				001, "0250201510250000000",
				"0250201510250000000");
//		goodsData.insert(goodsPO1);
//		goodsData.insert(goodsPO2);
//		goodsData.delete(0000000000000001);
//		goodsData.update(goodsPO2);
		System.out.println(goodsData.finds().size());
		System.out.println(goodsData.finds(GoodsType.RAIL).get(0).getGoodsName()
				+ " " + goodsData.finds(GoodsType.RAIL).get(1).getGoodsName());
		
	}
}
