package src.businesslogic.userbl;

import src.businesslogicservice.userblservice.UserBLService;
import src.vo.UserVO;

public class UserBLService_Driver {
	
	public void drive(UserBLService userBLService){
//		UserVO userVO = userBLService.getPersonalInfo(100000);
		if(userBLService.getPersonalInfo(100000) == null){
			System.out.println("uservo is null");
			return;
		}
//		System.out.println(userVO.getpersonalName());
		userBLService.changePassword("123456",100000);
		System.out.println(userBLService.getPersonalInfo(100000).getMyPassword());
//		userBLService.endManagement();
//		userBLService.changeInfo(userVO);
//		userBLService.initial(null);
	}
	
	public static void main(String[] args) {
		UserBLService_Driver driver = new UserBLService_Driver();
		driver.drive(new User(null));
	}

}
