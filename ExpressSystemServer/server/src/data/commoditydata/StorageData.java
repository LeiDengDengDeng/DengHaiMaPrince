package src.data.commoditydata;

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
import src.dataservice.commoditydataservice.StorageDataService;
import src.po.StoragePO;

public class StorageData implements StorageDataService{
	
	public static final String StorageFILE_PATH = "storage.ser";

	@Override
	public StoragePO findStoragePO(String id) throws RemoteException {
		StoragePO spo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("StorageFILE_PATH"));

			for (;;) {
				StoragePO po = (StoragePO) os.readObject();
				if (po.getCity() == id){
					spo = po;
					break;
				}
				if(po == null) break;
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(spo == null)	System.out.println("Not found!!");
		
		
		return spo;
	}

	@Override
	public ArrayList<StoragePO> finds() throws RemoteException {
		ArrayList<StoragePO> spos = new ArrayList<StoragePO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("StorageFILE_PATH"));

			for (;;) {
				StoragePO po = (StoragePO) os.readObject();
				if (po == null)
					break;
				spos.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return spos;
	}

	@Override
	public void insert(StoragePO spo) throws RemoteException {
		if(findStoragePO(spo.getCity()) == null){
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(StorageFILE_PATH);
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				moos = new MyObjectOutputStream(new FileOutputStream(file, true));
				if (file.length() == 0) {
					oos.writeObject(spo);
					oos.flush();
					oos.close();
				} else {
					moos.writeObject(spo);
					moos.flush();
					moos.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("TruckFile not found");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		else System.out.println("Already exist!!");
	}

	@Override
	public void update(String id,StoragePO spo) throws RemoteException {
		delete(id);
		insert(spo);
	}

	@Override
	public void delete(String id) throws RemoteException {
		File file = new File(StorageFILE_PATH);
		ArrayList<StoragePO> spos = new ArrayList<StoragePO>();
		spos = finds();
		
		for(int i = 0;i < spos.size();i++){
			if(spos.get(i).getCity() == id){
				spos.remove(i);
				break;
			}
		}
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			
			for(int j = 0;j < spos.size();j++){
				os.writeObject(spos.get(j));
				os.flush();
			}
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
