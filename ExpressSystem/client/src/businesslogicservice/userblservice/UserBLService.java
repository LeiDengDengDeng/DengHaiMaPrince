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
	public boolean changePassword(String password,long UserId);
	
	/**
	 * ��ʼ��
	 * @param User
	 * 
	 */
	public boolean initial(ArrayList<InitUserVO> User);
	
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
	public boolean changeInfo(UserVO userVO); 
	
	
	/**
	 * ��������
	 * 
	 */
	public boolean endManagement();
	
	
}
