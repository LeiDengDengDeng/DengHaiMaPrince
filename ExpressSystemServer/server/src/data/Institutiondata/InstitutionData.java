package src.data.Institutiondata;

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
import src.dataservice.institutiondataservice.InstitutionDataService;
import src.po.InstitutionPO;
import src.po.UserPO;

public class InstitutionData implements InstitutionDataService{
	public static final String InsFILE_PATH = "institution.ser";
	File file = new File(InsFILE_PATH); 

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
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
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
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
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
			
		}
		
		else System.out.println("Already exist!!");
		
	}

	@Override
	public void update(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		delete(find(po.getInstitutionID()));
		insert(po);
		
	}

	@Override
	public void delete(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<InstitutionPO> institutionPOs = new ArrayList<InstitutionPO>();
		institutionPOs = finds();
		
		for(int i = 0;i < institutionPOs.size();i++){
			if(institutionPOs.get(i) == po){
				institutionPOs.remove(i);
				break;
			}
		}
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			
			for(int j = 0;j < institutionPOs.size();j++){
				os.writeObject(institutionPOs.get(j));
				os.flush();
			}
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
