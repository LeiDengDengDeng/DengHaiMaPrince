package src.data.commoditydata;

import java.io.EOFException;
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
import src.po.GoodsPO;
import src.po.StoragePO;

public class StorageData implements StorageDataService{
	
	public static final String StorageFILE_PATH = "storage.ser";
	File file = new File(StorageFILE_PATH);

	@Override
	public StoragePO findStoragePO(String id) throws RemoteException {
		StoragePO spo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

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
			System.out.println("FILE NOT FOUND");
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
		}
		if(spo == null)	System.out.println("Not found!!");
		
		
		return spo;
	}

	@Override
	public ArrayList<StoragePO> finds() throws RemoteException {
		ArrayList<StoragePO> spos = new ArrayList<StoragePO>();
		StoragePO spo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			while ((spo = (StoragePO) os.readObject()) != null) {
				spos.add(spo);
			}

			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		} catch (EOFException e) {
			System.out.println("END OF FILE");
		} catch (IOException e) {
			System.out.println("IO");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
		}
		
		
		return spos;
	}

	@Override
	public void insert(StoragePO spo) throws RemoteException {
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(StorageFILE_PATH);
			
			try {
				if (file.length() == 0) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(spo);
					oos.flush();
					oos.close();
				} else {
					moos = new MyObjectOutputStream(new FileOutputStream(file, true));
					moos.writeObject(spo);
					moos.flush();
					moos.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("FILE NOT FOUND ");
			} catch (EOFException e) {
				System.out.println("END OF FILE");
			} catch (IOException e) {
				System.out.println("IO EXCEPTION");
			}
			
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
			if(spos.get(i).getCity().equals(id)){
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
			System.out.println("FILE NOT FOUND ");
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
		}		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
