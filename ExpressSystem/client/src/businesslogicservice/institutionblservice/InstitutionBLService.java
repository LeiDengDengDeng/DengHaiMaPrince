package src.businesslogicservice.institutionblservice;

import java.util.ArrayList;

import src.vo.InstitutionVO;
import src.vo.SalaryVO;
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
	public boolean addInstitution(InstitutionVO Institution);
	
//	/**
//	 * ����ĳ����Ա��ְλ
//	 * @param position,StaffId
//	 *  
//	 */
//	public void changeStaffPosition(String position,long StaffId);
	
//	/**
//	 * ��Ա���ʵ���
//	 * @param StaffId,salary
//	 * 
//	 */
//	public void changeSalary(long StaffId,SalaryVO salary);
	
	/**
	 * ɾ������
	 * @param InstitutionId
	 * 
	 */
	public boolean deleteInstitution(long InstitutionId);
	
	/**
	 * ��������
	 */
	public boolean endManagement();
	
}
