package src.businesslogic.institutionbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.staffmanagebl.StaffManage;
import src.businesslogic.userbl.User;
import src.businesslogicservice.institutionblservice.InstitutionBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.main.ExpressSystem;
import src.po.InstitutionPO;
import src.po.SalaryPO;
import src.po.UserPO;
import src.vo.InstitutionVO;
import src.vo.SalaryVO;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class Institution implements InstitutionBLService{
	
	InstitutionDataService institutionData;
	LogBLService log;
	User user;
	StaffManage staffManage;
	public Institution(LogBLService log,User user,StaffManage staffManage){
		this.log = log;
		this.user = user;
		this.staffManage = staffManage;
		try {
			this.institutionData = (InstitutionDataService)Naming.lookup("rmi://"
					+ ExpressSystem.RMI_IP + ":6600/institutionData");
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
				ArrayList<UserVO> vos = new ArrayList<UserVO>();
				ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
				ArrayList<StaffInfoVO> staffInfoVOs = staffManage.getAllStaff();
				System.out.println(staffInfoVOs.size());
				//跟新机构员工列表的信息
				for(int k = 0; k < staffInfoVOs.size();k++){
					if(institutionPOs.get(i).getInstitutionName().equals("财务部")){
						if(staffInfoVOs.get(k).getPosition().equals("财务人员")){
							UserVO u = user.getPersonalInfo(staffInfoVOs.get(k).getID());
							vos.add(u);
						}
					}else if(institutionPOs.get(i).getInstitutionName().equals(staffInfoVOs.get(k).getCity()
							+ staffInfoVOs.get(k).getBusinessHall())){
						UserVO u = user.getPersonalInfo(staffInfoVOs.get(k).getID());
						vos.add(u);
					}else if(institutionPOs.get(i).getInstitutionName().contains("中转中心") && 
							staffInfoVOs.get(k).getPosition().contains("中转中心")){
						char[] c = new char[2];
						c[0] = institutionPOs.get(i).getInstitutionName().charAt(0);
						c[1] = institutionPOs.get(i).getInstitutionName().charAt(1);
						String city = String.valueOf(c);
						if(staffInfoVOs.get(k).getCity().equals(city)){
							UserVO u = user.getPersonalInfo(staffInfoVOs.get(k).getID());
							vos.add(u);
						}
					}else if(institutionPOs.get(i).getInstitutionName().equals("管理部")){
						if(staffInfoVOs.get(k).getPosition().equals("管理员") ||
								staffInfoVOs.get(k).getPosition().equals("总经理")){
							UserVO u = user.getPersonalInfo(staffInfoVOs.get(k).getID());
							vos.add(u);
						}
					}else if(institutionPOs.get(i).getInstitutionName().equals(
							staffInfoVOs.get(k).getBusinessHall())){
						UserVO u = user.getPersonalInfo(staffInfoVOs.get(k).getID());
						vos.add(u);
					}
				}
				InstitutionVO insVo = new InstitutionVO(institutionPOs.get(i).getInstitutionName(),
						institutionPOs.get(i).getInstitutionID(), vos,
						institutionPOs.get(i).getFunction());
				changeInstitutionInfo(insVo);
			}
			try {
				institutionPOs = institutionData.finds();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			if(getInstitutionInfo(Institution.getInstitutionID()) != null){
				System.out.println("Already exist!!!");
				return false;
			}else{
				ArrayList<UserVO> userVOs = new ArrayList<UserVO>();
				ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
				ArrayList<StaffInfoVO> staffInfoVOs = staffManage.getAllStaff();
				//跟新机构员工列表的信息
				for(int i = 0; i < staffInfoVOs.size();i++){
					if(Institution.getInstitutionName().equals("财务部")){
						if(staffInfoVOs.get(i).getPosition().equals("财务人员")){
							UserVO u = user.getPersonalInfo(staffInfoVOs.get(i).getID());
							userVOs.add(u);
						}
					}else if(Institution.getInstitutionName().equals(staffInfoVOs.get(i).getCity()
							+ staffInfoVOs.get(i).getBusinessHall())){
						UserVO u = user.getPersonalInfo(staffInfoVOs.get(i).getID());
						userVOs.add(u);
					}else if(Institution.getInstitutionName().contains("中转中心") &&
							(staffInfoVOs.get(i).getPosition().contains("中转中心"))){
						char[] c = new char[2];
						c[0] = Institution.getInstitutionName().charAt(0);
						c[1] = Institution.getInstitutionName().charAt(1);
						String city = String.valueOf(c); 
						System.out.println(city);
						System.out.println(staffInfoVOs.get(i).getID());
						System.out.println(staffInfoVOs.get(i).getCity());
						System.out.println(staffInfoVOs.get(i).getPosition());
						if((staffInfoVOs.get(i).getCity().equals(city))){
							UserVO u = user.getPersonalInfo(staffInfoVOs.get(i).getID());
							userVOs.add(u);
						}
					}else if(Institution.getInstitutionName().equals("管理部")){
						if(staffInfoVOs.get(i).getPosition().equals("管理员") ||
								staffInfoVOs.get(i).getPosition().equals("总经理")){
							UserVO u = user.getPersonalInfo(staffInfoVOs.get(i).getID());
							userVOs.add(u);
						}
					}else if(Institution.getInstitutionName().equals(
							staffInfoVOs.get(i).getBusinessHall())){
						UserVO u = user.getPersonalInfo(staffInfoVOs.get(i).getID());
						userVOs.add(u);
					}
				}
				InstitutionPO institutionPO = null;
				institutionPO = new InstitutionPO(Institution.getInstitutionName(),
						Institution.getInstitutionID(), Institution.getFunction());
				for(int i = 0;i < userVOs.size();i++){
					UserPO po = new UserPO(userVOs.get(i).getpersonalID(),
							userVOs.get(i).getpersonalAccount(), userVOs.get(i).getMyPassword(),
							userVOs.get(i).getpersonalName(),
							userVOs.get(i).getMyPosition(), userVOs.get(i).getAuthority());
					SalaryPO salaryPO = new SalaryPO(userVOs.get(i).getSalary().getBasic());
					salaryPO.setCommission(userVOs.get(i).getSalary().getCommission());
					salaryPO.setEachPay(userVOs.get(i).getSalary().getEachPay());
					salaryPO.setTime(userVOs.get(i).getSalary().getTime());
					po.setSalary(salaryPO);
					po.setCity(userVOs.get(i).getCity());
					po.setBusinessHall(userVOs.get(i).getBusinessHall());
					userPOs.add(po);
				}
				institutionPO.setStaff(userPOs);
			
				try {
					institutionData.insert(institutionPO);
					log.generateLog("增加机构", String.valueOf(Institution.getInstitutionID()));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("add successfully!");
				return true;
			}
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
		}else{
			try {
				institutionData.delete(institutionPO);
				log.generateLog("删除机构", String.valueOf(InstitutionId));
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
//		Institution institution = new Institution(null, new User(null), new StaffManage(null, null));
//		institution.deleteInstitution(300000);
//		System.out.println(institution.getInstitutionInfo(500000).getInstitutionName());
//		institution.addInstitution(new InstitutionVO("上海中转中心", 500000, null, "负责中转与接收"));
//		char[] c = new char[2];
//		c[0] = institution.getInstitutionInfo(100000).getInstitutionName().charAt(0);
//		c[1] = institution.getInstitutionInfo(100000).getInstitutionName().charAt(1);
//		String city = String.valueOf(c); 
//		System.out.println(city);
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
				log.generateLog("更新机构信息", String.valueOf(institutionVO.getInstitutionID()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}	
	}

}
