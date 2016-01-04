package src.businesslogic.staffmanagebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.positionbl.Position;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.staffmanageblservice.StaffManageBLService;
import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.main.ExpressSystem;
import src.po.UserPO;
import src.vo.StaffInfoVO;

public class StaffManage implements StaffManageBLService{

	StaffManageDataService staffManageData;
	Position position;
//	Institution institution;
//	User user;
	LogBLService log;
	public StaffManage(LogBLService log,Position position){
		this.log = log;
		this.position = position;
		try {
			this.staffManageData = (StaffManageDataService) Naming.lookup("rmi://"
					+ ExpressSystem.RMI_IP + ":6600/staffManageData");
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
	public StaffInfoVO getStaffInfo(long StaffId) {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		StaffInfoVO staffInfoVO = null;
		try {
			userPO = staffManageData.find(StaffId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userPO != null)
			staffInfoVO  = new StaffInfoVO(StaffId, userPO.getPersonalAccount(),
				userPO.getMyPassword(), userPO.getPersonalName(),
				userPO.getMyPosition(), userPO.getAuthority(),
				userPO.getCity(),userPO.getBusinessHall());
		else  System.out.println("Not exist!!");
		
		return staffInfoVO;
	}

	@Override
	public ArrayList<StaffInfoVO> getAllStaff() {
		// TODO Auto-generated method stub
		ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
		ArrayList<StaffInfoVO> staffInfoVOs = new ArrayList<StaffInfoVO>();
		try {
			userPOs = staffManageData.finds();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userPOs != null){
			for(int i = 0;i < userPOs.size();i++){
				StaffInfoVO staffInfoVO = new StaffInfoVO(userPOs.get(i).getPersonalID(), 
						userPOs.get(i).getPersonalAccount(), userPOs.get(i).getMyPassword(),
						userPOs.get(i).getPersonalName(), userPOs.get(i).getMyPosition(),
						userPOs.get(i).getAuthority(),userPOs.get(i).getCity(),
						userPOs.get(i).getBusinessHall());
				staffInfoVOs.add(staffInfoVO);
			}
			return staffInfoVOs;
		}else{
			System.out.println("None!!");
			return null;
		}
	}

	@Override
	public boolean changeAuthority(ArrayList<Integer> authority, String position) {
		// TODO Auto-generated method stub
		if(position == null) 
			return false;
		else{
			ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
			try {
				userPOs = staffManageData.finds();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			for(int i = 0;i < userPOs.size();i++){
				if(userPOs.get(i).getMyPosition().equals(position)){
					userPOs.get(i).setAuthority(authority);
					try {
						staffManageData.update(userPOs.get(i));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
			
				}
			log.generateLog("修改权限", position);
			return true;
		}
	}

	@Override
	public boolean addStaffInfo(StaffInfoVO StaffInfo) {
		// TODO Auto-generated method stub
		boolean exist = true;
		if(StaffInfo == null){
		}
		else{
			if(getStaffInfo(StaffInfo.getID()) != null){
				
			}else{
				StaffInfo.setAuthority(position.initialAuthority(StaffInfo));
				UserPO userPO = new UserPO(StaffInfo.getID(), StaffInfo.getAccount(),
						StaffInfo.getPassword(), StaffInfo.getStaffName(),
						StaffInfo.getPosition(), StaffInfo.getAuthority());
				userPO.setCity(StaffInfo.getCity());
				userPO.setBusinessHall(StaffInfo.getBusinessHall());
				try {
					staffManageData.insert(userPO);
						log.generateLog("增加员工账号", String.valueOf(userPO.getPersonalID()));
					} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				exist = false;
//				UserVO userVO = user.getPersonalInfo(StaffInfo.getID());
//				ArrayList<InstitutionVO> institutionVOs = institution.getAllInstitution();
//				ArrayList<UserVO> userVOs = new ArrayList<UserVO>();
//				for(int i = 0;i < institutionVOs.size();i++){
//					userVOs = institutionVOs.get(i).getStaff();
//					if(userVO.getMyPosition().equals("财务人员")){
//						if(institutionVOs.get(i).getInstitutionName().equals("财务部")){
//							userVOs.add(userVO);
//							institutionVOs.get(i).setStaff(userVOs);
//							institution.changeInstitutionInfo(institutionVOs.get(i));
//							break;
//						}
//					}else if(userVO.getMyPosition().equals("管理员") ||
//							userVO.getMyPosition().equals("总经理")){
//						if(institutionVOs.get(i).getInstitutionName().equals("管理部")){
//							userVOs.add(userVO);
//							institutionVOs.get(i).setStaff(userVOs);
//							institution.changeInstitutionInfo(institutionVOs.get(i));
//							break;
//						}
//					}else if(institutionVOs.get(i).getInstitutionName().contains(userVO.getCity())
//							&& institutionVOs.get(i).getInstitutionName().contains("中转中心")
//							&& userVO.getMyPosition().contains("中转中心")){
//						userVOs.add(userVO);
//						institutionVOs.get(i).setStaff(userVOs);
//						institution.changeInstitutionInfo(institutionVOs.get(i));
//						break;
//					}else if(institutionVOs.get(i).getInstitutionName().equals(userVO.getCity()
//							+ userVO.getBusinessHall())){
//						userVOs.add(userVO);
//						institutionVOs.get(i).setStaff(userVOs);
//						institution.changeInstitutionInfo(institutionVOs.get(i));
//						break;
//					}
//				}
			}
		}
		return exist;
	}

	@Override
	public boolean deleteStaff(long StaffId) {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		try {
			userPO = staffManageData.find(StaffId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userPO != null){
			try {
				staffManageData.delete(userPO);
				log.generateLog("删除员工账号", String.valueOf(userPO.getPersonalID()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else{
			System.out.println("Not exist!!");
			return false;
		}
	}

	@Override
	public boolean endManagement() {
		// TODO Auto-generated method stub
		try {
			staffManageData.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}


//	public static void main(String[] args) {
//		StaffManage staffManage = new StaffManage(null, new Position(new User(null)));
//		staffManage.addStaffInfo(new StaffInfoVO(700000, 700000, "123456", "小燕子", "快递员", null, null, null));
//		staffManage.deleteStaff(100000);
//		System.out.println(staffManage.getStaffInfo(200000).getPosition());
//		if(staffManage.getStaffInfo(200000).getAuthority() == null)
//			System.out.println("null");
//		else
//			System.out.println(staffManage.getStaffInfo(700000).getAuthority().size());
//		System.out.println(staffManage.getStaffInfo(100000).getPosition());
//		System.out.println(staffManage.getAllStaff().size());
//	}

}
