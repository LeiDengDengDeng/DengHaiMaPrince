package src.businesslogic.accountbl;
import src.businesslogic.accountbl.Account;
import src.businesslogicservice.logblservice.LogBLService;

public class MockAccount extends Account {

	public MockAccount(LogBLService log) {
		super(log);
		// TODO Auto-generated constructor stub
	}
	
	public void updateAmount(){
	System.out.println("Ammount Updated!!!");	
	}
}
