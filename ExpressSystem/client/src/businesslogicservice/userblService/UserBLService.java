package src.businesslogicservice.userblService;

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
	 * 结束管理
	 * 
	 */
	public void endManagement();
	
	
}
