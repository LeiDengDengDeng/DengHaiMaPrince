package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Commodity;
import src.vo.SheetVO;

public class CommodityItem {
	Commodity commodity;
	
	public CommodityItem(Commodity commodity){
		this.commodity = commodity;
	}
	
	public void updateCommodity(SheetVO sheet){
//		commodity.changeStorageInInfo(svolist);
	}

}
