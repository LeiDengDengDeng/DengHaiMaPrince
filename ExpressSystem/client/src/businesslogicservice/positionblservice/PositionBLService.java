package src.businesslogicservice.positionblservice;

import java.util.ArrayList;

import src.vo.AuthorityVO;
import src.vo.StaffInfoVO;

/**
 * @author: samsung 
 * 
 * �����˺Ź���
 * 
 */

public interface PositionBLService {
	
	/**
	 * ��ʼ��Ȩ��
	 * @param staff
	 * 
	 */
	public ArrayList<Integer> initialAuthority(StaffInfoVO staff);
	
	/**
	 * ����ĳ��ְλ��Ȩ��
	 * @param authorityVO
	 * @return
	 */
	public boolean changeAuthority(AuthorityVO authorityVO);
	
	/**
	 * ��ö�ӦȨ��
	 * @param position
	 * @return
	 */
	public AuthorityVO getAuthority(String position);
	
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
