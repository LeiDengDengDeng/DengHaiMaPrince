package src.businesslogic.institutionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.institutionblservice.InstitutionBLService;
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.po.InstitutionPO;
import src.vo.InstitutionVO;
import src.vo.SalaryVO;
import src.vo.UserVO;

public class Institution implements InstitutionBLService{
	
	InstitutionDataService institutionData;
	Log log;
	public Institution(Log log){
		this.log = log;
		try {
			this.institutionData = (InstitutionDataService)Naming.lookup("rmi://127.0.0.1:6600/institutionData");
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
	public InstitutionVO getInstitutionInfo(long InstitutionId) {
		// TODO Auto-generated method stub
		InstitutionPO institutionPO = null;
		try {
			institutionPO = institutionData.find(InstitutionId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(institutionPO == null){
			System.out.println("Not exist!!");
			return null;
		}else{
			ArrayList<UserVO> userVOs = new ArrayList<UserVO>();
			for(int i = 0; i < institutionPO.getStaff().size();i++){
				SalaryVO salaryVO = new SalaryVO(institutionPO.getStaff().get(i).getSalary().getBasic());
				salaryVO.setCommission(institutionPO.getStaff().get(i).getSalary().getCommission());
				salaryVO.setEachPay(institutionPO.getStaff().get(i).getSalary().getEachPay());
				salaryVO.setTime(institutionPO.getStaff().get(i).getSalary().getTime());
				userVOs.add(new UserVO(institutionPO.getStaff().get(i).getPersonalID(),
						institutionPO.getStaff().get(i).getPersonalAccount(),
						institutionPO.getStaff().get(i).getMyPassword(),
						institutionPO.getStaff().get(i).getPersonalName(),
						institutionPO.getStaff().get(i).getMyPosition(),
						institutionPO.getStaff().get(i).getAuthority(),
						salaryVO,
						institutionPO.getStaff().get(i).getCity(),
						institutionPO.getStaff().get(i).getBusinessHall()));
			}
			InstitutionVO institutionVO = new InstitutionVO(institutionPO.getInstitutionName(),
					institutionPO.getInstitutionID(), 
					userVOs, institutionPO.getFunction());
		
			return institutionVO;
		}
	}

	@Override
	public ArrayList<InstitutionVO> getAllInstitution() {
		// TODO Auto-generated method stub
		ArrayList<InstitutionPO> institutionPOs = new ArrayList<InstitutionPO>();
		ArrayList<InstitutionVO> institutionVOs = new ArrayList<InstitutionVO>();
		try {
			institutionPOs = institutionData.finds();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(institutionPOs == null){
			System.out.println("None!!");
			return null;
		}else{
			for(int i = 0;i < institutionPOs.size();i++){
				ArrayList<UserVO> userVOs = new ArrayList<UserVO>();
				for(int j = 0; j < institutionPOs.get(i).getStaff().size();j++){
					SalaryVO salaryVO = new SalaryVO(institutionPOs.get(i).getStaff().get(j).getSalary().getBasic());
					salaryVO.setCommission(institutionPOs.get(i).getStaff().get(j).getSalary().getCommission());
					salaryVO.setEachPay(institutionPOs.get(i).getStaff().get(j).getSalary().getEachPay());
					salaryVO.setTime(institutionPOs.get(i).getStaff().get(j).getSalary().getTime());
					userVOs.add(new UserVO(institutionPOs.get(i).getStaff().get(j).getPersonalID(),
							institutionPOs.get(i).getStaff().get(j).getPersonalAccount(),
							institutionPOs.get(i).getStaff().get(j).getMyPassword(),
							institutionPOs.get(i).getStaff().get(j).getPersonalName(),
							institutionPOs.get(i).getStaff().get(j).getMyPosition(),
							institutionPOs.get(i).getStaff().get(j).getAuthority(),
							salaryVO,
							institutionPOs.get(i).getStaff().get(j).getCity(),
							institutionPOs.get(i).getStaff().get(j).getBusinessHall()));
				}
				institutionVOs.add(new InstitutionVO(institutionPOs.get(i).getInstitutionName(), 
						institutionPOs.get(i).getInstitutionID(), 
						userVOs, institutionPOs.get(i).getFunction()));
			}
			return institutionVOs;
		}
	}

	@Override
	public boolean addInstitution(InstitutionVO Institution) {
		// TODO Auto-generated method stub
		if(Institution == null)
			return false;
		
		else{
			InstitutionPO institutionPO = new InstitutionPO(Institution.getInstitutionName(),
					Institution.getInstitutionID(), Institution.getFunction());
			try {
				institutionData.insert(institutionPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("add successfully!");
			return true;
		}
	}


//	@Override
//	public void changeSalary(long StaffId, SalaryVO salary) {
//		// TODO Auto-generated method stub
//		SalaryPO salaryPO = new SalaryPO(salary.getBasic());
//		salaryPO.setCommission(salary.getCommission());
//		salaryPO.setTime(salary.getTime());
//		UserVO userVO = userBL.getPersonalInfo(StaffId);
//		userVO.setSalary(salaryPO);
//		userBL.changeInfo(userVO);	
//		
//	}

	@Override
	public boolean deleteInstitution(long InstitutionId) {
		// TODO Auto-generated method stub
		InstitutionPO institutionPO = null;
		try {
			institutionPO = institutionData.find(InstitutionId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(institutionPO == null){
			System.out.println("Not exist!!");
			return false;
		}
		
		else{
			try {
				institutionData.delete(institutionPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}

	@Override
	public boolean endManagement() {
		// TODO Auto-generated method stub
		try {
			institutionData.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		Institution institution = new Institution(null);
		System.out.println(institution.getInstitutionInfo(100000).getInstitutionName());
//		institution.addInstitution(new InstitutionVO("营业厅", 100000, null, "中转与接收"));
	}

}
