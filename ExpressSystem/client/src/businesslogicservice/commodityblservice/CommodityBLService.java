package src.businesslogicservice.commodityblservice;

import java.util.ArrayList;

import src.businesslogic.commoditybl.AlarmMessage;
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
import src.vo.StorageOutSheetVO;

/**
 * 库存业务逻辑的接口
 * @author Potter
 *
 */
public interface CommodityBLService {
	
	/**
	 * 盘点界面得到当天各区快递信息
	 */
	public ArrayList<ExpressInfoVO> stockTaking(String storageId);
	
	/**
	 * 向外部导出Excel
	 */
	public void exportExcel(String realPath,ArrayList<ExpressInfoVO> users);
	
	/**
	 * 修改警戒比例
	 * @param alarmScale
	 */
	public void changeAlarmScale(double alarmScale,String storageId);
	
	/**
	 * 获得当前警戒比例
	 * @param storageId
	 * @return
	 */
	public double getAlarmScale(String storageId);
	
	/**
	 * 库存查看界面得到一段时间内的库存信息
	 * @return 
	 */
	public ArrayList <StorageInfoVO> checkStorageMessage(String storageId,long startTime,long endTime);
	public StorageNumVO getStorageNum(String storageId,long startTime,long endTime);
	
	/**
	 * 商品数量超出报警值，实现库存报警
	 * @return
	 */
	public AlarmMessage alarm (String storageId);
	
	/**
	 * 得到各区库存货物信息
	 * @param areaNumber
	 * @return
	 */
	public ArrayList<ExpressInfoVO> getAreaGoodsPOs(String storageId,GoodsType areaNumber);
	
	/**
	 * 对货物进行库存分区，调整各区的库存分配
	 * @param evos
	 */
	public void divide (String storageId,ArrayList<ExpressInfoVO> evos);
	
	/**
	 * 结束库存操作
	 */
	public void endCommodityManagement();
	

	/**
	 * 供接口，提供修改库存信息
	 */
	public void changeStorageInInfo(String storageId,SheetVO svo);
	
	/**
	 * 供接口，提供修改商品信息
	 */
	public void changeGoodInfo(String storageId,GoodsVO gvo);
	
	/**
	 * 供接口，提供库存信息初始化
	 */
	public void initStorageInfo(ArrayList<StorageInitVO> svolist);

}
