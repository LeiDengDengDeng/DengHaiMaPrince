package src.businesslogicservice.userblservice;

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
	 * ��ʼ��
	 * @param User
	 * 
	 */
//	public void initial(ArrayList<InitUserVO> User);
	
	/**
	 * ��òֿ�����Ӧ�ĳ���
	 * @param UserId
	 * @return
	 * 
	 */
	public String getCity(long UserId);
	
	/**
	 * ��������
	 * 
	 */
	public void endManagement();
	
	
}
