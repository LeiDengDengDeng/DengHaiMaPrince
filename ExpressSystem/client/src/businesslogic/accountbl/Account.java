package src.businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.dataservice.accountdataservice.AccountDataService;
import src.po.AccountPO;
import src.vo.AccountVO;

public class Account implements AccountBLService {

	AccountDataService accountData;
	Log log;
	String position = "财务人员";

	public Account(Log log) {
		super();
		this.log = log;
		try {
			accountData=(AccountDataService) Naming.lookup("rmi://127.0.0.1:6600/accountData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// accountData=new AccountData();
	}

	@Override
	public boolean islegal(AccountInfoType type, Object info) {

		return true;
	}

	/**
	 * 增加一个银行账户
	 */
	public boolean addAccount(String name, long ID, double amount) {
		AccountPO account = new AccountPO(name, ID, amount);
		try {
			accountData.insert(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * 修改银行账户信息
	 */
	public boolean modAccount(String name, long ID) {
		// TODO Auto-generated method stub
		try {
			AccountPO account = accountData.find(ID);
			account.setName(name);
			accountData.update(account);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;

	}

	@Override
	/**
	 * 拿到银行账户列表
	 */
	public ArrayList<AccountVO> getAccountList() {
		ArrayList<AccountPO> accountPOList;
		ArrayList<AccountVO> accountVOList = new ArrayList<AccountVO>();
		try {
			accountPOList = accountData.getAll();
			for (int i = 0; i < accountPOList.size(); i++) {
				AccountPO accountPO = accountPOList.get(i);
				AccountVO accountVO = new AccountVO(accountPO.getName(), accountPO.getCardID(), accountPO.getAmount());
				accountVOList.add(accountVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return accountVOList;
	}

	@Override
	public void endAccountManagement() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean delAccount(long ID) {
		try {
			accountData.delete(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateAmount(long ID, double difference) {
		try {
			AccountPO account = accountData.find(ID);
			double amount=account.getAmount()-difference;
			account.setAmount(amount);
//			accountData.update(account);
			System.out.println("update");

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public void initAmount(ArrayList<AccountVO> vo) {
		for (int i = 0; i < vo.size(); i++) {
			AccountVO accountVO = vo.get(i);
			addAccount(accountVO.getName(), accountVO.getID(), accountVO.getAmount());
		}

	}
}
