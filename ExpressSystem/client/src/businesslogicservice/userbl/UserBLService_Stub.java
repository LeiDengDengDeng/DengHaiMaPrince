package src.businesslogicservice.userbl;

import java.util.ArrayList;

import src.businesslogicservice.userblservice.UserBLService;
import src.vo.UserVO;

public class UserBLService_Stub implements UserBLService{
//	ArrayList<Integer> authority = new ArrayList<Integer>();
//	long personalID;
//	long personalAccount;
//	String myPassword;
//	String personalName;
//	String myPosition;
//	int salary;
//	
//	public UserBLService_Stub(long a,long b,String c,String d,String e,
//			ArrayList<Integer> f,int g) {
//		// TODO Auto-generated constructor stub
//		authority = f;
//		personalID = a;
//		personalAccount = b;
//		myPassword = c;
//		personalName = d;
//		myPosition = e;
//		salary = g;
//	}
	
//	@Override
//	public ResultMessage logIn(long UserId,String password){
//		return true;
//	}

	@Override
	public UserVO getPersonalInfo(long UserId) {
		// TODO Auto-generated method stub
		System.out.println("get!");
		return new UserVO(000000, 000000, "aaaaaaaa", "Echo", "Administrator", null, 5000);
	}

	@Override
	public void changePassword(String password) {
		// TODO Auto-generated method stub
		System.out.println("Password has been changed!");
	}

	@Override
	public void endManagement() {
		// TODO Auto-generated method stub
		System.out.println("End the management!");
	}
	

}
