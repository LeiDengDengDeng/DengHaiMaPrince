package src.businesslogicservice.userblService;

import src.vo.UserVO;

/**
 * @author: samsung 
 * 
 * �����˺Ź���
 * 
 */

public interface UserBLService {
	
	
	/**
	 * ��¼
	 * 
	 */
//	public ResultMessage logIn(long UserId,String password);
	
	/**
	 * ��ø����ʺ���Ϣ
	 * @param UserId
	 * @return
	 */
	public UserVO getPersonalInfo(long UserId);
	
	/**
	 * �޸�����
	 * @param password
	 * 
	 */
	public void changePassword(String password);
	
	
	/**
	 * ��������
	 * 
	 */
	public void endManagement();
	
	
}
