package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.commodityblservice.SheetVO;
import src.businesslogicservice.commodityblservice.StorageInitVO;
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
 * ʵ�ֿ��ҵ���߼��Ľӿ�
 * @author Potter
 *
 */
public class CommodityBLService_Stub implements CommodityBLService{
	
	private StoragePO spo;
	private ArrayList<GoodsPO> gpos;
	LogBLService log;

	public CommodityBLService_Stub(LogBLService log) {
		super();
		gpos = new ArrayList<>();
		ArrayList<String> local = new ArrayList<>();
		local.add("������");
		GoodsPO gpo = new GoodsPO(local, 1, 1.0, 1.0, 1.0, 1.0, 1.0, 
				"����ĸ��", GoodsType.ECONOMIC, GoodsType.WOODPACKAGE, 
				0000000000000000, 20151025, "�Ͼ�", GoodsType.RAIL, 001, 
				001, 001, 001, "0250201510250000000", 
				"0250201510250000000");
		gpos.add(gpo);
		spo = new StoragePO(100, 100, 1000, 200, 300, 300, 200,
				0.9, 1, 200, 201, 500, 501, 800, 801, 1000, gpos);
		this.log = log;
	}

	@Override
	public void getStorageId() {
		
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
		System.out.println("Excel�ѵ���");
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
	public StorageNumVO getStorageNum(long startTime,long endTime) {
		//TODO �趨ʱ��η��س��������
		StorageNumVO svo = new StorageNumVO(20, 30, 300);
		return svo;
	}

	@Override
	public boolean alarm() {
		if(spo.getShippingNumber() > (spo.getShippingEnd() - 
				spo.getShippingStart())*spo.getAlarmScale()){
			System.out.println("��������������");
		}
		
		if(spo.getRailNumber() > (spo.getRailEnd() - 
				spo.getRailStart())*spo.getAlarmScale()){
			System.out.println("��������������");
		}
		
		if(spo.getTransportNumber() > (spo.getTransportEnd() - 
				spo.getTransportStart())*spo.getAlarmScale()){
			System.out.println("��������������");
		}
		
		if(spo.getFlxibleNumber() > (spo.getFlxibleEnd() - 
				spo.getFlxibleStart())*spo.getAlarmScale()){
			System.out.println("��������������");
		}
	
	}

	@Override
	public void divide(GoodsPO gpo, StoragePO spo) {
		//TODO �ֶ�����������Ϣ
		System.out.println("�����ѵ���");
	}

	@Override
	public void endCommodityManagement() {
		System.out.println("End the commoditymanagement!");
		
	}

	@Override
	public void changeStorageInInfo(ArrayList<SheetVO> svolist) {
		System.out.println("�����Ϣ���޸�");
	}

	@Override
	public void initStorageInfo(StorageInitVO sivo) {
		System.out.println("�����Ϣ�ѳ�ʼ��");
	}

}
