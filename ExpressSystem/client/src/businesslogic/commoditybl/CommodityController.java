package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.enums.GoodsType;
import src.po.GoodsPO;
import src.po.StorageInSheetPO;
import src.po.StorageOutSheetPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.GoodsVO;
import src.vo.SheetVO;
import src.vo.StorageInSheetVO;
import src.vo.StorageInfoVO;
import src.vo.StorageInitVO;
import src.vo.StorageNumVO;

/**
 * 隔离业务逻辑职责和逻辑控制职责的控制类
 * @author Potter
 *
 */
public class CommodityController implements CommodityBLService{
	
	LogBLService log;
	
	CommodityBLService_Stub cs = new CommodityBLService_Stub(log);

	
	public ArrayList<ExpressInfoVO> stockTaking() {
		return cs.stockTaking();
	}

	public void exportExcel(String realPath,ArrayList<ExpressInfoVO> users) {
		cs.exportExcel(realPath,users);
	}

	public void changeAlarmScale(double alarmScale) {
		cs.changeAlarmScale(alarmScale);
	}

	public ArrayList<StorageInfoVO> checkStorageMessage(long startTime,long endTime) {
		return cs.checkStorageMessage(startTime,endTime);
	}

	public StorageNumVO getStorageNum(long startTime, long endTime) {
		return cs.getStorageNum(startTime, endTime);
	}

	public boolean alarm() {
		return cs.alarm();
	}

	public void divide(GoodsPO gpo, StoragePO spo) {
		cs.divide(gpo, spo);
	}

	public void endCommodityManagement() {
		cs.endCommodityManagement();
	}

	public void changeStorageInInfo(SheetVO svo) {
		cs.changeStorageInInfo(svo);
	}

	public void initStorageInfo(ArrayList<StorageInitVO> svolist) {
		cs.initStorageInfo(svolist);
	}

	@Override
	public ArrayList<ExpressInfoVO> stockTaking(String storageId) {
		// TODO 自动生成的方法存根
		return null;
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

	

	@Override
	public void changeGoodInfo(GoodsVO gvo) {
		// TODO Auto-generated method stub
		
	}


	

}
