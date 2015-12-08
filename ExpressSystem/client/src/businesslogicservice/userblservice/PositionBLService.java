package src.businesslogicservice.userblservice;

import java.util.ArrayList;

import src.vo.StaffInfoVO;

/**
 * @author: samsung 
 * 
 * 个人账号管理
 * 
 */

public interface PositionBLService {
	
	/**
	 * 默认权限
	 * @param staff
	 * 
	 */
	public ArrayList<Integer> initialAuthority(StaffInfoVO staff);
	
	/**
	 * 更改某个人员的职位
	 * @param position, StaffId
	 * @return
	 */
	public void changeStaffPosition(String position, long StaffId);
	
	/**
	 * 设置某个人的城市
	 * @param city, StaffId
	 * @return
	 */
	public void setCity(String city, long StaffId);
	
	
	/**
	 * 设置员工所属营业厅
	 * @param businessHall, StaffId
	 * @return
	 */
	public void setBusinessHall(String businessHall, long StaffId);
}
