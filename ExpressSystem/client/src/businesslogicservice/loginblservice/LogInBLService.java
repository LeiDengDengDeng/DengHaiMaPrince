package src.businesslogicservice.loginblservice;

import src.enums.ResultMessage;
import src.vo.UserVO;

/**
 * @author: samsung 
 * 
 * 登录
 * 
 */
public interface LogInBLService {
	
	/**
	 * 登录
	 * 
	 */
	public ResultMessage logIn(long UserId,String password);
	
	/**
	 * 
	 * 获得当前登录者信息
	 * 
	 */
	public UserVO getCurrentUser();
		
}
