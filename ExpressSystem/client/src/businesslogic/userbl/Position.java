package src.businesslogic.userbl;

import java.util.ArrayList;

import src.businesslogicservice.userblservice.PositionBLService;
import src.businesslogicservice.userblservice.UserBLService;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class Position implements PositionBLService{
	
	UserBLService userBL;
	
	public Position(UserBLService userBL){
		this.userBL = userBL;
	}
	
	@Override
	public ArrayList<Integer> initialAuthority(StaffInfoVO staff) {
		// TODO Auto-generated method stub
		ArrayList<Integer> authority = new ArrayList<Integer>();
//		System.out.println(staff.getPosition());
		switch (staff.getPosition()) {
		case "总经理":
			authority.add(12);
			authority.add(13);
			authority.add(14);
			authority.add(19);
			authority.add(20);
			break;
		case "管理员":
			authority.add(1);
			authority.add(18);
			break;
		case "财务人员":
			authority.add(11);
			authority.add(14);
			authority.add(15);
			authority.add(16);
			authority.add(17);
			authority.add(19);
			break;
		case "中转中心仓库管理员":
			authority.add(9);
			break;
		case "中转中心业务员":
			authority.add(2);
			authority.add(6);
			break;
		case "营业厅业务员":
			authority.add(3);
			authority.add(4);
			authority.add(5);
			authority.add(10);
			break;
		case "快递员":
			authority.add(7);
			authority.add(8);
			break;
		default:
			break;
		}
		
		return authority;
	}
	
	@Override
	public boolean changeStaffPosition(String position, long StaffId) {
		// TODO Auto-generated method stub
		UserVO userVO = userBL.getPersonalInfo(StaffId);
		userVO.setMyPosition(position);
		userBL.changeInfo(userVO);		
		
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
		
		return true;
		
		
	}
	@Override
	public boolean setBusinessHall(String businessHall, long StaffId) {
		// TODO Auto-generated method stub
		UserVO userVO = userBL.getPersonalInfo(StaffId);
		userVO.setBusinessHall(businessHall);
		userBL.changeInfo(userVO);
		
		return true;
	}
	
//	public static void main(String[] args) {
//		Position position = new Position(new User(null));
//		position.initialAuthority(new StaffInfoVO(200000, 200000, "123456", "小燕子", "快递员", null, null, null));
//		System.out.println(position.initialAuthority(new StaffInfoVO(200000, 200000, "123456", "小燕子", "快递员", null, null, null)).size());
//	}

}
