package src.businesslogic.userbl;

import java.util.ArrayList;

import src.businesslogicservice.userblservice.UserBLService;
import src.vo.InitUserVO;
import src.vo.UserVO;

public class UserController {
	UserBLService user;
	
	public UserController(UserBLService user){
		this.user = user;
		
	}

	
	public UserVO getPersonalInfo(long UserId){
		
		return user.getPersonalInfo(UserId);
	}
	
	public void changePassword(String password,long UserId){
		user.changePassword(password, UserId);
		
	}
	
	public void initial(ArrayList<InitUserVO> User){
		
	}
	
//	public String getCity(long UserId){
//		return null;
//	}
	
	public void changeInfo(UserVO userVO){
		user.changeInfo(userVO);
		
	}
	
	public void endManagement(){
		
	}
}
