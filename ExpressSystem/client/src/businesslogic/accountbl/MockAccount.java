package src.businesslogic.accountbl;
import java.util.ArrayList;

import src.businesslogic.accountbl.Account;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.AccountVO;

public class MockAccount extends Account {

	public MockAccount(LogBLService log) {
		super(log);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<AccountVO> getAccountList() {
		AccountVO vo1=new AccountVO("Ð¡Íõ×Ó", 1234123412341234234L, 20000);
		ArrayList<AccountVO> voList=new ArrayList<AccountVO>();
		return voList;
	}
	
	public void updateAmount(long ID,double Amount){
	System.out.println(ID+"¡®s ammount Updated!!!: "+Amount);	
	}
}
