package src.businesslogic.staffmanagebl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class StaffManageController{
	
	LogBLService log;
	public StaffManageController(LogBLService log){
		this.log = log;
	}

	public StaffInfoVO getStaffInfo(long StaffId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<StaffInfoVO> getAllStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeAuthority(ArrayList<Integer> authority, String position) {
		// TODO Auto-generated method stub
		
	}

	public void addStaffInfo(StaffInfoVO StaffInfo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteStaff(long StaffId) {
		// TODO Auto-generated method stub
		
	}

	public void endManagement() {
		// TODO Auto-generated method stub
		
	}

}
