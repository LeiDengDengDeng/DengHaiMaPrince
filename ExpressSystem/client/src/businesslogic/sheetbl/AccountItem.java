package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogic.accountbl.Account;
import src.vo.AccountVO;

/**
 * @author dell
 *
 */
public class AccountItem {
	Account account;

	ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();

	public AccountItem(Account account) {
		this.account = account;
	}

	public String[][] getAccount() {
		accountList = account.getAccountList();
		String[][] info = new String[accountList.size()][3];
		
		for(int i=0;i<accountList.size();i++){
			AccountVO temp = accountList.get(i);
			info[i][0] = String.valueOf(temp.getID());
			info[i][1] = temp.getName();
			info[i][2] = String.valueOf(temp.getAmount());
		}
		
		return info;
	}

	/**
	 * @param ID 银行账户
	 * @param difference 金额变更值
	 */
	public boolean updateAccount(String ID,double difference) {
		return account.updateAmount(ID, difference);
	}

}
