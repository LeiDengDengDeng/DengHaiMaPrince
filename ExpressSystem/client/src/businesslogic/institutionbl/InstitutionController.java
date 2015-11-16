package src.businesslogic.institutionbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.vo.InstitutionVO;

public class InstitutionController{
	
	LogBLService log;
	public InstitutionController(LogBLService log){
		this.log = log;
	}

	public InstitutionVO getInstitutionInfo(long InstitutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InstitutionVO> getAllInstitution() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addInstitution(InstitutionVO Institution) {
		// TODO Auto-generated method stub
		
	}

	public void changeStaffPosition(String position, long StaffId) {
		// TODO Auto-generated method stub
		
	}

	public void changeSalary(long StaffId, int salary) {
		// TODO Auto-generated method stub
		
	}

	public void deleteInstitution(long InstitutionId) {
		// TODO Auto-generated method stub
		
	}

	public void endManagement() {
		// TODO Auto-generated method stub
		
	}

}
