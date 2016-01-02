package src.businesslogic.staffmanagebl;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.staffmanageblservice.SalaryBLService;
import src.businesslogicservice.userblservice.UserBLService;
import src.vo.SalaryVO;
import src.vo.UserVO;

public class Salary implements SalaryBLService{
	
	UserBLService userBL;
	LogBLService log;
	
	public Salary(UserBLService userBL,LogBLService log){
		this.userBL = userBL;
		this.log = log;
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
		log.generateLog("人员工资调整", String.valueOf(StaffId));
		
		return true;
		
	}
	
	

}
