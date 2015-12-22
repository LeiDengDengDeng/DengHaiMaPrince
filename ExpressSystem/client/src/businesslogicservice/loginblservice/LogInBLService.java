package src.businesslogicservice.loginblservice;

import src.enums.ResultMessage;
import src.vo.UserVO;

/**
 * @author: samsung 
 * 
 * ��¼
 * 
 */
public interface LogInBLService {
	
	/**
	 * ��¼
	 * 
	 */
	public ResultMessage logIn(long UserId,String password);
	
	/**
	 * 
	 * ��õ�ǰ��¼����Ϣ
	 * 
	 */
	public UserVO getCurrentUser();
		
}
