package src.businesslogicservice.institutionblservice;

import java.util.ArrayList;

import src.vo.InstitutionVO;
import src.vo.SalaryVO;
/**
 * @author: samsung
 * 
 * 人员机构管理
 * 
 */

public interface InstitutionBLService {
	
	/**
	 * 获得某个机构信息
	 * @param InstitutionId
	 * @return
	 * 
	 */
	public InstitutionVO getInstitutionInfo(long InstitutionId);
	
	/**
	 * 获得所有机构信息
	 * @return
	 *  
	 */
	public ArrayList<InstitutionVO> getAllInstitution(); 
	
	/**
	 * 增加一个机构
	 * @param Institution
	 *  
	 */
	public void addInstitution(InstitutionVO Institution);
	
	/**
	 * 更改某个人员的职位
	 * @param position,StaffId
	 *  
	 */
	public void changeStaffPosition(String position,long StaffId);
	
	/**
	 * 人员工资调整
	 * @param StaffId,salary
	 * 
	 */
	public void changeSalary(long StaffId,SalaryVO salary);
	
	/**
	 * 删除机构
	 * @param InstitutionId
	 * 
	 */
	public void deleteInstitution(long InstitutionId);
	
	/**
	 * 结束管理
	 */
	public void endManagement();
	
}
