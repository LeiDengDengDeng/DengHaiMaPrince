package src.businesslogic.commoditybl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import src.enums.GoodsType;
import src.enums.SheetType;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.accountdataservice.AccountDataService;
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
import src.vo.StorageOutSheetVO;

public class Commodity implements CommodityBLService{
	
	Log log;
	GoodsDataService goodsDataService;
	StorageDataService storageDataService;
	

	public Commodity(Log log) {
		super();
		try {
			goodsDataService =(GoodsDataService) Naming.lookup("rmi://127.0.0.1:6600/goodsData");
			storageDataService = (StorageDataService) Naming.lookup("rmi://127.0.0.1:6600/storageData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ExpressInfoVO> stockTaking(String storageId) {
		StoragePO spo = null;
		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		ArrayList<ExpressInfoVO> evos = new ArrayList<ExpressInfoVO>();
		Date dt=new Date();     
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		gpos = spo.getGpos();
//		System.out.println(gpos.size());
		for(int i = 0;i < gpos.size();i++){
			//判断是否是当天入库
//			System.out.println(matter1.format(dt));
//			System.out.println(gpos.get(i).getInTime());
//			System.out.println(matter1.format(dt).equals(gpos.get(i).getInTime() + ""));
			if(matter1.format(dt).equals(gpos.get(i).getInTime() + "")){
				evos.add(new ExpressInfoVO(gpos.get(i).getGoodsName(),gpos.get(i).getExpressNumber(), 
						gpos.get(i).getInTime(), gpos.get(i).getDestination(), 
						gpos.get(i).getAreaNumber(), gpos.get(i).getRowNumber(),
						gpos.get(i).getShelfNumber(), gpos.get(i).getSeatNumber(),false));
			}
		}
//		System.out.println("esize: " + evos.size());
		return evos;
	}

	@Override
	public void exportExcel(String realPath,ArrayList<ExpressInfoVO> users) {
		FileOutputStream fos; 
		try { File file=new File(realPath); 
		fos = new FileOutputStream(file, true);
		HSSFWorkbook wb = new HSSFWorkbook(); 
		HSSFSheet s=wb.createSheet(); 
//		wb.setSheetName(0, sheetname);
		HSSFRow row = s.createRow((int)0);
		//创建单元格，并设置值表头  设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //创建一个居中格式
        
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("内件品名"); cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("快递编号"); cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("入库日期"); cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("目的地"); cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("区号"); cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellValue("排号"); cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellValue("架号"); cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellValue("位号"); cell.setCellStyle(style);


		for (int i=0; i<users.size();i++) { 
			// 相当于excel表格中的总行数
			 row = s.createRow((int)i+1);
			 row.createCell(0).setCellValue(users.get(i).getGoodsName());
			 row.createCell(1).setCellValue(users.get(i).getExpressNumber());
			 row.createCell(2).setCellValue(users.get(i).getInTime());
			 row.createCell(3).setCellValue(users.get(i).getDestination());
			 if(users.get(i).getAreaNumber() == GoodsType.SHIPPING){
				 row.createCell(4).setCellValue("航运区");
			 }
			 if(users.get(i).getAreaNumber() == GoodsType.RAIL){
				 row.createCell(4).setCellValue("铁运区");
			 }
			 if(users.get(i).getAreaNumber() == GoodsType.TRANSPORT){
				 row.createCell(4).setCellValue("汽运区");
			 }
			 if(users.get(i).getAreaNumber() == GoodsType.FLXIBLE){
				 row.createCell(4).setCellValue("机动区");
			 }
			 row.createCell(5).setCellValue(users.get(i).getRowNumber());
			 row.createCell(6).setCellValue(users.get(i).getShelfNumber());
			 row.createCell(7).setCellValue(users.get(i).getSeatNumber());
			} wb.write(fos); fos.close(); 
			System.out.println("Export successfully");}
		catch (FileNotFoundException e) { 
			e.printStackTrace(); } 
		catch (IOException e) { e.printStackTrace(); } 
		catch (IllegalArgumentException e) { e.printStackTrace(); }
		
	}

	@Override
	public double getAlarmScale(String storageId) {
		StoragePO spo = null;
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return spo.getAlarmScale();
	}
	
	@Override
	public void changeAlarmScale(double alarmScale,String storageId) {
		StoragePO spo = null;
//		ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
		try {
			spo = storageDataService.findStoragePO(storageId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
//		gpos = spo.getGpos();
//		try {
//			spo = storageDataService.findStoragePO(storageId);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
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
		
		for(int i = 0;i < gpos.size();i++){
			//判断是否在指定时间内
			if((Long.parseLong(gpos.get(i).getInTime().replaceAll("-", "")) >= startTime) && 
					(Long.parseLong(gpos.get(i).getInTime().replaceAll("-", "")) <= endTime)){
				svos.add(new StorageInfoVO(gpos.get(i).getGoodsName(),gpos.get(i).getAreaNumber(), 
						gpos.get(i).getRowNumber(), gpos.get(i).getShelfNumber(),
						gpos.get(i).getSeatNumber()));
			}
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
		
		for(int i = 0;i < gpos.size();i++){
			//判断是否在指定时间内
			if((Long.parseLong(gpos.get(i).getInTime().replaceAll("-", "")) >= startTime) && 
					(Long.parseLong(gpos.get(i).getInTime().replaceAll("-", "")) <= endTime)){
				inNum++;
			}
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
		
		for(int i = 0;i < gpos.size();i++){
			if(gpos.get(i).getAreaNumber() == areaNumber){
				evos.add(new ExpressInfoVO(gpos.get(i).getGoodsName(),gpos.get(i).getExpressNumber(), 
						gpos.get(i).getInTime(), gpos.get(i).getDestination(), 
						gpos.get(i).getAreaNumber(), gpos.get(i).getRowNumber(),
						gpos.get(i).getShelfNumber(), gpos.get(i).getSeatNumber(),
						false));
			}
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
		
		
		for(int i = 0;i < evos.size();i++){
			if(evos.get(i).isFlxible() == true){
				for(int j = 0;j < gpos.size();j++){
					if(gpos.get(j).getExpressNumber() == 
							evos.get(i).getExpressNumber()){
						gpos.get(j).setAreaNumber(GoodsType.FLXIBLE);
					}
				}
			}
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
			
			StoragePO spo = null;
			ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
			try {
				spo = storageDataService.findStoragePO(storageId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			gpos = spo.getGpos();
			
			for(int i = 0;i < sivo.getGoodsNameList().size();i++){
				GoodsPO gpo = new GoodsPO(null, 1, 0, 0, 0, 0, 0, 
						sivo.getGoodsNameList().get(i), null, null, 
						sivo.getExpressNumberList().get(i), 
						sivo.getInTime(), sivo.getDestinationList().get(i), 
						sivo.getAreaNumberList().get(i), 
						sivo.getRowNumberList().get(i), 
						sivo.getShelfNumberList().get(i), 
						sivo.getSeatNumberList().get(i), 
						0, "0", "0");
				gpos.add(gpo);
				if(sivo.getAreaNumberList().get(i) == GoodsType.SHIPPING){
					spo.addShippingNUm();
				}
				else if(sivo.getAreaNumberList().get(i) == GoodsType.RAIL){
					spo.addRailNUm();
				}
				else if(sivo.getAreaNumberList().get(i) == GoodsType.TRANSPORT){
					spo.addTransportNUm();
				}
				else if(sivo.getAreaNumberList().get(i) == GoodsType.FLXIBLE){
					spo.addFlxibleNUm();
				}
				spo.addStorageNUm();
			}
			AlarmMessage alarmMessage = this.alarm(storageId);
			try {
				storageDataService.update(storageId, spo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		else if(svo.getType() == SheetType.STORAGE_OUT_SHEET){
			StorageOutSheetVO sovo = (StorageOutSheetVO)svo;
			
			StoragePO spo = null;
			ArrayList<GoodsPO> gpos = new ArrayList<GoodsPO>();
			try {
				spo = storageDataService.findStoragePO(storageId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			gpos = spo.getGpos();
			
			for(int i = 0;i < sovo.getExpressNumberList().size();i++){
				for(int j = 0;j < gpos.size();j++){
					if(gpos.get(j).getExpressNumber().
							equals(sovo.getExpressNumberList().get(i))){
						gpos.remove(j);
					}
					if(gpos.get(j).getAreaNumber() == GoodsType.SHIPPING){
						spo.minusShippingNUm();
					}
					else if(gpos.get(j).getAreaNumber() == GoodsType.RAIL){
						spo.minusRailNUm();
					}
					else if(gpos.get(j).getAreaNumber() == GoodsType.TRANSPORT){
						spo.minusTransportNUm();
					}
					else if(gpos.get(j).getAreaNumber() == GoodsType.FLXIBLE){
						spo.minusFlxibleNUm();
					}
					spo.minusStorageNUm();
				}
			}
			try {
				storageDataService.update(storageId, spo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void initStorageInfo(ArrayList<StorageInitVO> svolist) {
		StoragePO spo = null;
		for(int i = 0;i < svolist.size();i++){
			spo = new StoragePO(svolist.get(i).getStorageId(), 
					0, 0, 0, 0, 0, svolist.get(i).getAlarmScale(), 
					svolist.get(i).getSeatNum()/4, 
					svolist.get(i).getSeatNum()/4,
					svolist.get(i).getSeatNum()/4,
					svolist.get(i).getSeatNum()/4, null);
			try {
				storageDataService.insert(spo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}



}
