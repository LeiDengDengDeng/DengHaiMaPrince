package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.BussinessHallVO;

public interface BussinessHallBLService {
	/**
	 * 非用户信息查询界面得到某个营业厅信息
	 * @param bussinessHallId
	 * @return
	 */
	public BussinessHallVO getBussinessHallInfo(String bussinessHallId);
	
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
	public void deleteBussinessHallInfo(String bussinessHallId);
}
