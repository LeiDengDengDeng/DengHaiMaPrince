package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.po.GoodsPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.SheetVO;
import src.vo.StorageInfoVO;
import src.vo.StorageInitVO;
import src.vo.StorageNumVO;

public class Commodity implements CommodityBLService{
	
	private StoragePO spo;
	private ArrayList<GoodsPO> gpos;
	LogBLService log;

	public Commodity(LogBLService log) {
		super();
		gpos = new ArrayList<>();
		ArrayList<String> local = new ArrayList<>();
		local.add("在扬州");
		GoodsPO gpo = new GoodsPO(local, 1, 1.0, 1.0, 1.0, 1.0, 1.0, 
				"航空母舰", GoodsType.ECONOMIC, GoodsType.WOODPACKAGE, 
				0000000000000000, 20151025, "南京", GoodsType.RAIL, 001, 
				001, 001, 001, "0250201510250000000", 
				"0250201510250000000");
		gpos.add(gpo);
		spo = new StoragePO(100, 100, 1000, 200, 300, 300, 200,
				0.9, 1, 200, 201, 500, 501, 800, 801, 1000, gpos);
		this.log = log;
	}

	@Override
	public String getStorageId() {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<ExpressInfoVO> stockTaking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeAlarmScale(double alarmScale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<StorageInfoVO> checkStorageMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StorageNumVO getStorageNum(long startTime, long endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alarm() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void divide(GoodsPO gpo, StoragePO spo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endCommodityManagement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStorageInInfo(ArrayList<SheetVO> svolist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initStorageInfo(StorageInitVO sivo) {
		// TODO Auto-generated method stub
		
	}

}
