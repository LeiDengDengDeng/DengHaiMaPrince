package src.po;

import java.io.Serializable;
import java.util.ArrayList;

public class BeginInfoPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 722606905171710148L;

	ArrayList<DriverPO> beginDriver;
	ArrayList<InstitutionPO> beginInstitution;
	ArrayList<TruckPO> beginTruck;
	ArrayList<AccountPO> beginAccount;
	ConstantPO beginConstant;
	ArrayList<StaffInfoPO> beginStaffInfo;
	StoragePO beginStorage;
	ArrayList<UserPO> beginUser; 
}
