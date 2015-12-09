package src.businesslogic.userbl;

import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.userdataservice.UserDataService;
import src.vo.InitUserVO;
import src.vo.UserVO;

public class MockUser extends User{
	
	
public MockUser(Log log) {
		super(log);
		// TODO Auto-generated constructor stub
	}
	
	public boolean changeInfo(UserVO userVO){
		System.out.println("User information has been updated!!");
		return true;
	}
	public boolean initial(ArrayList<InitUserVO> User){
		System.out.println("initialize successfully!!");
		return true;
	}

}
