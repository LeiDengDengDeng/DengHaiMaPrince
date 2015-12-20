package src.vo;

import java.util.ArrayList;

import src.po.UserPO;

public class BeginInfoVO {
	ArrayList<DriverInfoVO> beginDriver;
	ArrayList<TruckInfoVO> beginTruck;
	ArrayList<AccountVO> beginAccount;
	ArrayList<StorageInitVO> beginStorage;
	ArrayList<InitUserVO> beginUser;

	public BeginInfoVO(ArrayList<DriverInfoVO> beginDriver, ArrayList<TruckInfoVO> beginTruck,
			ArrayList<AccountVO> beginAccount, ArrayList<StorageInitVO> beginStorage, ArrayList<InitUserVO> beginUser) {
		super();
		this.beginDriver = beginDriver;
		this.beginTruck = beginTruck;
		this.beginAccount = beginAccount;
		this.beginStorage = beginStorage;
		this.beginUser = beginUser;
	}

	public ArrayList<DriverInfoVO> getBeginDriver() {
		return beginDriver;
	}

	public ArrayList<TruckInfoVO> getBeginTruck() {
		return beginTruck;
	}

	public ArrayList<AccountVO> getBeginAccount() {
		return beginAccount;
	}

	public ArrayList<StorageInitVO> getBeginStorage() {
		return beginStorage;
	}

	public ArrayList<InitUserVO> getBeginUser() {
		return beginUser;
	}

}
