package src.businesslogicservice.institutionbl;

import java.util.ArrayList;

import src.businesslogicservice.institutionblService.InstitutionBLService;
import src.po.InstitutionPO;
import src.po.StaffInfoPO;
import src.vo.InstitutionVO;

public class InstitutionBLService_Stub implements InstitutionBLService{
//	String InstitutionName;
//	long InstitutionID;
//	ArrayList<StaffInfoPO> staff;
//	ArrayList<InstitutionPO> institutionPOs = new ArrayList<InstitutionPO>();
//	ArrayList<InstitutionVO> institutionVOs = new ArrayList<InstitutionVO>();
//	String function;
//
//	public InstitutionBLService_Stub(String a,long b,ArrayList<StaffInfoPO> c,String d){
//		InstitutionName = a;
//		InstitutionID = b;
//		staff = c;
//		function = d;
//	}
	
	@Override
	public InstitutionVO getInstitutionInfo(long InstitutionId) {
		// TODO Auto-generated method stub
		System.out.println("get!");
		return new InstitutionVO("apart", InstitutionId, null, "Manage staff");
	}

	@Override
	public ArrayList<InstitutionVO> getAllInstitution() {
		// TODO Auto-generated method stub
		ArrayList<InstitutionVO> institutionVOs = new ArrayList<InstitutionVO>();
		institutionVOs.add(new InstitutionVO("apart", 000000, null, "Manage staff"));
		System.out.println("get all!");
		return institutionVOs;
	}

	@Override
	public void addInstitution(InstitutionPO Institution) {
		// TODO Auto-generated method stub
		System.out.println("add institution succeed!");
		
	}

	@Override
	public void changeStaffPosition(String position, long StaffId) {
		// TODO Auto-generated method stub
		System.out.println("change position succeed!");
	}

	@Override
	public void changeSalary(long StaffId, int salary) {
		// TODO Auto-generated method stub
		System.out.println("change salary succeed!");
	}

	@Override
	public void deleteInstitution(InstitutionPO Institution) {
		// TODO Auto-generated method stub
		System.out.println("delete succeed!");
	}

	@Override
	public void endManagement() {
		// TODO Auto-generated method stub
		System.out.println("End the management!");
		
	}

}
