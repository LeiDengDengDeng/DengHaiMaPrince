package src.businesslogicservice.accountblservice;

import java.util.ArrayList;

import src.vo.AccountVO;

public interface AccountBLService {
	
	
	public void addAccount(String name,long num,double amount);
	
	public void modAccount(long oldID,String name,long ID);
	
	public ArrayList<AccountVO>  getAccountList();
	
	public void endAccountManagement();
}
