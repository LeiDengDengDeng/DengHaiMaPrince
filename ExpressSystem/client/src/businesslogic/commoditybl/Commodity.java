package src.businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import src.enums.SheetType;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.po.GoodsPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.SheetVO;
import src.vo.StorageInSheetVO;
import src.vo.StorageInfoVO;
import src.vo.StorageInitVO;
import src.vo.StorageNumVO;

public class Commodity implements CommodityBLService{
	
	LogBLService log;
	GoodsDataService goodsDataService;
	StorageDataService storageDataService;
	

	public Commodity(GoodsDataService goodsDataService,
			StorageDataService storageDataService) {
		super();
		this.goodsDataService = goodsDataService;
		this.storageDataService = storageDataService;
	}

	@Override
	public ArrayList<ExpressInfoVO> stockTaking(String storageId) {
		StoragePO spo = null;
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		ArrayList<ExpressInfoVO> evos = new ArrayList<ExpressInfoVO>();
		Date dt=new Date();     
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMdd");
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		gpos = spo.getGpos();
		int i = 0;
		while(gpos.get(i) != null){
			//判断是否是当天入库
			if(matter1.format(dt).equals(gpos.get(i).getInTime() + "")){
				evos.add(new ExpressInfoVO(gpos.get(i).getGoodsName(),gpos.get(i).getExpressNumber(), 
						gpos.get(i).getInTime(), gpos.get(i).getDestination(), 
						gpos.get(i).getAreaNumber(), gpos.get(i).getRowNumber(),
						gpos.get(i).getShelfNumber(), gpos.get(i).getSeatNumber(),false));
			}
			i++;
		}
		return evos;
	}

	@Override
	public void exportExcel(String storageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeAlarmScale(double alarmScale,String storageId) {
		StoragePO spo = null;
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		gpos = spo.getGpos();
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		spo.setAlarmScale(alarmScale);
		try {
			storageDataService.update(storageId,spo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<StorageInfoVO> checkStorageMessage(String storageId,long startTime, long endTime) {
		ArrayList<StorageInfoVO> svos = new ArrayList<StorageInfoVO>();
		StoragePO spo = null;
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		gpos = spo.getGpos();
		int i = 0;
		while(gpos.get(i) != null){
			//判断是否在指定时间内
			if((gpos.get(i).getInTime() >= startTime) && 
					(gpos.get(i).getInTime() <= endTime)){
				svos.add(new StorageInfoVO(gpos.get(i).getGoodsName(),gpos.get(i).getAreaNumber(), 
						gpos.get(i).getRowNumber(), gpos.get(i).getShelfNumber(),
						gpos.get(i).getSeatNumber()));
			}
			i++;
		}
		return svos;
	}

	@Override
	public StorageNumVO getStorageNum(String storageId,long startTime, long endTime) {
		int inNum = 0;
		int outNum = 0;
		StoragePO spo = null;
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		gpos = spo.getGpos();
		int i = 0;
		while(gpos.get(i) != null){
			//判断是否在指定时间内
			if((gpos.get(i).getInTime() >= startTime) && 
					(gpos.get(i).getInTime() <= endTime)){
				inNum++;
			}
			i++;
		}
		//TODO outNum
		StorageNumVO svo = new StorageNumVO(inNum, outNum, 
				spo.getStorageNumber());
		return svo;
	}

	@Override
	public AlarmMessage alarm(String storageId){
		AlarmMessage am = null;
		StoragePO spo = null;
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		boolean shipping = spo.getShippingNumber() > spo.getShippingSize()
				*spo.getAlarmScale();
		boolean rail = spo.getRailNumber() > spo.getRailSize()
				*spo.getAlarmScale();
		boolean transport = spo.getTransportNumber() > spo.getTransportSize()
				*spo.getAlarmScale();
		if(shipping){
			if(rail){
				if(transport){
					am = AlarmMessage.SRT;
				}
				else{
					am = AlarmMessage.SR;
				}
			}
			else if(transport){
				am = AlarmMessage.ST;
			}
			else{
				am = AlarmMessage.SHIPPING;
			}
		}
		else if(rail){
			if(transport){
				am = AlarmMessage.RT;
			}
			else{
				am = AlarmMessage.RAIL;
			}
		}
		else if(transport){
			am = AlarmMessage.TRANSPORT;
		}
		else{
			am = AlarmMessage.OK;
		}
		return am;
	}
	
	@Override
	public ArrayList<ExpressInfoVO> getAreaGoodsPOs(String storageId,GoodsType areaNumber) {
		ArrayList<ExpressInfoVO> evos = new ArrayList<ExpressInfoVO>();
		StoragePO spo = null;
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		gpos = spo.getGpos();
		int i = 0;
		while(gpos.get(i) != null){
			if(gpos.get(i).getAreaNumber() == areaNumber){
				evos.add(new ExpressInfoVO(gpos.get(i).getGoodsName(),gpos.get(i).getExpressNumber(), 
						gpos.get(i).getInTime(), gpos.get(i).getDestination(), 
						gpos.get(i).getAreaNumber(), gpos.get(i).getRowNumber(),
						gpos.get(i).getShelfNumber(), gpos.get(i).getSeatNumber(),
						false));
			}
			i++;
		}
		return evos;
	}

	@Override
	public void divide(String storageId,ArrayList<ExpressInfoVO> evos) {
		StoragePO spo = null;
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		gpos = spo.getGpos();
		int i = 0;
		int j = 0;
		while(evos.get(i) != null){
			if(evos.get(i).isFlxible() == true){
				while(gpos.get(j) != null){
					if(gpos.get(j).getExpressNumber() == 
							evos.get(i).getExpressNumber()){
						gpos.get(j).setAreaNumber(GoodsType.FLXIBLE);
					}
				}
				j++;
			}
			i++;
		}
		try {
			storageDataService.update(storageId, spo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endCommodityManagement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStorageInInfo(String storageId,SheetVO svo) {
		if(svo.getType() == SheetType.STORAGE_IN_SHEET){
			StorageInSheetVO sivo = (StorageInSheetVO)svo;
			
		}
		
	}

	@Override
	public void initStorageInfo(ArrayList<StorageInitVO> svolist) {
		StoragePO spo = null;
		int i = 0;
		while(svolist.get(i) != null){
			spo = new StoragePO(svolist.get(i).getStorageId(), 
					0, 0, 0, 0, 0, svolist.get(i).getAlarmScale(), 
					svolist.get(i).getShippingSize(), 
					svolist.get(i).getRailSize(),
					svolist.get(i).getTransportSize(),
					svolist.get(i).getFlxibleSize(), null);
			try {
				storageDataService.insert(spo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			i++;
		}
	}


}
