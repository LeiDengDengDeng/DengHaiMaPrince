package src.businesslogic.institutionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.institutionblservice.InstitutionBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.po.InstitutionPO;
import src.po.SalaryPO;
import src.po.UserPO;
import src.vo.InstitutionVO;
import src.vo.SalaryVO;
import src.vo.UserVO;

public class Institution implements InstitutionBLService{
	
	InstitutionDataService institutionData;
	LogBLService log;
	public Institution(LogBLService log){
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
			if(institutionData.find(InstitutionId) == null) System.out.println("null");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(institutionPO != null){
			ArrayList<UserVO> userVOs = new ArrayList<UserVO>();
			if(institutionPO.getStaff() != null){
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
			}else{
				userVOs = null;
			}
			InstitutionVO institutionVO = new InstitutionVO(institutionPO.getInstitutionName(),
					institutionPO.getInstitutionID(), 
					userVOs, institutionPO.getFunction());
		
			return institutionVO;
		}else {
			System.out.println("Not exist!!");
			return null;
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
				if(institutionPOs.get(i).getStaff() != null){
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
				}else{
					userVOs = null;
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
				log.generateLog("增加机构", institutionPO.getInstitutionName());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("add successfully!");
			return true;
		}
	}

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
				log.generateLog("删除机构", institutionPO.getInstitutionName());
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
	
//	public static void main(String[] args) {
//		Institution institution = new Institution(null);
////		System.out.println(institution.getInstitutionInfo(100000).getInstitutionName());
//		institution.addInstitution(new InstitutionVO("财务部", 300000, null, "管理财务"));
//	}

	@Override
	public boolean changeInstitutionInfo(InstitutionVO institutionVO) {
		// TODO Auto-generated method stub
		if(institutionVO == null)
			return false;
		else{
			InstitutionPO institutionPO = new InstitutionPO(institutionVO.getInstitutionName(),
					institutionVO.getInstitutionID(), institutionVO.getFunction());
			ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
			for(int i = 0;i < institutionVO.getStaff().size();i++){
				UserPO userPO = new UserPO(institutionVO.getStaff().get(i).getpersonalID(),
						institutionVO.getStaff().get(i).getpersonalAccount(),
						institutionVO.getStaff().get(i).getMyPassword(),
						institutionVO.getStaff().get(i).getpersonalName(),
						institutionVO.getStaff().get(i).getMyPosition(),
						institutionVO.getStaff().get(i).getAuthority());
				userPO.setCity(institutionVO.getStaff().get(i).getCity());
				userPO.setBusinessHall(institutionVO.getStaff().get(i).getBusinessHall());
			
				SalaryPO salaryPO = new SalaryPO(institutionVO.getStaff().get(i).getSalary().getBasic());
				salaryPO.setCommission(institutionVO.getStaff().get(i).getSalary().getCommission());
				salaryPO.setEachPay(institutionVO.getStaff().get(i).getSalary().getEachPay());
				salaryPO.setTime(institutionVO.getStaff().get(i).getSalary().getTime());
			
				userPO.setSalary(salaryPO);
				userPOs.add(userPO);
			}
			institutionPO.setStaff(userPOs);
			try {
				institutionData.update(institutionPO);
				log.generateLog("更新机构信息", institutionPO.getInstitutionName());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}	
	}

}
