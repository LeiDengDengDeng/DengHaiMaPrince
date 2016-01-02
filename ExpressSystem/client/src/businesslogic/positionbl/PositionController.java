package src.businesslogic.positionbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.vo.AuthorityVO;
import src.vo.StaffInfoVO;

public class PositionController{
	LogBLService log;
	
	public PositionController(LogBLService log){
		this.log = log;
	}
	
	public ArrayList<Integer> initialAuthority(StaffInfoVO staff) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean changeAuthority(AuthorityVO authorityVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changeStaffPosition(String position, long StaffId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setCity(String city, long StaffId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setBusinessHall(String businessHall, long StaffId) {
		// TODO Auto-generated method stub
		return false;
	}

}
