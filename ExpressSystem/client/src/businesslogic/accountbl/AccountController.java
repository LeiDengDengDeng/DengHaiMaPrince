package src.businesslogic.accountbl;

import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.vo.AccountVO;

public class AccountController {
	Log log;
	AccountBLService account;
	public AccountController(Log log){
		 
		this.log=log;
		account=new Account(log);
	}
	
	
	
	
	public boolean addAccount(String name,String num,double amount ){

		return 	account.addAccount(name, num, amount);
		
	}
	public void delAccount (String num){
		account.delAccount(num);
	}
	public void modAccount(String name,String ID){
		account.modAccount( name, ID);
	}
	public ArrayList<AccountVO>  getAccountList(){
		
		return account.getAccountList();
		
	}
	public void endAccountManagement(){
		account.endAccountManagement();
	}
}
