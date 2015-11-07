package src.businesslogicservice.staffmanageblservice;

import java.util.ArrayList;

import src.po.UserPO;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

/**
 * @author: samsung
 * 
 * �û�����
 * 
 */

public interface StaffManageBLService {

	/**
	 * ���ĳ��Ա���ʺ���Ϣ
	 * @param StaffId
	 * @return
	 * 
	 */
	public StaffInfoVO getStaffInfo(long StaffId); 
	
	/**
	 * �������Ա���ʺ���Ϣ
	 * @return
	 * 
	 */
	public ArrayList<StaffInfoVO> getAllStaff(); 
	
	/**
	 * �޸ĸ���ְλ��Ȩ��
	 * @param authority,position
	 * 
	 */
	public void changeAuthority(ArrayList<Integer> authority,String position);
	
	/**
	 * ����һ��Ա���ʺ�
	 * @param StaffInfo
	 * 
	 */
	public void addStaffInfo(UserVO StaffInfo);
	
	/**
	 * ɾ��һ��Ա���ʺ�
	 * @param StaffId
	 * 
	 */
	public void deleteStaff(long StaffId);
	
	/**
	 * ��������
	 * 
	 */
	public void endManagement();
}
