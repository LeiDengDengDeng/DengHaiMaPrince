package src.data.nonUserdata;

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
import src.dataservice.nonUserdataservice.TruckDataService;
import src.po.TruckPO;

public class TruckData implements TruckDataService{
	
	public static final String TruckFILE_PATH = "truck.ser";

	@Override
	public TruckPO findTruckPO(long id) throws RemoteException {
		TruckPO tpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("TruckFILE_PATH"));

			for (;;) {
				TruckPO po = (TruckPO) os.readObject();
				if (po.getNumber() == id){
					tpo = po;
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
		if(tpo == null)	System.out.println("Not found!!");
		
		
		return tpo;
	}

	@Override
	public ArrayList<TruckPO> findsTruckPO() throws RemoteException {
		ArrayList<TruckPO> tpos = new ArrayList<TruckPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("TruckFILE_PATH"));

			for (;;) {
				TruckPO po = (TruckPO) os.readObject();
				if (po == null)
					break;
				tpos.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return tpos;
	}

	@Override
	public void insert(TruckPO tpo) throws RemoteException {
		if(findTruckPO(tpo.getNumber()) == null){
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(TruckFILE_PATH);
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				moos = new MyObjectOutputStream(new FileOutputStream(file, true));
				if (file.length() == 0) {
					oos.writeObject(tpo);
					oos.flush();
					oos.close();
				} else {
					moos.writeObject(tpo);
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
	public void update(TruckPO tpo) throws RemoteException {
		deleteTruckPO(tpo.getNumber());
		insert(tpo);
	}

	@Override
	public void deleteTruckPO(long id) throws RemoteException {
		File file = new File(TruckFILE_PATH);
		ArrayList<TruckPO> tpos = new ArrayList<TruckPO>();
		tpos = findsTruckPO();
		
		for(int i = 0;i < tpos.size();i++){
			if(tpos.get(i).getNumber() == id){
				tpos.remove(i);
				break;
			}
		}
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			
			for(int j = 0;j < tpos.size();j++){
				os.writeObject(tpos.get(j));
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
