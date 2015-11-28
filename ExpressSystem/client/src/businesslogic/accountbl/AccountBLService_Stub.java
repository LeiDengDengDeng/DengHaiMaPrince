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
	String position = "������Ա";

	public AccountBLService_Stub(LogBLService log) {
		super();
		this.log = log;
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
		if (name == "С����") {
			log.generateLog(position, "С����", "����һ���˻�", "");
			return true;
		} else
			return false;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean modAccount(String name, long ID) {
		// TODO Auto-generated method stub
		System.out.println("Modify succeed!");
		log.generateLog(position, "С����", "�޸������˻�", "");
		return false;

	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> a = new ArrayList<AccountVO>();
		a.add(new AccountVO("��Ө", 1000230420303040032L, 100.223));
		a.add(new AccountVO("С����", 1000100020303030032L, 100.233));
		a.add(new AccountVO("С�ɰ�", 1000100020303030032L, 100.233));
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
		if (num == 1234122222)
			System.out.println("Delete the account!");
		return false;
	}
}
