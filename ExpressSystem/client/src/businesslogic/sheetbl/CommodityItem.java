package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.loginbl.LogIn;
import src.vo.GoodsVO;
import src.vo.SheetVO;

public class CommodityItem {
	Commodity commodity;
	
	public CommodityItem(Commodity commodity){
		this.commodity = commodity;
	}
	
	public void updateGoods(GoodsVO goods){
		commodity.changeGoodInfo(goods);
	}
	
	public void updateCommodity(SheetVO sheet){
		commodity.changeStorageInInfo(LogIn.currentUser.getCity(), sheet);
	}

}
