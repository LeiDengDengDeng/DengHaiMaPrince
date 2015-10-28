package src.businesslogicservice.commodityblservice;

import java.util.ArrayList;

import src.po.GoodsPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.StorageInfoVO;

/**
 * 库存业务逻辑的接口
 * @author Potter
 *
 */
public interface CommodityBLService {
	
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
	public StoragePO getStorageNum(long startTime,long endTime);
	
	/**
	 * 商品数量超出报警值，实现库存报警
	 */
	public void alarm ();
	
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

}
