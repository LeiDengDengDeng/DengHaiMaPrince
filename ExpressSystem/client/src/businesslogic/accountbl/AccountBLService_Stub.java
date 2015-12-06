package src.businesslogic.accountbl;

import java.util.ArrayList;

import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.AccountVO;

public class AccountBLService_Stub implements AccountBLService {

	// String AccountName;
	// long AccountID;
	// double AccountAmount;
	// public AccountBLService_Stub(String accountName, long accountID, double
	// accountAmount) {
	// super();
	// AccountName = accountName;
	// AccountID = accountID;
	// AccountAmount = accountAmount;
	// }
	LogBLService log;
	String position = "财务人员";
	ArrayList<AccountVO> a = new ArrayList<AccountVO>();

	public AccountBLService_Stub(LogBLService log) {
		super();
		this.log = log;
		a.add(new AccountVO("李莹", 1000230420303040032L, 100.223));
		a.add(new AccountVO("小王子", 1000100020303030032L, 100.233));
		a.add(new AccountVO("小可爱", 1000100020303030032L, 10077.233));
	}

	@Override
	public boolean islegal(AccountInfoType type, Object info) {
		// TODO Auto-generated method stub
		// if (type == AccountInfoType.NAME) {
		// String name=(String)info;
		// }
		// if (type == AccountInfoType.ID) {
		// long ID=(long)info;
		// }
		// if (type == AccountInfoType.AMOUNT) {
		// double amount=(double)info;
		// }
		return true;
	}

	public boolean addAccount(String name, long num, double amount) {
		a.add(new AccountVO(name,num,amount));	
		return true;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean modAccount(String name, long ID) {
		// TODO Auto-generated method stub
		System.out.println("Modify succeed!");
		log.generateLog(position, "小王子", "修改银行账户", "");
		return false;

	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public void endAccountManagement() {
		// TODO Auto-generated method stub
		System.out.println("End the account!");
	}

	@Override
	public boolean delAccount(long num) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i).getID()==num)
				a.remove(i);
		}
		return false;
	}
}
