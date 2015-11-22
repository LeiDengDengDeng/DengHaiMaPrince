package src.businesslogic.userbl;

import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.userdataservice.UserDataService;
import src.vo.InitUserVO;
import src.vo.UserVO;

public class MockUser extends User{
	
	
public MockUser(Log log,UserDataService userData) {
		super(log,userData);
		// TODO Auto-generated constructor stub
	}
	
	public void changeInfo(UserVO userVO){
		System.out.println("User information has been updated!!");
	}
	public void initial(ArrayList<InitUserVO> User){
		System.out.println("initialize successfully!!");
	}

}
