package src.data.Institutiondata;

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
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.po.InstitutionPO;
import src.po.UserPO;

public class InstitutionData extends UnicastRemoteObject implements InstitutionDataService{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4549343829871236083L;
	
	public static final String InsFILE_PATH = "institution.ser";
	File file = new File(InsFILE_PATH); 
	
	public InstitutionData() throws RemoteException {
	}

	@Override
	public InstitutionPO find(long InstitutionId) throws RemoteException {
		// TODO Auto-generated method stub
		InstitutionPO institutionPO = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				InstitutionPO po = (InstitutionPO) os.readObject();
				if (po.getInstitutionID() == InstitutionId){
					institutionPO = po;
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
		if(institutionPO == null)	System.out.println("Not found!!");
		
		
		return institutionPO;
	}

	@Override
	public ArrayList<InstitutionPO> finds() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<InstitutionPO> institutionPOs = new ArrayList<InstitutionPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				InstitutionPO po = (InstitutionPO) os.readObject();
				if (po == null)
					break;
				institutionPOs.add(po);
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
		
		
		return institutionPOs;
	}

	@Override
	public void insert(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(find(po.getInstitutionID()) == null){
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
				e.printStackTrace();
				System.out.println("File not found");
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
	public void update(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		InstitutionPO institutionPO = find(po.getInstitutionID());
		if(institutionPO != null){
			delete(institutionPO);
			insert(po);
		}
		else System.out.println("Not exist!!");
	}

	@Override
	public void delete(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<InstitutionPO> institutionPOs = new ArrayList<InstitutionPO>();
		institutionPOs = finds();
		boolean exist = true;
		
		for(int i = 0;i < institutionPOs.size();i++){
			if(institutionPOs.get(i).getInstitutionID() == po.getInstitutionID()){
				institutionPOs.remove(i);
				break;
			}else{
				if(i == institutionPOs.size() - 1){
					System.out.println("Not found!!!");
					exist = false;
				}
			}
		}
		
		ObjectOutputStream os = null;
		
		if(exist){
			try {
				os = new ObjectOutputStream(new FileOutputStream(file,false));
				
				for(int j = 0;j < institutionPOs.size();j++){
					os.writeObject(institutionPOs.get(j));
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
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		try {
			InstitutionData data = new InstitutionData();
//			data.insert(new InstitutionPO("中转中心", 200000, "中转与接收"));
//			System.out.println(data.find(100000).getInstitutionName());
//			System.out.println(data.finds().size());
//			data.delete(new InstitutionPO("中转中心", 200000, "中转与接收"));
			data.update(new InstitutionPO("营业厅", 100000, "负责中转与接收"));
			System.out.println(data.find(100000).getInstitutionName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
