package src.businesslogicservice.staffmanagebl;

import java.util.ArrayList;

import src.businesslogicservice.staffmanageblservice.StaffManageBLService;
import src.po.StaffInfoPO;
import src.vo.StaffInfoVO;

public class StaffManageBLService_Driver {
	
	public void drive(StaffManageBLService staffManageBLService){
		StaffInfoVO staffInfoVO = staffManageBLService.getStaffInfo(000000);
		ArrayList<StaffInfoVO> staffInfoVOs = staffManageBLService.getAllStaff();
		staffManageBLService.changeAuthority(null, "Manager");
		staffManageBLService.addStaffInfo(new StaffInfoPO(000000,000000,"aaaaa",
				"Echo","Administrator",null));
		staffManageBLService.deleteStaff(new StaffInfoPO(000000,000000,"aaaaa",
				"Echo","Administrator",null));
		staffManageBLService.endManagement();
	}

}
