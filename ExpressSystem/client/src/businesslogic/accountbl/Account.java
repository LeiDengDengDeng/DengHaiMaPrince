package src.businesslogic.accountbl;

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
	String position = "������Ա";

	public Account(Log log) {
		super();
		this.log = log;
		// accountData=new AccountData();
	}

	@Override
	public boolean islegal(AccountInfoType type, Object info) {

		return true;
	}

	/**
	 * ����һ�������˻�
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
	 * �޸������˻���Ϣ
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
	 * �õ������˻��б�
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
		AccountPO account;
		try {
			account = accountData.find(ID);
			accountData.delete(account);
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
			double amount=account.getAmount()+difference;
			account.setAmount(amount);
			accountData.update(account);

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
