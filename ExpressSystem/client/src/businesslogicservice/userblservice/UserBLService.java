package src.businesslogicservice.userblservice;

import src.vo.UserVO;

/**
 * @author: samsung 
 * 
 * 个人账号管理
 * 
 */

public interface UserBLService {
	
	
	/**
	 * 登录
	 * 
	 */
//	public ResultMessage logIn(long UserId,String password);
	
	/**
	 * 获得个人帐号信息
	 * @param UserId
	 * @return
	 */
	public UserVO getPersonalInfo(long UserId);
	
	/**
	 * 修改密码
	 * @param password
	 * 
	 */
	public void changePassword(String password);
	
	/**
	 * 初始化
	 * @param User
	 * 
	 */
//	public void initial(ArrayList<InitUserVO> User);
	
	/**
	 * 获得仓库管理对应的城市
	 * @param UserId
	 * @return
	 * 
	 */
	public String getCity(long UserId);
	
	/**
	 * 结束管理
	 * 
	 */
	public void endManagement();
	
	
}
