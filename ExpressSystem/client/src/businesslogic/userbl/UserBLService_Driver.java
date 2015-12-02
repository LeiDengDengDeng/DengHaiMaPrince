package src.businesslogic.userbl;

import src.businesslogicservice.userblservice.UserBLService;
import src.vo.UserVO;

public class UserBLService_Driver {
	
	public void drive(UserBLService userBLService){
		UserVO userVO = userBLService.getPersonalInfo(000000);
		userBLService.changePassword("aaaaa",000000);
		userBLService.endManagement();
		userBLService.changeInfo(userVO);
		userBLService.initial(null);
	}

}
