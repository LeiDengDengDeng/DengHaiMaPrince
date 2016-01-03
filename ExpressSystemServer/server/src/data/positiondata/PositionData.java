package src.data.positiondata;

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
import src.dataservice.positiondataservice.PositionDataService;
import src.po.AuthorityPO;

public class PositionData extends UnicastRemoteObject implements PositionDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9172988901177140784L;
	
	private static final String authorityFILE_PATH = "authority.ser";
	File file = new File(authorityFILE_PATH);
	
	public PositionData() throws RemoteException {
	}
	
	@Override
	public AuthorityPO find(String position) throws RemoteException {
		// TODO Auto-generated method stub
		AuthorityPO authorityPO = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				AuthorityPO po = (AuthorityPO) os.readObject();
				if (po.getPosition().equals(position)){
					authorityPO = po;
					break;
				}
				if(po == null) break;
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
		if(authorityPO == null)	System.out.println("Not found!!");
		
		
		return authorityPO;
	}



	@Override
	public ArrayList<AuthorityPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<AuthorityPO> authorityPOs = new ArrayList<AuthorityPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				AuthorityPO po = (AuthorityPO) os.readObject();
				if (po == null)
					break;
				else
					authorityPOs.add(po);
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
		
		
		return authorityPOs;
	}



	@Override
	public void delete(String position) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<AuthorityPO> authorityPOs = finds();
		boolean exist = true;
		
		for(int i = 0;i < authorityPOs.size();i++){
			if(authorityPOs.get(i).getPosition().equals(position)){
				authorityPOs.remove(i);
				break;
			}else{
				if(i == authorityPOs.size() - 1){
					System.out.println("Not found!!!");
					exist = false;
				}
			}
			
		}
		ObjectOutputStream os = null;

		if(exist){
			try {
				os = new ObjectOutputStream(new FileOutputStream(file,false));
			
				for(int j = 0;j < authorityPOs.size();j++){
					os.writeObject(authorityPOs.get(j));
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
	public void insert(AuthorityPO authorityPO) throws RemoteException {
		// TODO Auto-generated method stub
		if(find(authorityPO.getPosition()) == null){
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			
			try {
				if (file.length() == 0) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(authorityPO);
					oos.flush();
					oos.close();
				} else {
					moos = new MyObjectOutputStream(new FileOutputStream(file, true));
					moos.writeObject(authorityPO);
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
	public void update(AuthorityPO authorityPO) throws RemoteException {
		// TODO Auto-generated method stub
		AuthorityPO po = find(authorityPO.getPosition());
		if(po != null){
			delete(po.getPosition());
			insert(authorityPO);
		}
		else System.out.println("Not exist!!");
		
		}
		
	
	
//	public static void main(String[] args) {
//		try {
//			PositionData data = new PositionData();
//			AuthorityPO managerAuthorityPO = new AuthorityPO("总经理");
//			AuthorityPO administratorAuthorityPO = new AuthorityPO("管理员");
//			AuthorityPO accountantAuthorityPO = new AuthorityPO("财务人员");
//			AuthorityPO keeperAuthorityPO = new AuthorityPO("中转中心仓库管理员");
//			AuthorityPO interAuthorityPO = new AuthorityPO("中转中心业务员");
//			AuthorityPO businessAuthorityPO = new AuthorityPO("营业厅业务员");
//			AuthorityPO courierAuthorityPO = new AuthorityPO("快递员");
//			ArrayList<Integer> managerArrayList = new ArrayList<Integer>();
//			ArrayList<Integer> administratorArrayList = new ArrayList<Integer>();
//			ArrayList<Integer> accountantArrayList = new ArrayList<Integer>();
//			ArrayList<Integer> keeperArrayList = new ArrayList<Integer>();
//			ArrayList<Integer> interArrayList = new ArrayList<Integer>();
//			ArrayList<Integer> businessArrayList = new ArrayList<Integer>();
//			ArrayList<Integer> courierArrayList = new ArrayList<Integer>();
//			managerArrayList.add(11);
//			managerArrayList.add(12);
//			managerArrayList.add(13);
//			managerArrayList.add(19);
//			managerArrayList.add(20);
//			managerAuthorityPO.setAuthority(managerArrayList);
//			administratorArrayList.add(1);
//			administratorArrayList.add(18);
//			administratorAuthorityPO.setAuthority(administratorArrayList);
//			accountantArrayList.add(11);
//			accountantArrayList.add(14);
//			accountantArrayList.add(15);
//			accountantArrayList.add(16);
//			accountantArrayList.add(17);
//			accountantArrayList.add(19);
//			accountantArrayList.add(21);
//			accountantAuthorityPO.setAuthority(accountantArrayList);
//			keeperArrayList.add(9);
//			keeperAuthorityPO.setAuthority(keeperArrayList);
//			interArrayList.add(2);
//			interArrayList.add(6);
//			interAuthorityPO.setAuthority(interArrayList);
//			businessArrayList.add(3);
//			businessArrayList.add(4);
//			businessArrayList.add(5);
//			businessArrayList.add(10);
//			businessAuthorityPO.setAuthority(businessArrayList);
//			courierArrayList.add(7);
//			courierArrayList.add(8);
//			courierAuthorityPO.setAuthority(courierArrayList);
//			data.insert(managerAuthorityPO);
//			data.insert(administratorAuthorityPO);
//			data.insert(accountantAuthorityPO);
//			data.insert(keeperAuthorityPO);
//			data.insert(interAuthorityPO);
//			data.insert(businessAuthorityPO);
//			data.insert(courierAuthorityPO);
//			System.out.println(data.find("总经理").getAuthority().size());
//		} catch (RemoteException e) {
////			 TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
