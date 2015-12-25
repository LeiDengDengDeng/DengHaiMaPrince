package src.businesslogic.staffmanagebl;

import java.util.ArrayList;

import src.businesslogicservice.staffmanageblservice.PositionBLService;
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
		if(staff.getPosition().equals("总经理")){
			authority.add(12);
			authority.add(13);
			authority.add(19);
			authority.add(20);
		}else if(staff.getPosition().equals("管理员")){
			authority.add(1);
			authority.add(18);
		}else if(staff.getPosition().equals("财务人员")){
			authority.add(11);
			authority.add(14);
			authority.add(15);
			authority.add(16);
			authority.add(17);
			authority.add(19);
			authority.add(21);
		}else if(staff.getPosition().equals("中转中心仓库管理员")){
			authority.add(9);
		}else if(staff.getPosition().equals("中转中心业务员")){
			authority.add(2);
			authority.add(6);
		}else if(staff.getPosition().equals("营业厅业务员")){
			authority.add(3);
			authority.add(4);
			authority.add(5);
			authority.add(10);
		}else if(staff.getPosition().equals("快递员")){
			authority.add(7);
			authority.add(8);
		}else{

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
