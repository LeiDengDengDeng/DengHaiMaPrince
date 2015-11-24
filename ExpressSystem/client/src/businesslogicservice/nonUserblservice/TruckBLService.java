package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.TruckInfoVO;

public interface TruckBLService {
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
	 * @param tvo
	 */
	public void changeTruckInfo(long truckId,TruckInfoVO tvo);
	
	/**
	 * 供接口，提供车辆信息初始化
	 * @param tvo
	 */
	public void initTruck(ArrayList<TruckInfoVO> tvolist);
}
