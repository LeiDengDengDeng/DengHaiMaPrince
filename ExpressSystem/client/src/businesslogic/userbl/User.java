package src.businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.userblservice.UserBLService;
import src.dataservice.logdataservice.LogDataService;
import src.dataservice.userdataservice.UserDataService;
import src.po.SalaryPO;
import src.po.UserPO;
import src.vo.InitUserVO;
import src.vo.SalaryVO;
import src.vo.UserVO;

public class User implements UserBLService{
	
	UserDataService userData;
	Log log;
//	Map<String, Integer> map = new HashMap<>();
	public User(Log log){
		this.log = log;
		try {
			this.userData = (UserDataService) Naming.lookup("rmi://127.0.0.1:6600/userData");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		SalaryVO salaryVO = null;

		if(userPO.getSalary() != null){
			salaryVO = new SalaryVO(userPO.getSalary().getBasic());
			salaryVO.setCommission(userPO.getSalary().getCommission());
			salaryVO.setEachPay(userPO.getSalary().getEachPay());
			salaryVO.setTime(userPO.getSalary().getTime());
		}
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
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userPO.setMyPassword(password);
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
	
//	public static void main(String[] args) {
//		User user = new User(null);
//		System.out.println(user.getPersonalInfo(100000).getAuthority().size());
//		user.changeInfo(new UserVO(100000, 100000, "123456", "Îå°¢¸ç", "¿ìµÝÔ±",null,new SalaryVO(0),null,null));
//	}


}
