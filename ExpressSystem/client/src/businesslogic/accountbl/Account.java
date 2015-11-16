package src.businesslogic.accountbl;

import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.vo.AccountVO;

public class Account implements AccountBLService {


	Log log;
	String position="财务人员";
	public Account(Log log) {
		super();
		this.log = log;
	}

	@Override
	public boolean islegal(AccountInfoType type, Object info) {

		return true;
	}


	public boolean addAccount(String name, long num, double amount) {

			return false;
		// TODO Auto-generated method stub

	}

	@Override
	public void modAccount(long oldID, String name, long ID) {
		// TODO Auto-generated method stub
		


	}

	@Override
	public ArrayList<AccountVO> getAccountList() {

		return null;
	}

	@Override
	public void endAccountManagement() {
		// TODO Auto-generated method stub
	}

	@Override
	public void delAccount(long num) {
		// TODO Auto-generated method stub
	}
	
	public void updateAmount(long ID,double difference){

		}
	
	public void initAmount(ArrayList<AccountVO> vo){
		for (int i = 0; i < vo.size(); i++) {
			AccountVO accountVO=vo.get(i);
			addAccount(accountVO.getName(),accountVO.getID(),accountVO.getAmount());
		}

	}
}
