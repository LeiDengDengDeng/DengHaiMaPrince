package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;


public interface LogisticBLService {
	/**
	 * 供接口，提供修改物流状态
	 */
	public void changeLogisticsState(String logisticsState);
	
	/**
	 * 物流信息查询
	 * @param expressNumber
	 * @return
	 */
	public ArrayList<String> getLogisticsState(long expressNumber);
}
