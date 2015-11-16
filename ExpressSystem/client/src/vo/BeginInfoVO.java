package src.vo;

import java.util.ArrayList;

import src.po.UserPO;

public class BeginInfoVO {
	ArrayList<DriverInfoVO> beginDriver;
	ArrayList<TruckInfoVO> beginTruck;
	ArrayList<AccountVO> beginAccount;
	ArrayList<ConstantVO> beginConstant;
	ArrayList<StorageInitVO> beginStorage;
	ArrayList<UserVO> beginUser;
	public BeginInfoVO(ArrayList<DriverInfoVO> beginDriver, ArrayList<TruckInfoVO> beginTruck,
			ArrayList<AccountVO> beginAccount, ArrayList<ConstantVO> beginConstant,
			ArrayList<StorageInitVO> beginStorage, ArrayList<UserVO> beginUser) {
		super();
		this.beginDriver = beginDriver;
		this.beginTruck = beginTruck;
		this.beginAccount = beginAccount;
		this.beginConstant = beginConstant;
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
	public ArrayList<ConstantVO> getBeginConstant() {
		return beginConstant;
	}
	public ArrayList<StorageInitVO> getBeginStorage() {
		return beginStorage;
	}
	public ArrayList<UserVO> getBeginUser() {
		return beginUser;
	}



}
