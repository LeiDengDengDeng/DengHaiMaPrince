package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.po.GoodsPO;
import src.po.StoragePO;

/**
 * 库存业务逻辑接口的上层驱动
 * @author Potter
 *
 */
public class CommodityBLService_Driver {
	
	private GoodsPO gpo;
	private StoragePO spo;
	
	public void drive(CommodityBLService commodityBLService){
		
		ArrayList<String> local = new ArrayList<>();
		local.add("在扬州");
		gpo  = new GoodsPO(local, 1, 1.0, 1.0, 1.0, 1.0, 1.0, 
				"航空母舰", GoodsType.ECONOMIC, GoodsType.WOODPACKAGE, 
				0000000000000000, 20151025, "南京", GoodsType.RAIL, 001, 
				001, 001, 001, "0250201510250000000", 
				"0250201510250000000");
		
		ArrayList<GoodsPO> gposList = new ArrayList<>();
		gposList.add(gpo);
		spo = new StoragePO("南京",1000, 200, 300, 300, 200,
				0.9,100,100,100,100,gposList);
		//库存盘点
		commodityBLService.stockTaking();
		
		//导出excel
		commodityBLService.exportExcel();
		
		//修改警戒比例
		commodityBLService.changeAlarmScale(0.9);
		
		//库存信息查看
		commodityBLService.checkStorageMessage(20151010, 20151026);
		commodityBLService.getStorageNum(20151010, 20151026);
		
		//库存报警
		commodityBLService.alarm();
		
		//库存分区
		commodityBLService.divide(gpo, spo);
		
		//关闭任务
		commodityBLService.endCommodityManagement();
	}

}
