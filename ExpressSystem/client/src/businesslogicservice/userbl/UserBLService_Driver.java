package src.businesslogicservice.userbl;

import src.businesslogicservice.userblService.UserBLService;
import src.vo.UserVO;

public class UserBLService_Driver {
	
	public void drive(UserBLService userBLService){
		UserVO userVO = userBLService.getPersonalInfo(000000);
		userBLService.changePassword("aaaaa");
		userBLService.endManagement();
	}

}
