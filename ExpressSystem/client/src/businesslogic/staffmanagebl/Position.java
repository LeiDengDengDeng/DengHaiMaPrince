package src.businesslogic.staffmanagebl;

import java.util.ArrayList;

import src.businesslogicservice.staffmanageblservice.PositionBLService;
import src.businesslogicservice.userblservice.UserBLService;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class Position implements PositionBLService{
	
	UserBLService userBL;
	public static ArrayList<Integer> managerArrayList;
	public static ArrayList<Integer> administratorArrayList;
	public static ArrayList<Integer> accountantArrayList;
	public static ArrayList<Integer> keeperArrayList;
	public static ArrayList<Integer> interArrayList;
	public static ArrayList<Integer> businessArrayList;
	public static ArrayList<Integer> courierArrayList;
	public static boolean ischanged = false;
	
	public Position(UserBLService userBL){
		this.userBL = userBL;
		if(!ischanged){
			managerArrayList.add(12);
			managerArrayList.add(13);
			managerArrayList.add(19);
			managerArrayList.add(20);
			administratorArrayList.add(1);
			administratorArrayList.add(18);
			accountantArrayList.add(11);
			accountantArrayList.add(14);
			accountantArrayList.add(15);
			accountantArrayList.add(16);
			accountantArrayList.add(17);
			accountantArrayList.add(19);
			accountantArrayList.add(21);
			keeperArrayList.add(9);
			interArrayList.add(2);
			interArrayList.add(6);
			businessArrayList.add(3);
			businessArrayList.add(4);
			businessArrayList.add(5);
			businessArrayList.add(10);
			courierArrayList.add(7);
			courierArrayList.add(8);
		}
	}
	
	@Override
	public ArrayList<Integer> initialAuthority(StaffInfoVO staff) {
		// TODO Auto-generated method stub
		if(staff.getPosition().equals("总经理")){
			return managerArrayList;
		}else if(staff.getPosition().equals("管理员")){
			return administratorArrayList;
		}else if(staff.getPosition().equals("财务人员")){
			return accountantArrayList;
		}else if(staff.getPosition().equals("中转中心仓库管理员")){
			return keeperArrayList;
		}else if(staff.getPosition().equals("中转中心业务员")){
			return interArrayList;
		}else if(staff.getPosition().equals("营业厅业务员")){
			return businessArrayList;
		}else if(staff.getPosition().equals("快递员")){
			return courierArrayList;
		}else{
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
