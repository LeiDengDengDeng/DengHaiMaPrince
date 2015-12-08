package src.businesslogic.institutionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.institutionblservice.InstitutionBLService;
import src.businesslogicservice.userblservice.UserBLService;
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.dataservice.userdataservice.UserDataService;
import src.po.InstitutionPO;
import src.po.SalaryPO;
import src.po.UserPO;
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
		InstitutionVO institutionVO = new InstitutionVO(institutionPO.getInstitutionName(),
				institutionPO.getInstitutionID(), 
				institutionPO.getStaff(), institutionPO.getFunction());
		
		return institutionVO;
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
		for(int i = 0;i < institutionPOs.size();i++){
			institutionVOs.add(new InstitutionVO(institutionPOs.get(i).getInstitutionName(), 
					institutionPOs.get(i).getInstitutionID(), 
					institutionPOs.get(i).getStaff(), institutionPOs.get(i).getFunction()));
		}
		return institutionVOs;
	}

	@Override
	public void addInstitution(InstitutionVO Institution) {
		// TODO Auto-generated method stub
		InstitutionPO institutionPO = new InstitutionPO(Institution.getInstitutionName(),
				Institution.getInstitutionID(), Institution.getFunction());
		try {
			institutionData.insert(institutionPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void deleteInstitution(long InstitutionId) {
		// TODO Auto-generated method stub
		InstitutionPO institutionPO = null;
		try {
			institutionPO = institutionData.find(InstitutionId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			institutionData.delete(institutionPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void endManagement() {
		// TODO Auto-generated method stub
		try {
			institutionData.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
