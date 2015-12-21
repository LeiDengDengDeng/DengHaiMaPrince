package src.businesslogic.loginbl;

import src.businesslogicservice.loginblservice.LogInBLService;
import src.enums.ResultMessage;
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
		return loginBL.getCurrentUser();
		
	}
}
