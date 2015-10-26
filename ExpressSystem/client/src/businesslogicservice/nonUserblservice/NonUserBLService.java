package src.businesslogicservice.nonUserblservice;

/**
 * 非用户信息业务逻辑的接口
 * @author Potter
 *
 */
public interface NonUserBLService {
	
	/**
	 * 非用户信息查询界面得到车辆信息
	 * @param truckId
	 */
	public void checkTruck(long truckId);
	
	/**
	 * 非用户信息查询界面得到司机信息
	 * @param driverId
	 */
	public void checkDriver (long driverId);

}
