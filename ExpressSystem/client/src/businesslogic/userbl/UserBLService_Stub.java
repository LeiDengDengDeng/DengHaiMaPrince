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
import src.presentation.userui.UserData_Stub;
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
	UserData_Stub userData;
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
		userData = new UserData_Stub();
	}

	@Override
	public UserVO getPersonalInfo(long UserId) {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		try {
			userPO = userData.find(UserId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userPO == null){
			System.out.println("userPO is null");
			return null;
		}
		SalaryVO salaryVO = new SalaryVO(userPO.getSalary().getBasic());
		salaryVO.setCommission(userPO.getSalary().getCommission());
		salaryVO.setEachPay(userPO.getSalary().getEachPay());
		salaryVO.setTime(userPO.getSalary().getTime());
		UserVO userVO = new UserVO(userPO.getPersonalID(), userPO.getPersonalAccount(),
				userPO.getMyPassword(), userPO.getPersonalName(),
				userPO.getMyPosition(), userPO.getAuthority(), salaryVO,
				userPO.getCity(),userPO.getBusinessHall());
		
		return userVO;
	}
	

	@Override
	public boolean changePassword(String password,long UserId) {
		// TODO Auto-generated method stub
		if(password == null) 
			return false;
		
		else{
			UserPO userPO = null;
			try {
				userPO = userData.find(UserId);
				if(userPO == null) System.out.println("a");
				else userPO.setMyPassword(password);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			PasswordPanel passwordPanel = new PasswordPanel(userPO.getMyPassword(),
//					password, password);
			try {
				userData.update(userPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		
	}


	@Override
	public boolean changeInfo(UserVO userVO) {
		// TODO Auto-generated method stub
		UserPO userPO = new UserPO(userVO.getpersonalID(), userVO.getpersonalAccount(),
				userVO.getMyPassword(),	userVO.getpersonalName(),
				userVO.getMyPosition(), userVO.getAuthority());
		SalaryPO salaryPO = new SalaryPO(userVO.getSalary().getBasic());
		salaryPO.setCommission(userVO.getSalary().getCommission());
		salaryPO.setEachPay(userVO.getSalary().getEachPay());
		salaryPO.setTime(userVO.getSalary().getTime());
		userPO.setSalary(salaryPO);
		userPO.setCity(userVO.getCity());
		userPO.setBusinessHall(userVO.getBusinessHall());
		try {
			userData.update(userPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean endManagement() {
		// TODO Auto-generated method stub
		try {
			userData.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean initial(ArrayList<InitUserVO> User) {
		// TODO Auto-generated method stub
		ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
		for(int i = 0;i < User.size();i++){
			userPOs.add(new UserPO(User.get(i).getPersonalID(), User.get(i).getPersonalID(),
					null, User.get(i).getPersonalName(), User.get(i).getMyPosition(), 
					null));
		}
		try {
			userData.insert(userPOs);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}



	

}
