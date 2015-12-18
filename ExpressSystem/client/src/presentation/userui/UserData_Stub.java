package src.presentation.userui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.userdataservice.UserDataService;
import src.po.LogPO;
import src.po.UserPO;

public class UserData_Stub implements UserDataService{
	
	private static final String UserFILE_PATH = "user.ser";
	File file = new File(UserFILE_PATH);

	@Override
	public UserPO find(long UserId) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				UserPO po = (UserPO) os.readObject();
				if (po.getPersonalID() == UserId){
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
		
		return userPO;
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO userPO = null;
		ObjectInputStream os = null;
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				userPO = (UserPO) os.readObject();
				if (po.getPersonalID() == userPO.getPersonalID()){
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
		
		
	}
	
	@Override
	public void insert(ArrayList<UserPO> User) throws RemoteException {
		// TODO Auto-generated method stub
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			for(int i = 0;i < User.size();i++){
				os.writeObject(User.get(i));
				os.flush();
			}
			os.close();
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				System.out.println("UserFile not found");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
					

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	


}
