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
import src.po.UserPO;
import src.presentation.userui.PasswordPanel;
import src.presentation.userui.UserFrame;
import src.vo.InitUserVO;
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
		UserVO userVO = new UserVO(userPO.getPersonalID(), userPO.getPersonalAccount(),
				userPO.getMyPassword(), userPO.getPersonalName(),
				userPO.getMyPosition(), userPO.getAuthority(), userPO.getSalary(),
				userPO.getCity(),userPO.getBusinessHall());
		
		return userVO;
	}
	

	@Override
	public void changePassword(String password,long UserId) {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		try {
			userPO = userData.find(UserId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userPO.setMyPassword(password);
//		PasswordPanel passwordPanel = new PasswordPanel(userPO.getMyPassword(),
//				password, password);
		try {
			userData.update(userPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Override
//	public String getCity(long UserId) {
//		// TODO Auto-generated method stub
//		UserPO userPO = null;
//		try {
//			userPO = userData.find(UserId);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String posiion = userPO.getMyPosition();
//		String city = null;
//		switch (map.get(posiion)) {
//		case 0: city = "南京";break;
//		case 1: city = "北京";break;
//		case 2: city = "上海";break;
//		case 3: city = "广州";break;
//		default:break;
//		}
//		return city;
//	}

	@Override
	public void changeInfo(UserVO userVO) {
		// TODO Auto-generated method stub
		UserPO userPO = new UserPO(userVO.getpersonalID(), userVO.getpersonalAccount(),
				userVO.getMyPassword(),	userVO.getpersonalName(),
				userVO.getMyPosition(), userVO.getAuthority());
		userPO.setSalary(userVO.getSalary());
		userPO.setCity(userVO.getCity());
		userPO.setBusinessHall(userVO.getBusinessHall());
		try {
			userData.update(userPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void endManagement() {
		// TODO Auto-generated method stub
		try {
			userData.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void initial(ArrayList<InitUserVO> User) {
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
	}


}
