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
	
	/**
	 * �޸Ļ�����Ϣ
	 * @param institutionVO
	 * 
	 */
	public boolean changeInstitutionInfo(InstitutionVO institutionVO);
	
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
