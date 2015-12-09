package src.data.userdata;

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
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
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
        UserPO userPO = null;
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream(file));

            for (; ; ) {
                userPO = (UserPO) os.readObject();
                if (po.getPersonalID() == userPO.getPersonalID()) {
                    userPO = po;
                    break;
                }
                if (po == null) break;
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
            os = new ObjectOutputStream(new FileOutputStream(file, false));
            for (int i = 0; i < User.size(); i++) {
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

//    public static void main(String[] args) {
//        ArrayList<Integer> test1 = new ArrayList<>();
//        test1.add(7);
//        test1.add(8);
//        UserPO user1 = new UserPO(100001, 100001, "123456", "哔哔", "快递员", test1);
//        ArrayList<UserPO> users = new ArrayList<>();
//        users.add(user1);
//        try {
//            UserData data = new UserData();
//            data.insert(users);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end");
//    }


}
