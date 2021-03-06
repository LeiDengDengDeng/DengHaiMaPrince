package src.businesslogicservice.positionblservice;

import java.util.ArrayList;

import src.vo.AuthorityVO;
import src.vo.StaffInfoVO;

/**
 * @author: samsung 
 * 
 * 个人账号管理
 * 
 */

public interface PositionBLService {
	
	/**
	 * 初始化权限
	 * @param staff
	 * 
	 */
	public ArrayList<Integer> initialAuthority(StaffInfoVO staff);
	
	/**
	 * 更改某个职位的权限
	 * @param authorityVO
	 * @return
	 */
	public boolean changeAuthority(AuthorityVO authorityVO);
	
	/**
	 * 获得对应权限
	 * @param position
	 * @return
	 */
	public AuthorityVO getAuthority(String position);
	
	/**
	 * 更改某个人员的职位
	 * @param position, StaffId
	 * @return
	 */
	public boolean changeStaffPosition(String position, long StaffId);
	
	/**
	 * 设置某个人的城市
	 * @param city, StaffId
	 * @return
	 */
	public boolean setCity(String city, long StaffId);
	
	
	/**
	 * 设置员工所属营业厅
	 * @param businessHall, StaffId
	 * @return
	 */
	public boolean setBusinessHall(String businessHall, long StaffId);
}
