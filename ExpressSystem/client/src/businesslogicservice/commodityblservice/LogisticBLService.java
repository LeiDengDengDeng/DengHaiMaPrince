package src.businesslogicservice.commodityblservice;

import java.util.ArrayList;


public interface LogisticBLService {
	/**
	 * 供接口，提供修改物流状态
	 */
	public void changeLogisticsState(String expressNumber,String logisticsState);
	
	/**
	 * 物流信息查询
	 * @param expressNumber
	 * @return
	 */
	public ArrayList<String> getLogisticsState(String expressNumber);
}
