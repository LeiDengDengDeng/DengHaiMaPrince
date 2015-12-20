package src.data.userdata;

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
import src.dataservice.userdataservice.UserDataService;
import src.po.LogPO;
import src.po.UserPO;

public class UserData extends UnicastRemoteObject implements UserDataService {

    /**
     *
     */
    private static final long serialVersionUID = 7922427457532947554L;

    private static final String UserFILE_PATH = "user.ser";
    File file = new File(UserFILE_PATH);

    public UserData() throws RemoteException {

    }

    @Override
    public UserPO find(long UserId) throws RemoteException {
        // TODO Auto-generated method stub
        UserPO userPO = null;
        ObjectInputStream os = null;

        try {
            os = new ObjectInputStream(new FileInputStream(file));

            for (; ; ) {
                UserPO po = (UserPO) os.readObject();
                if (po.getPersonalID() == UserId) {
                    userPO = po;
                    break;
                }
                if (po == null) break;
            }

            os.close();
        } catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("File not found");
		} catch (EOFException e) {
			// TODO 自动生成的 catch 块
//			e.printStackTrace();
			System.out.println("End of file");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        if (userPO == null) System.out.println("Not found!!");

        return userPO;
    }

    @Override
    public void update(UserPO po) throws RemoteException {
        // TODO Auto-generated method stub
		UserPO userPO = find(po.getPersonalID());
//		System.out.println(userPO.getPersonalName());
		if(userPO != null){
			delete(userPO);
			insert(po);
		}
		else System.out.println("Not exist!!");
		
    }

    @Override
    public void InitialInsert(ArrayList<UserPO> User) throws RemoteException {
        // TODO Auto-generated method stub
        ObjectOutputStream os = null;

        try {
            os = new ObjectOutputStream(new FileOutputStream(file, false));
            for (int i = 0; i < User.size(); i++) {
                os.writeObject(User.get(i));
                os.flush();
            }
            os.close();
        } catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("File not found");
		} catch (EOFException e) {
			// TODO 自动生成的 catch 块
//			e.printStackTrace();
			System.out.println("End of file");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("IOException");
		}
    }

	@Override
	public void insert(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(find(po.getPersonalID()) == null){
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			
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
				// TODO 自动生成的 catch 块
				System.out.println("File not found");
				e.printStackTrace();
			} catch (EOFException e) {
				// TODO 自动生成的 catch 块
//				e.printStackTrace();
				System.out.println("End of file");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				System.out.println("IOException");
			}
			
		}
		
		else System.out.println("Already exist!!");
		
		
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> userPOs =	finds();
//		for(int i = 0;i < userPOs.size();i++)
//			System.out.println(userPOs.get(i).getPersonalID());
		boolean exist = true;
		
		for(int i = 0;i < userPOs.size();i++){
			if(userPOs.get(i).getPersonalID() == po.getPersonalID()){
				userPOs.remove(i);
				break;
			}else{
				if(i == userPOs.size() - 1){
					System.out.println("Not found!!!");
					exist = false;
				}
			}
			
		}
		
		ObjectOutputStream os = null;

		if(exist){
			try {
				os = new ObjectOutputStream(new FileOutputStream(file,false));
			
				for(int j = 0;j < userPOs.size();j++){
					os.writeObject(userPOs.get(j));
					os.flush();
				}
				os.close();
				
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				System.out.println("File not found");
				e.printStackTrace();
			} catch (EOFException e) {
				// TODO 自动生成的 catch 块
//				e.printStackTrace();
				System.out.println("End of file");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				System.out.println("IOException");
			}
			System.out.println("delete!!");
		}
		
	}
	
	@Override
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
				else
					userPOs.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("File not found");
		} catch (EOFException e) {
			// TODO 自动生成的 catch 块
//			e.printStackTrace();
			System.out.println("End of file");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return userPOs;
	}


    @Override
    public void finish() throws RemoteException {
        // TODO Auto-generated method stub

    }
	
//    public static void main(String[] args) {
////      ArrayList<Integer> test1 = new ArrayList<>();
////      test1.add(7);
////      test1.add(8);
////      UserPO user1 = new UserPO(100000, 100000, "123456", "哔哔", "快递员", test1);
////      ArrayList<UserPO> users = new ArrayList<>();
////      users.add(user1);
//      try {
//          UserData data = new UserData();
//          System.out.println(data.find(100000).getMyPassword());
////          UserPO userPO = new UserPO(100000, 100000, "12345a", "张三", "快递员",null);
////          data.update(userPO);
////          System.err.println(data.find(100000).getMyPassword());
//      } catch (RemoteException e) {
//          e.printStackTrace();
//      }
//  
//  }


}
