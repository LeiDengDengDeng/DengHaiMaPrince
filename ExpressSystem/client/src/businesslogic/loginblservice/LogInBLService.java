package src.businesslogic.loginblservice;

import src.businesslogic.userbl.ResultMessage;
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
