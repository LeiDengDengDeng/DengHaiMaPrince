package src.businesslogic.userbl;

import src.businesslogicservice.userblservice.SalaryBLService;
import src.businesslogicservice.userblservice.UserBLService;
import src.po.SalaryPO;
import src.vo.SalaryVO;
import src.vo.UserVO;

public class Salary implements SalaryBLService{
	
	UserBLService userBL;
	
	public Salary(UserBLService userBL){
		this.userBL = userBL;
	}

	@Override
	public boolean changeSalary(long StaffId, SalaryVO salary) {
		// TODO Auto-generated method stub
//		SalaryPO salaryPO = new SalaryPO(salary.getBasic());
//		salaryPO.setCommission(salary.getCommission());
//		salaryPO.setTime(salary.getTime());
		UserVO userVO = userBL.getPersonalInfo(StaffId);
		userVO.setSalary(salary);
		userBL.changeInfo(userVO);	
		
		return true;
		
	}
	
	

}
