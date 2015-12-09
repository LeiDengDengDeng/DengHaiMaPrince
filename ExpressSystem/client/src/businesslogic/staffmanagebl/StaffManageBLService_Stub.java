package src.businesslogic.staffmanagebl;

import java.util.ArrayList;

import src.businesslogicservice.staffmanageblservice.StaffManageBLService;
import src.po.UserPO;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class StaffManageBLService_Stub implements StaffManageBLService{
//	ArrayList<Integer> authority = new ArrayList<Integer>();
//	ArrayList<StaffInfoVO> staffInfoVOs = new ArrayList<StaffInfoVO>();
//	ArrayList<StaffInfoPO> staffInfoPOs = new ArrayList<StaffInfoPO>();
//	long personalID;
//	long personalAccount;
//	String myPassword;
//	String personalName;
//	String myPosition;
//	
//	public StaffManageBLService_Stub(long a,long b,String c,String d,String e,
//			ArrayList<Integer> f){
//		authority = f;
//		personalID = a;
//		personalAccount = b;
//		myPassword = c;
//		personalName = d;
//		myPosition = e;
//		
//	}
	
	@Override
	public StaffInfoVO getStaffInfo(long StaffId) {
		// TODO Auto-generated method stub
		System.out.println("get!");
		return new StaffInfoVO(StaffId,StaffId,"aaaaa","Echo","Administrator",null,null,null);
	}

	@Override
	public ArrayList<StaffInfoVO> getAllStaff() {
		// TODO Auto-generated method stub
		ArrayList<StaffInfoVO> staffInfoVOs = new ArrayList<StaffInfoVO>();
		staffInfoVOs.add(new StaffInfoVO(000000, 000000,"aaaaa","Echo","Administrator",null,null,null));
		System.out.println("get all!");
		return staffInfoVOs;
	}

	@Override
	public boolean changeAuthority(ArrayList<Integer> authority, String position) {
		// TODO Auto-generated method stub
		System.out.println("change succeed!");
		return true;
		
	}

	@Override
	public boolean addStaffInfo(StaffInfoVO StaffInfo) {
		// TODO Auto-generated method stub
		System.out.println("add succeed!");
		return true;
		
	}

	@Override
	public boolean deleteStaff(long StaffId) {
		// TODO Auto-generated method stub
		System.out.println("delete succeed!");
		return true;
		
	}

	@Override
	public boolean endManagement() {
		// TODO Auto-generated method stub
		System.out.println("End the management!");
		return true;
		
	}

}
