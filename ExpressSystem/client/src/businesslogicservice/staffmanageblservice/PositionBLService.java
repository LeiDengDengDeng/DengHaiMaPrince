package src.businesslogicservice.staffmanageblservice;

import java.util.ArrayList;

import src.vo.StaffInfoVO;

/**
 * @author: samsung 
 * 
 * �����˺Ź���
 * 
 */

public interface PositionBLService {
	
	/**
	 * Ĭ��Ȩ��
	 * @param staff
	 * 
	 */
	public ArrayList<Integer> initialAuthority(StaffInfoVO staff);
	
	/**
	 * ����ĳ����Ա��ְλ
	 * @param position, StaffId
	 * @return
	 */
	public boolean changeStaffPosition(String position, long StaffId);
	
	/**
	 * ����ĳ���˵ĳ���
	 * @param city, StaffId
	 * @return
	 */
	public boolean setCity(String city, long StaffId);
	
	
	/**
	 * ����Ա������Ӫҵ��
	 * @param businessHall, StaffId
	 * @return
	 */
	public boolean setBusinessHall(String businessHall, long StaffId);
}
