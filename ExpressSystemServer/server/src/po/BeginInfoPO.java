package src.po;

import java.io.Serializable;
import java.util.ArrayList;

public class BeginInfoPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 722606905171710148L;

	ArrayList<DriverPO> beginDriver;
	ArrayList<TruckPO> beginTruck;
	ArrayList<AccountPO> beginAccount;
	ArrayList<StorageInitPO> beginStorage;
	ArrayList<InitUserPO> beginUser;
	public BeginInfoPO(ArrayList<DriverPO> beginDriver, ArrayList<TruckPO> beginTruck,
			ArrayList<AccountPO> beginAccount, ArrayList<StorageInitPO> beginStorage, ArrayList<InitUserPO> beginUser) {
		super();
		this.beginDriver = beginDriver;
		this.beginTruck = beginTruck;
		this.beginAccount = beginAccount;
		this.beginStorage = beginStorage;
		this.beginUser = beginUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<DriverPO> getBeginDriver() {
		return beginDriver;
	}
	public ArrayList<TruckPO> getBeginTruck() {
		return beginTruck;
	}
	public ArrayList<AccountPO> getBeginAccount() {
		return beginAccount;
	}
	public ArrayList<StorageInitPO> getBeginStorage() {
		return beginStorage;
	}
	public ArrayList<InitUserPO> getBeginUser() {
		return beginUser;
	}
	
}
