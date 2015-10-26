package src.businesslogicservice.StaffManagebl;

import java.util.ArrayList;

import src.businesslogicservice.StaffManageblService.StaffManageBLService;
import src.po.StaffInfoPO;
import src.vo.StaffInfoVO;

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
		return new StaffInfoVO(StaffId,StaffId,"aaaaa","Echo","Administrator",null);
	}

	@Override
	public ArrayList<StaffInfoVO> getAllStaff() {
		// TODO Auto-generated method stub
		ArrayList<StaffInfoVO> staffInfoVOs = new ArrayList<StaffInfoVO>();
		staffInfoVOs.add(new StaffInfoVO(000000, 000000,"aaaaa","Echo","Administrator",null));
		System.out.println("get all!");
		return staffInfoVOs;
	}

	@Override
	public void changeAuthority(ArrayList<Integer> authority, String position) {
		// TODO Auto-generated method stub
		System.out.println("change succeed!");
		
	}

	@Override
	public void addStaffInfo(StaffInfoPO StaffInfo) {
		// TODO Auto-generated method stub
		System.out.println("add succeed!");
		
	}

	@Override
	public void deleteStaff(StaffInfoPO StaffInfo) {
		// TODO Auto-generated method stub
		System.out.println("delete succeed!");
		
	}

	@Override
	public void endManagement() {
		// TODO Auto-generated method stub
		System.out.println("End the management!");
		
	}

}
