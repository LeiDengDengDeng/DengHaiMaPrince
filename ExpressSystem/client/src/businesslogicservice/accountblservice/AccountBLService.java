package src.businesslogicservice.accountblservice;

import java.util.ArrayList;

import src.businesslogic.accountbl.AccountInfoType;
import src.vo.AccountVO;

public interface AccountBLService {
	
	public boolean islegal(AccountInfoType type,Object info);

	public boolean addAccount(String name,long num,double amount);
	
	public void delAccount (long num);
	
	public void modAccount(long oldID,String name,long ID);
	
	public ArrayList<AccountVO>  getAccountList();
	
	public void endAccountManagement();
}
