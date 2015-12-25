package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.enums.GoodsType;
import src.po.GoodsPO;
import src.po.StorageInSheetPO;
import src.po.StorageOutSheetPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.SheetVO;
import src.vo.StorageInSheetVO;
import src.vo.StorageInfoVO;
import src.vo.StorageInitVO;
import src.vo.StorageNumVO;
import src.vo.StorageOutSheetVO;

/**
 * 实现库存业务逻辑的接口
 * @author Potter
 *
 */
public class CommodityBLService_Stub implements CommodityBLService{
	
	private StoragePO spo;
	private ArrayList<GoodsPO> gpos;
	LogBLService log;
	GoodsDataService goodsDataService;
	StorageDataService storageDataService;

	public CommodityBLService_Stub(GoodsDataService goodsDataService,
			StorageDataService storageDataService) {
		super();
//		gpos = new ArrayList<>();
//		ArrayList<String> local = new ArrayList<>();
//		local.add("在扬州");
//		GoodsPO gpo = new GoodsPO(local, 1, 1.0, 1.0, 1.0, 1.0, 1.0, 
//				"航空母舰", GoodsType.ECONOMIC, GoodsType.WOODPACKAGE, 
//				0000000000000000, 20151025, "南京", GoodsType.RAIL, 001, 
//				001, 001, 001, "0250201510250000000", 
//				"0250201510250000000");
//		gpos.add(gpo);
//		spo = new StoragePO("南京",1000, 200, 300, 300, 200,
//				0.9,100,100,100,100,gpos);
//		this.log = log;
		this.goodsDataService = goodsDataService;
		this.storageDataService = storageDataService;
	}
	
	public CommodityBLService_Stub(LogBLService log){
		super();
		this.log = log;
	}
	
	public ArrayList<ExpressInfoVO> stockTaking(){
		ArrayList<ExpressInfoVO> expressInfoList = new ArrayList<ExpressInfoVO>();
		for(GoodsPO gPo : gpos){
			System.out.println(gPo.getExpressNumber());
			System.out.println(gPo.getInTime());
			System.out.println(gPo.getDestination());
			System.out.println(gPo.getAreaNumber());
			System.out.println(gPo.getRowNumber());
			System.out.println(gPo.getShelfNumber());
			System.out.println(gPo.getSeatNumber());
//			expressInfoList.add(new ExpressInfoVO(gPo.getExpressNumber(),
//					gPo.getInTime(),gPo.getDestination(),gPo.getAreaNumber(),
//					gPo.getRowNumber(),gPo.getShelfNumber(),gPo.getSeatNumber()));
		}
		return expressInfoList;
	}

	public void exportExcel() {
		System.out.println("Excel已导出");
	}

	public void changeAlarmScale(double alarmScale) {
		spo.setAlarmScale(alarmScale);
	}

	public ArrayList<StorageInfoVO> checkStorageMessage(long startTime,long endTime) {
		ArrayList<StorageInfoVO> storageInfoList = new ArrayList<StorageInfoVO>();
		for(GoodsPO gPo : gpos){
			System.out.println(gPo.getAreaNumber());
			System.out.println(gPo.getRowNumber());
			System.out.println(gPo.getSeatNumber());
			System.out.println(gPo.getShelfNumber());
//			storageInfoList.add(new StorageInfoVO(gPo.getAreaNumber(),
//					gPo.getRowNumber(),gPo.getShelfNumber(),gPo.getSeatNumber()));
		}
		return storageInfoList;
	}
	
	public StorageNumVO getStorageNum(long startTime,long endTime) {
		//TODO 设定时间段返回出入库数量
		StorageNumVO svo = new StorageNumVO(20, 30, 300);
		return svo;
	}

	public boolean alarm() {
//		if(spo.getShippingNumber() > (spo.getShippingEnd() - 
//				spo.getShippingStart())*spo.getAlarmScale()){
//			System.out.println("航运区库存溢出啦");
//		}
//		
//		if(spo.getRailNumber() > (spo.getRailEnd() - 
//				spo.getRailStart())*spo.getAlarmScale()){
//			System.out.println("铁运区库存溢出啦");
//		}
//		
//		if(spo.getTransportNumber() > (spo.getTransportEnd() - 
//				spo.getTransportStart())*spo.getAlarmScale()){
//			System.out.println("汽运区库存溢出啦");
//		}
//		
//		if(spo.getFlxibleNumber() > (spo.getFlxibleEnd() - 
//				spo.getFlxibleStart())*spo.getAlarmScale()){
//			System.out.println("机动区库存溢出啦");
//		}
	return true;
	}

	public void divide(GoodsPO gpo, StoragePO spo) {
		//TODO 手动调整分区信息
		System.out.println("分区已调整");
	}

	public void endCommodityManagement() {
		System.out.println("End the commoditymanagement!");
		
	}

	public void changeStorageInInfo(SheetVO svo) {
		System.out.println("库存信息已修改");
	}

	public void initStorageInfo(ArrayList<StorageInitVO> svolist) {
		System.out.println("库存信息已初始化");
	}

	@Override
	public ArrayList<ExpressInfoVO> stockTaking(String storageId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void exportExcel(String storageId) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void changeAlarmScale(double alarmScale, String storageId) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public ArrayList<StorageInfoVO> checkStorageMessage(String storageId,
			long startTime, long endTime) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StorageNumVO getStorageNum(String storageId, long startTime,
			long endTime) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public AlarmMessage alarm(String storageId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<ExpressInfoVO> getAreaGoodsPOs(String storageId,
			GoodsType areaNumber) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void divide(String storageId, ArrayList<ExpressInfoVO> evos) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void changeStorageInInfo(String storageId, SheetVO svo) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public double getAlarmScale(String storageId) {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
