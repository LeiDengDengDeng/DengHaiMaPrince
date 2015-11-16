package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.vo.SheetVO;

public class SheetBLService_Stub implements SheetBLService {

	LogBLService log;
	AccountBLService account;
	CommodityBLService commodity;
	
	public SheetBLService_Stub(LogBLService log,AccountBLService account,CommodityBLService commodity){
		this.log = log;
		this.account = account;
		this.commodity = commodity;
	}
	
	@Override
	public SheetVO checkSheet(long ID) {
		// TODO 自动生成的方法存根
		System.out.println("你在查看表格！");
		return null;
	}

	@Override
	public void examineSheet(long ID,boolean passed) {
		// TODO 自动生成的方法存根
		System.out.println("你在审批表格！");
		log.generateLog("总经理", "小王子", "审批表格");
	}

//	@Override
//	public SheetVO fillSheet(SheetType type, long ID) {
//		// TODO 自动生成的方法存根
//		if (ID == 00001)
//			System.out.println("你在填写已有的表格！表格ID为:" + ID);
//		else {
//			System.out.print("你在新建表格！新建表格ID为:" + ID + "---");
//			switch (type) {
//			case ORDER_SHEET:
//				System.out.println("新建表格类型为寄件单");
//				log.generateLog("快递员", "张三", "填写寄件单");
//				break;
//			case PAYMENT_SHEET:
//				break;
//			case STORAGE_IN_SHEET:
//				break;
//			case STORAGE_OUT_SHEET:
//				break;
//			default:
//				break;
//			}
//		}
//		return null;
//	}

//	@Override
//	public boolean isLegal(SheetInfoType type, Object info) {
//		// TODO 自动生成的方法存根
//		System.out.print("正在检测信息是否合法！---");
//		if (type == SheetInfoType.COURIER_NUMBER) {
//			if (((String) info).toCharArray().length == 10) {
//				System.out.println("快递物流编号信息合法");
//				return true;
//			} else
//				System.out.println("快递物流编号信息不合法");
//		}
//		return false;
//	}
//
	@Override
	public boolean confirmSheet(SheetVO sheet, SheetType type) {
		// TODO 自动生成的方法存根
		System.out.print("提交单据");
		return true;
	}

	@Override
	public void formulateConstant(ArrayList<Double> distant, double price) {
		// TODO 自动生成的方法存根
		System.out.println("你正在制定常量！");
		System.out.println("距离常量值为：" + distant.get(0) + "公里");
		System.out.println("价格常量值为：" + price + "元/公里");
		log.generateLog("总经理", "小王子", "制定常量");
	}

}
