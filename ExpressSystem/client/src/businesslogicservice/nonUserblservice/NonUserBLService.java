package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.po.BussinessHallPO;
import src.po.DriverPO;
import src.po.TruckPO;
import src.vo.BussinessHallVO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

/**
 * 非用户信息业务逻辑的接口
 * @author Potter
 *
 */
public interface NonUserBLService {
	
	/**
	 * 非用户信息查询界面得到某个车辆信息
	 * @param truckId
	 */
	public TruckInfoVO getTruckInfo(long truckId);
	
	/**
	 * 非用户信息查询界面得到所有车辆信息
	 * @return
	 */
	public ArrayList<TruckInfoVO> getAllTruckInfo();
	
	/**
	 * 增加一个车辆
	 * @param truck
	 */
	public void addTruckInfo(TruckInfoVO truck);
	
	/**
	 * 删除一个车辆
	 * @param truckId
	 */
	public void deleteTruckInfo(long truckId);
	
	/**
	 * 修改车辆信息
	 * @param truckId
	 */
	public void changeTruckInfo(long truckId);
	
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
	 * 非用户信息查询界面得到某个营业厅信息
	 * @param bussinessHallId
	 * @return
	 */
	public BussinessHallVO getBussinessHallInfo(long bussinessHallId);
	
	/**
	 * 非用户信息查询界面得到所有营业厅信息
	 * @return
	 */
	public ArrayList<BussinessHallVO> getAllBussinessHallInfo();
	
	/**
	 * 增加一个营业厅
	 * @param bussinessHall
	 */
	public void addBussinessHallInfo(BussinessHallVO bussinessHall);
	
	/**
	 * 删除一个营业厅
	 * @param bussinessHallId
	 */
	public void deleteBussinessHallInfo(long bussinessHallId);
	
	/**
	 * 供接口，提供修改物流状态
	 */
	public void changeLogisticsState(String logisticsState);

}
