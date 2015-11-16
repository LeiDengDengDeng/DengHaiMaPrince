package src.businesslogic.userbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.vo.InitUserVO;
import src.vo.UserVO;

public class MockUser extends User{
	
	public MockUser(LogBLService log) {
		super(log);
	}
	
	public void changeInfo(UserVO userVO){
		System.out.println("User information has been updated!!");
	}
	public void initial(ArrayList<InitUserVO> User){
		System.out.println("initialize successfully!!");
	}

}
