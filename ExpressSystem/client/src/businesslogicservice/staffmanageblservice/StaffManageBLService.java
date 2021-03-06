package src.businesslogicservice.staffmanageblservice;

import java.util.ArrayList;

import src.vo.StaffInfoVO;

/**
 * @author: samsung
 * 
 * 用户管理
 * 
 */

public interface StaffManageBLService {

	/**
	 * 获得某个员工帐号信息
	 * @param StaffId
	 * @return
	 * 
	 */
	public StaffInfoVO getStaffInfo(long StaffId); 
	
	/**
	 * 获得所有员工帐号信息
	 * @return
	 * 
	 */
	public ArrayList<StaffInfoVO> getAllStaff(); 
	
	/**
	 * 修改各个职位的权限
	 * @param authority,position
	 * 
	 */
	public boolean changeAuthority(ArrayList<Integer> authority,String position);
	
	/**
	 * 增加一个员工帐号
	 * @param StaffInfo
	 * 
	 */
	public boolean addStaffInfo(StaffInfoVO StaffInfo);
	
	/**
	 * 删除一个员工帐号
	 * @param StaffId
	 * 
	 */
	public boolean deleteStaff(long StaffId);
	
	
	/**
	 * 结束管理
	 * 
	 */
	public boolean endManagement();
}
