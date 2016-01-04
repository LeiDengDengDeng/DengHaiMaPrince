package src.data.staffmanagedata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.data.logdata.MyObjectOutputStream;
import src.dataservice.staffmanagedataservice.StaffManageDataService;
import src.po.AuthorityPO;
import src.po.UserPO;

public class StaffManageDataStub implements StaffManageDataService{

	private static final String UserFILE_PATH = "user.ser";
	File file = new File(UserFILE_PATH);
	
	public UserPO find(long StaffId) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				UserPO po = (UserPO) os.readObject();
				if (po.getPersonalID() == StaffId){
					userPO = po;
					break;
				}
				if(po == null) break;
			}

			os.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(userPO == null)	System.out.println("Not found!!");
		else System.out.println("find!!!");
		
		
		return userPO;
	}

	public ArrayList<UserPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				UserPO po = (UserPO) os.readObject();
				if (po == null)
					break;
				userPOs.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return userPOs;
	}

	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(find(po.getPersonalID()) == null){
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				moos = new MyObjectOutputStream(new FileOutputStream(file, true));
				if (file.length() == 0) {
					oos.writeObject(po);
					oos.flush();
					oos.close();
				} else {
					moos.writeObject(po);
					moos.flush();
					moos.close();
				}
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				System.out.println("UserFile not found");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("add successfully!!");
		}
		
		else System.out.println("Already exist!!");
		
	}

	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		delete(find(po.getPersonalID()));
		insert(po);
		
	}

	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> userPOs = new ArrayList<UserPO>();
		userPOs = finds();
		
		for(int i = 0;i < userPOs.size();i++){
			if(userPOs.get(i) == po){
				userPOs.remove(i);
				break;
			}
		}
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			
			for(int j = 0;j < userPOs.size();j++){
				os.writeObject(userPOs.get(j));
				os.flush();
			}
			os.close();
			System.out.println("delete successfully!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
//	public static void main(String[] args){
//		StaffManageDataStub staffManageDataStub = new StaffManageDataStub();
//		try {
//			staffManageDataStub.insert(new UserPO(200000, 200000, "aaaaaa", "瓜瓜", "快递员", null));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			staffManageDataStub.delete(new UserPO(100000, 100000, "aaaaaa", "张三", "快递员", null));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			staffManageDataStub.find(200000);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
