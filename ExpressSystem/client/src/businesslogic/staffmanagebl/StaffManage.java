package src.businesslogic.staffmanagebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogic.userbl.Position;
import src.businesslogicservice.staffmanageblservice.StaffManageBLService;
import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.po.UserPO;
import src.vo.StaffInfoVO;

public class StaffManage implements StaffManageBLService{

	StaffManageDataService StaffManageData;
	Position position;
	Log log;
	public StaffManage(Log log,Position position){
		this.log = log;
		this.position = position;
		try {
			this.StaffManageData = (StaffManageDataService) Naming.lookup("rmi://127.0.0.1:6600/staffManageData");
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
			userPO = StaffManageData.find(StaffId);
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
			userPOs = StaffManageData.finds();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0;i < userPOs.size();i++){
			staffInfoVOs.add(new StaffInfoVO(userPOs.get(i).getPersonalID(), 
					userPOs.get(i).getPersonalAccount(), userPOs.get(i).getMyPassword(),
					userPOs.get(i).getPersonalName(), userPOs.get(i).getMyPosition(),
					userPOs.get(i).getAuthority(),userPOs.get(i).getCity(),
					userPOs.get(i).getBusinessHall()));
		}
		
		return staffInfoVOs;
	}

	@Override
	public boolean changeAuthority(ArrayList<Integer> authority, String position) {
		// TODO Auto-generated method stub
		if(position == null) 
			return false;
		else{
			
			ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
			try {
				userPOs = StaffManageData.finds();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			for(int i = 0;i < userPOs.size();i++){
				if(userPOs.get(i).getMyPosition().equalsIgnoreCase(position)){
					userPOs.get(i).setAuthority(authority);
					try {
						StaffManageData.update(userPOs.get(i));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
			
				}
			return true;
		}
	}

	@Override
	public boolean addStaffInfo(StaffInfoVO StaffInfo) {
		// TODO Auto-generated method stub
		if(StaffInfo == null)
			return false;
		
		else{
			StaffInfo.setAuthority(position.initialAuthority(StaffInfo));
		
			UserPO userPO = new UserPO(StaffInfo.getID(), StaffInfo.getAccount(),
					StaffInfo.getPassword(), StaffInfo.getStaffName(),
					StaffInfo.getPosition(), StaffInfo.getAuthority());
			try {
				StaffManageData.insert(userPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return true;
		}
	}

	@Override
	public boolean deleteStaff(long StaffId) {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		try {
			userPO = StaffManageData.find(StaffId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userPO != null){
			try {
				StaffManageData.delete(userPO);
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
			StaffManageData.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}



}
