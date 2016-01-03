package src.businesslogic.positionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.positionblservice.PositionBLService;
import src.businesslogicservice.userblservice.UserBLService;
import src.data.positiondataservice.PositionDataservice;
import src.po.AuthorityPO;
import src.vo.AuthorityVO;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class Position implements PositionBLService{
	PositionDataservice positionData;
	UserBLService userBL;
	LogBLService log;
	
	public Position(UserBLService userBL,LogBLService log){
		this.userBL = userBL;
		this.log = log;
		try {
			this.positionData = (PositionDataservice) Naming.lookup("rmi://127.0.0.1:6600/positionData");
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
	public ArrayList<Integer> initialAuthority(StaffInfoVO staff) {
		// TODO Auto-generated method stub
			AuthorityPO authorityPO = null;
			try {
				authorityPO = positionData.find(staff.getPosition());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(authorityPO != null){
				return authorityPO.getAuthority();
			}else {
				System.out.println("invalid!!");
				return null;
			}
	}
	
	@Override
	public boolean changeStaffPosition(String position, long StaffId) {
		// TODO Auto-generated method stub
		UserVO userVO = userBL.getPersonalInfo(StaffId);
		userVO.setMyPosition(position);
		userBL.changeInfo(userVO);		
		log.generateLog("修改员工职位", String.valueOf(StaffId));
		return true;
	}
	
	
	
	@Override
	public boolean setCity(String city, long StaffId) {
		// TODO Auto-generated method stub
		UserVO userVO = userBL.getPersonalInfo(StaffId);
//		UserPO userPO = new UserPO(userVO.getpersonalID(), userVO.getpersonalAccount(),
//				userVO.getMyPassword(), userVO.getpersonalName(),
//				userVO.getMyPosition(), userVO.getAuthority());
		userVO.setCity(city);
		userBL.changeInfo(userVO);
		log.generateLog("设置员工所在城市", String.valueOf(StaffId));
		
		return true;
		
		
	}
	@Override
	public boolean setBusinessHall(String businessHall, long StaffId) {
		// TODO Auto-generated method stub
		UserVO userVO = userBL.getPersonalInfo(StaffId);
		userVO.setBusinessHall(businessHall);
		userBL.changeInfo(userVO);
		log.generateLog("设置员工所属营业厅", String.valueOf(StaffId));
		return true;
	}

	@Override
	public boolean changeAuthority(AuthorityVO authorityVO) {
		// TODO Auto-generated method stub
		AuthorityPO authorityPO = new AuthorityPO(authorityVO.getPosition());
		authorityPO.setAuthority(authorityVO.getAuthority());
		try {
			positionData.update(authorityPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
//	public static void main(String[] args) {
//		Position position = new Position(new User(null));
//		position.initialAuthority(new StaffInfoVO(200000, 200000, "123456", "小燕子", "快递员", null, null, null));
//		System.out.println(position.initialAuthority(new StaffInfoVO(200000, 200000, "123456", "小燕子", "快递员", null, null, null)).size());
//	}

}
