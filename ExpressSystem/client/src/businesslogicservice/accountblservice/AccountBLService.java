package src.businesslogicservice.accountblservice;

import java.util.ArrayList;

import src.businesslogic.accountbl.AccountInfoType;
import src.vo.AccountVO;

public interface AccountBLService {
	
	public boolean islegal(AccountInfoType type,Object info);

	public boolean addAccount(String name,String ID,double amount);
	
	public boolean delAccount (String ID);
	
	public boolean modAccount(String name,String ID);
	
	public ArrayList<AccountVO>  getAccountList();
	
	public void endAccountManagement();
}
