package src.businesslogicservice.userblservice;

import java.util.ArrayList;

import src.businesslogic.userbl.ResultMessage;
import src.vo.InitUserVO;
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
	public ResultMessage logIn(long UserId,String password);
	
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
	public void changePassword(String password,long UserId);
	
	/**
	 * ��ʼ��
	 * @param User
	 * 
	 */
	public void initial(ArrayList<InitUserVO> User);
	
//	/**
//	 * ��òֿ�����Ӧ�ĳ���
//	 * @param UserId
//	 * @return
//	 * 
//	 */
//	public String getCity(long UserId);
	
	/**
	 * ������Ϣ��ְλ��нˮ��
	 * @param userVO
	 *  
	 */
	public void changeInfo(UserVO userVO); 
	
	
	/**
	 * ��������
	 * 
	 */
	public void endManagement();
	
	
}
