package src.businesslogicservice.userblservice;

import src.vo.SalaryVO;

/**
 * @author: samsung
 * 
 * ��Ա��������
 * 
 */

public interface SalaryBLService {
	
	/**
	 * ��Ա���ʵ���
	 * @param StaffId,salary
	 * 
	 */
	public boolean changeSalary(long StaffId,SalaryVO salary);
}
