package src.businesslogicservice.commodityblservice;

import java.util.ArrayList;

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
 * 库存业务逻辑的接口
 * @author Potter
 *
 */
public interface CommodityBLService {
	
	/**
	 * 获得仓库id号
	 */
	public void getStorageId();
	
	/**
	 * 盘点界面得到当天各区快递信息
	 */
	public ArrayList<ExpressInfoVO> stockTaking();
	
	/**
	 * 向外部导出Excel
	 */
	public void exportExcel();
	
	/**
	 * 修改警戒比例
	 * @param alarmScale
	 */
	public void changeAlarmScale(double alarmScale);
	
	/**
	 * 库存查看界面得到一段时间内的库存信息
	 * @return 
	 */
	public ArrayList<StorageInfoVO> checkStorageMessage();
	public StorageNumVO getStorageNum(long startTime,long endTime);
	
	/**
	 * 商品数量超出报警值，实现库存报警
	 */
	public boolean alarm ();
	
	/**
	 * 对货物进行库存分区，调整各区的库存分配
	 * @param gpo
	 * @param spo
	 */
	public void divide (GoodsPO gpo, StoragePO spo);
	
	/**
	 * 结束库存操作
	 */
	public void endCommodityManagement();
	

	/**
	 * 供接口，提供修改库存信息
	 */
	public void changeStorageInInfo(ArrayList<SheetVO> svolist);
	
	/**
	 * 供接口，提供库存信息初始化
	 */
	public void initStorageInfo(StorageInitVO sivo);

}
