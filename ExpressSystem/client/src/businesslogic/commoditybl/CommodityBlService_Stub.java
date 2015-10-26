package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBlService;
import src.po.GoodsPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.StorageInfoVO;

/**
 * 实现库存业务逻辑的接口
 * @author Potter
 *
 */
public class CommodityBlService_Stub implements CommodityBlService{
	
	private StoragePO spo;
	private ArrayList<GoodsPO> gpos;

	public CommodityBlService_Stub(StoragePO spo, ArrayList<GoodsPO> gpos) {
		super();
		this.spo = spo;
		this.gpos = gpos;
	}

	@Override
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
			expressInfoList.add(new ExpressInfoVO(gPo.getExpressNumber(),
					gPo.getInTime(),gPo.getDestination(),gPo.getAreaNumber(),
					gPo.getRowNumber(),gPo.getShelfNumber(),gPo.getSeatNumber()));
		}
		return expressInfoList;
	}

	@Override
	public void exportExcel() {
		System.out.println("Excel已导出");
	}

	@Override
	public void changeAlarmScale(double alarmScale) {
		spo.setAlarmScale(alarmScale);
	}

	@Override
	public ArrayList<StorageInfoVO> checkStorageMessage() {
		ArrayList<StorageInfoVO> storageInfoList = new ArrayList<StorageInfoVO>();
		for(GoodsPO gPo : gpos){
			System.out.println(gPo.getAreaNumber());
			System.out.println(gPo.getRowNumber());
			System.out.println(gPo.getSeatNumber());
			System.out.println(gPo.getShelfNumber());
			storageInfoList.add(new StorageInfoVO(gPo.getAreaNumber(),
					gPo.getRowNumber(),gPo.getShelfNumber(),gPo.getSeatNumber()));
		}
		return storageInfoList;
	}
	
	@Override
	public StoragePO getStorageNum(long startTime,long endTime) {
		//TODO 设定时间段返回出入库数量
		return spo;
	}

	@Override
	public void alarm() {
		if(spo.getShippingNumber() > (spo.getShippingEnd() - 
				spo.getShippingStart())*spo.getAlarmScale()){
			System.out.println("航运区库存溢出啦");
		}
		
		if(spo.getRailNumber() > (spo.getRailEnd() - 
				spo.getRailStart())*spo.getAlarmScale()){
			System.out.println("铁运区库存溢出啦");
		}
		
		if(spo.getTransportNumber() > (spo.getTransportEnd() - 
				spo.getTransportStart())*spo.getAlarmScale()){
			System.out.println("汽运区库存溢出啦");
		}
		
		if(spo.getFlxibleNumber() > (spo.getFlxibleEnd() - 
				spo.getFlxibleStart())*spo.getAlarmScale()){
			System.out.println("机动区库存溢出啦");
		}
	
	}

	@Override
	public void divide(GoodsPO gpo, StoragePO spo) {
		//TODO 手动调整分区信息
		System.out.println("分区已调整");
	}


}
