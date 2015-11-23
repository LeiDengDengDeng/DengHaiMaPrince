package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.DriverInfoVO;

public interface DriverBLService {
	/**
	 * 非用户信息查询界面得到某个司机信息
	 * @param driverId
	 */
	public DriverInfoVO getDriverInfo(long driverId);
	
	/**
	 * 非用户信息查询界面得到所有司机信息
	 * @return
	 */
	public ArrayList<DriverInfoVO> getAllDriverInfo();
	
	/**
	 * 增加一个司机
	 * @param driver
	 */
	public void addDriverInfo(DriverInfoVO driver);
	
	/**
	 * 删除一个司机
	 * @param driverId
	 */
	public void deleteDriverInfo(long driverId);
	
	/**
	 * 修改司机信息
	 * @param driverId
	 */
	public void changeDriverInfo(long driverId);
	
	/**
	 * 供接口，提供司机信息初始化
	 * @param dvolist
	 */
	public void initDriver(ArrayList<DriverInfoVO> dvolist);
}
