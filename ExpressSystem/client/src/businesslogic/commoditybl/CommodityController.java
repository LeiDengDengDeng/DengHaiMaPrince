package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.commodityblservice.SheetVO;
import src.businesslogicservice.logblservice.LogBLService;
import src.po.GoodsPO;
import src.po.StorageInSheetPO;
import src.po.StorageOutSheetPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.StorageInSheetVO;
import src.vo.StorageInfoVO;
import src.vo.StorageNumVO;
import src.vo.StorageOutSheetVO;

/**
 * ����ҵ���߼�ְ����߼�����ְ��Ŀ�����
 * @author Potter
 *
 */
public class CommodityController implements CommodityBLService{
	
	LogBLService log;
	
	CommodityBLService_Stub cs = new CommodityBLService_Stub(log);

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
	public void alarm() {
		cs.alarm();
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
	public void changeLogisticsState(String logisticsState) {
		cs.changeLogisticsState(logisticsState);
	}

	@Override
	public void changeStorageInfo(SheetVO svo) {
		cs.changeStorageInfo(svo);
	}

	@Override
	public void initStorageInfo(StoragePO spo) {
		cs.initStorageInfo(spo);
	}
	

}
