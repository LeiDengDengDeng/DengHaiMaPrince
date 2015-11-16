package src.businesslogic.accountbl;

import java.util.ArrayList;

import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.AccountVO;

public class AccountController {
	LogBLService log;
	
	public AccountController(LogBLService log){
		 
		this.log=log;
	}
	
	AccountBLService account=new Account(log);
	
	
	
	public boolean addAccount(String name,long num,double amount ){
		return false;
		
	}
	public void delAccount (long num){
		
	}
	public void modAccount(long oldID,String name,long ID){
		
	}
	public ArrayList<AccountVO>  getAccountList(){
		return null;
		
	}
	public void endAccountManagement(){
		
	}
}
