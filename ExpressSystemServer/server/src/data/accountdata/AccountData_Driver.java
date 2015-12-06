package src.data.accountdata;

import java.rmi.RemoteException;

import src.po.AccountPO;

public class AccountData_Driver {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		AccountData accountdata=new AccountData();
		AccountPO accountpo=new AccountPO("goog", 1234, 1235.1234);
		AccountPO accountpo2=new AccountPO("g444", 1235, 1234.00);
		try {
			accountdata.insert(accountpo);
			accountdata.insert(accountpo2);
//			System.out.println(accountdata.getAll().get(0).getCardID()+" "+accountdata.getAll().get(1).getCardID());
//			System.out.println(accountdata.update(accountpo2));
//			System.out.println(accountdata.find(1235).getName()+" "+accountdata.find(1235).getAmount());
		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

}
