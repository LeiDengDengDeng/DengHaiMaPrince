package src.businesslogic.loginbl;

import src.businesslogicservice.loginblservice.LogInBLService;
import src.businesslogic.userbl.ResultMessage;
import src.businesslogicservice.userblservice.UserBLService;
import src.vo.UserVO;

public class LogIn implements LogInBLService{
	
	UserVO currentUser;
	UserBLService userBL;
	
	public LogIn(UserBLService userBL){
		this.userBL = userBL;
	}
	
	@Override
	public ResultMessage logIn(long UserId, String password) {
		// TODO Auto-generated method stub
		ResultMessage resultMessage = null;
		
		if(userBL.getPersonalInfo(UserId) == null)
			resultMessage = ResultMessage.NOT_EXIT;
		else{
			if(userBL.getPersonalInfo(UserId).getMyPassword() == password){
				resultMessage = ResultMessage.CORRECT;
				currentUser = userBL.getPersonalInfo(UserId);
			}
			else
				resultMessage = ResultMessage.WRONG;
		}
		return resultMessage;
	}


	@Override
	public UserVO getCurrentUser() {
		// TODO Auto-generated method stub
		return currentUser;
	}


}
