package src.businesslogicservice.institutionblservice;

import java.util.ArrayList;

import src.po.InstitutionPO;
import src.vo.InstitutionVO;
/**
 * @author: samsung
 * 
 * ��Ա��������
 * 
 */

public interface InstitutionBLService {
	
	/**
	 * ���ĳ��������Ϣ
	 * @param InstitutionId
	 * @return
	 * 
	 */
	public InstitutionVO getInstitutionInfo(long InstitutionId);
	
	/**
	 * ������л�����Ϣ
	 * @return
	 *  
	 */
	public ArrayList<InstitutionVO> getAllInstitution(); 
	
	/**
	 * ����һ������
	 * @param Institution
	 *  
	 */
	public void addInstitution(InstitutionVO Institution);
	
	/**
	 * ����ĳ����Ա��ְλ
	 * @param position,StaffId
	 *  
	 */
	public void changeStaffPosition(String position,long StaffId);
	
	/**
	 * ��Ա���ʵ���
	 * @param StaffId,salary
	 * 
	 */
	public void changeSalary(long StaffId,int salary);
	
	/**
	 * ɾ������
	 * @param InstitutionId
	 * 
	 */
	public void deleteInstitution(long InstitutionId);
	
	/**
	 * ��������
	 */
	public void endManagement();
	
}