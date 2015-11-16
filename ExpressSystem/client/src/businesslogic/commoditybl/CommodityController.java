package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.logblservice.LogBLService;
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

/**
 * 隔离业务逻辑职责和逻辑控制职责的控制类
 * @author Potter
 *
 */
public class CommodityController implements CommodityBLService{
	
	LogBLService log;
	
	CommodityBLService_Stub cs = new CommodityBLService_Stub(log);

	@Override
	public String getStorageId() {
		return cs.getStorageId();
	}
	
	@Override
	public ArrayList<ExpressInfoVO> stockTaking() {
		return cs.stockTaking();
	}

	@Override
	public void exportExcel() {
		cs.exportExcel();
	}

	@Override
	public void changeAlarmScale(double alarmScale) {
		cs.changeAlarmScale(alarmScale);
	}

	@Override
	public ArrayList<StorageInfoVO> checkStorageMessage() {
		return cs.checkStorageMessage();
	}

	@Override
	public StorageNumVO getStorageNum(long startTime, long endTime) {
		return cs.getStorageNum(startTime, endTime);
	}

	@Override
	public boolean alarm() {
		return cs.alarm();
	}

	@Override
	public void divide(GoodsPO gpo, StoragePO spo) {
		cs.divide(gpo, spo);
	}

	@Override
	public void endCommodityManagement() {
		cs.endCommodityManagement();
	}

	@Override
	public void changeStorageInInfo(ArrayList<SheetVO> svolist) {
		cs.changeStorageInInfo(svolist);
	}

	@Override
	public void initStorageInfo(ArrayList<StorageInitVO> svolist) {
		cs.initStorageInfo(svolist);
	}

	

}
