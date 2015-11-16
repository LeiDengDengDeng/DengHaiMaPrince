package src.businesslogic.accountbl;

import java.util.ArrayList;

import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.AccountVO;

public class Account implements AccountBLService {


	LogBLService log;
	String position="财务人员";
	public Account(LogBLService log) {
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
	public void modAccount(long ID, String name, double amount) {
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
	
	public void updateAmount(long ID,double Amount){

		}
}
