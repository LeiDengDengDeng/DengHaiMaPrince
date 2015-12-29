package src.businesslogicservice.staffmanageblservice;

import java.util.ArrayList;

import src.vo.StaffInfoVO;

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
	public boolean changeAuthority(ArrayList<Integer> authority,String position);
	
	/**
	 * ����һ��Ա���ʺ�
	 * @param StaffInfo
	 * 
	 */
	public boolean addStaffInfo(StaffInfoVO StaffInfo);
	
	/**
	 * ɾ��һ��Ա���ʺ�
	 * @param StaffId
	 * 
	 */
	public boolean deleteStaff(long StaffId);
	

	
	/**
	 * ��������
	 * 
	 */
	public boolean endManagement();
}
