package src.businesslogicservice.userblservice;

import src.vo.SalaryVO;

/**
 * @author: samsung
 * 
 * 人员机构管理
 * 
 */

public interface SalaryBLService {
	
	/**
	 * 人员工资调整
	 * @param StaffId,salary
	 * 
	 */
	public boolean changeSalary(long StaffId,SalaryVO salary);
}
