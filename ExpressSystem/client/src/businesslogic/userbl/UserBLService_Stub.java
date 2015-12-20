package src.businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.userblservice.UserBLService;
import src.dataservice.userdataservice.UserDataService;
import src.po.SalaryPO;
import src.po.UserPO;
import src.vo.InitUserVO;
import src.vo.SalaryVO;
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
	Log log;
	public UserBLService_Stub(Log log){
		this.log = log;
//		try {
//			this.stub = (UserDataService) Naming.lookup("rmi://127.0.0.1:6600/userData");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public UserVO getPersonalInfo(long UserId) {
		// TODO Auto-generated method stub
		System.out.println("get!!");
		return null;
	}
	

	@Override
	public boolean changePassword(String password,long UserId) {
		// TODO Auto-generated method stub
		System.out.println("change!!");
		return true;
	}


	@Override
	public boolean changeInfo(UserVO userVO) {
		// TODO Auto-generated method stub
		
		return true;
	}

	@Override
	public boolean endManagement() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean initial(ArrayList<InitUserVO> User) {
		// TODO Auto-generated method stub
		return true;
	}


}
