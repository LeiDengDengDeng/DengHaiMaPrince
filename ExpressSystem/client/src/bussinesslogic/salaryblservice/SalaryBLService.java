package src.bussinesslogic.salaryblservice;

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
	public void changeSalary(long StaffId,SalaryVO salary);
}
