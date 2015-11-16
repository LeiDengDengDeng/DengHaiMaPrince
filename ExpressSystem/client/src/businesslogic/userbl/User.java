package src.businesslogic.userbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.userblservice.UserBLService;
import src.vo.InitUserVO;
import src.vo.UserVO;

public class User implements UserBLService{
	
	LogBLService log;
	public User(LogBLService log){
		super();
		this.log = log;
	}

	@Override
	public UserVO getPersonalInfo(long UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCity(long UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeInfo(UserVO userVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endManagement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initial(ArrayList<InitUserVO> User) {
		// TODO Auto-generated method stub
		
	}

}
