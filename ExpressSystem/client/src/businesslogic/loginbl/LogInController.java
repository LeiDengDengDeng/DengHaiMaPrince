package src.businesslogic.loginbl;

import src.businesslogic.loginblservice.LogInBLService;
import src.businesslogic.userbl.ResultMessage;
import src.businesslogicservice.userblservice.UserBLService;
import src.vo.UserVO;

public class LogInController {

	LogInBLService loginBL;
	
	public LogInController(LogInBLService loginBL){
		this.loginBL = loginBL;
	}
	
	public ResultMessage logIn(long UserId,String password){
		
		ResultMessage resultMessage = loginBL.logIn(UserId, password);
		
		return resultMessage;
		
	}
	
	public UserVO getCurrentUser(){
		return null;
		
	}
}
