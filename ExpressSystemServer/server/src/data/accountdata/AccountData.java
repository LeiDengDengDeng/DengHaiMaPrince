package src.data.accountdata;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import src.data.logdata.MyObjectOutputStream;
import src.dataservice.accountdataservice.AccountDataService;
import src.po.AccountPO;

public class AccountData extends UnicastRemoteObject implements AccountDataService {
	public AccountData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final String FILE_PATH = "account.ser";
	File file = new File(FILE_PATH);
	ObjectOutputStream oos = null;
	MyObjectOutputStream moos = null;
	ObjectInputStream ois = null;
	/**
	 * 插入AccountPO
	 */
	public boolean insert(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			if (file.length() == 0) {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(po);
				oos.flush();
				oos.close();
			} else {
				moos = new MyObjectOutputStream(new FileOutputStream(file, true));
				moos.writeObject(po);
				moos.flush();
				moos.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ");
			return false;
		} catch (EOFException e) {
			System.out.println("END OF FILE");
			return false;
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
			return false;
		}
		return true;

	}

	/**
	 * 删除AccountPO
	 */
	public boolean delete(long ID) throws RemoteException {
		ArrayList<AccountPO> accounts = new ArrayList<AccountPO>();
		AccountPO po;
		boolean findIt = false;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while ((po = (AccountPO) ois.readObject()) != null) {
				if (po.getCardID() != ID){
					accounts.add(po);
				}
				else{
					findIt = true;
				}
			}
			

		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ");
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
		} catch (ClassNotFoundException e) {
		}
		
		try {
		oos = new ObjectOutputStream(new FileOutputStream(file));
		for (AccountPO account : accounts) {
			oos.writeObject(account);
		}
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ");
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
		}
		
		if (findIt) {
			return true;
		}
		return false;
	}

	/**
	 * 得到Accout信息列表
	 */
	public ArrayList<AccountPO> getAll() throws RemoteException {
		ArrayList<AccountPO> accounts = new ArrayList<AccountPO>();
		AccountPO po;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while ((po = (AccountPO) ois.readObject()) != null) {
				accounts.add(po);
			}

			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
		}
		return accounts;
	}
	/**
	 * 更新一个po
	 */
	public boolean update(AccountPO po) throws RemoteException {
		ArrayList<AccountPO> accounts = new ArrayList<AccountPO>();
		AccountPO account;
		boolean findIt = false;
		//输出文件中的po放进列表，若ID相同则放入传入的新po
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while ((account = (AccountPO) ois.readObject()) != null) {
				if (account.getCardID() != po.getCardID())
					accounts.add(account);
				else {
					accounts.add(po);
					findIt = true;
				}
			}
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ");
			return false;
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
			return false;
		} catch (ClassNotFoundException e) {
			return false;
		}
		//写入更新后的列表
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			for (AccountPO accountpo : accounts) {
				oos.writeObject(accountpo);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ");
			return false;
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
			return false;
		}
		if (findIt) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 * 根据ID找到对应得po
	 */
	public AccountPO find(long id) throws RemoteException {
		AccountPO po = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while ((po = (AccountPO) ois.readObject()) != null) {
				if (po.getCardID() == id)
					break;
			}

			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
		}
		return po;
	}

}
