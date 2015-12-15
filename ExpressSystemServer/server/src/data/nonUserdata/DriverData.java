package src.data.nonUserdata;

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
import src.dataservice.nonUserdataservice.DriverDataService;
import src.po.DriverPO;

public class DriverData implements DriverDataService{
	
	public static final String DriverFILE_PATH = "driver.ser";
	File file = new File(DriverFILE_PATH);

	@Override
	public DriverPO findDriverPO(long id) throws RemoteException {
		DriverPO dpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				DriverPO po = (DriverPO) os.readObject();
				if (po.getNumber() == id){
					dpo = po;
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
		if(dpo == null)	System.out.println("Not found!!");
		
		
		return dpo;
	}

	@Override
	public ArrayList<DriverPO> findsDriverPO() throws RemoteException {
		ArrayList<DriverPO> dpos = new ArrayList<DriverPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				DriverPO po = (DriverPO) os.readObject();
				if (po == null)
					break;
				dpos.add(po);
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
		
		
		return dpos;
	}

	@Override
	public void insert(DriverPO dpo) throws RemoteException {
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(DriverFILE_PATH);
			
			try {
				if (file.length() == 0) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(dpo);
					oos.flush();
					oos.close();
				} else {
					moos = new MyObjectOutputStream(new FileOutputStream(file, true));
					moos.writeObject(dpo);
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
	public void update(long id,DriverPO dpo) throws RemoteException {
		deleteDriverPO(id);
		insert(dpo);
	}

	@Override
	public void deleteDriverPO(long id) throws RemoteException {
		File file = new File(DriverFILE_PATH);
		ArrayList<DriverPO> dpos = new ArrayList<DriverPO>();
		dpos = findsDriverPO();
		
		for(int i = 0;i < dpos.size();i++){
			if(dpos.get(i).getNumber() == id){
				dpos.remove(i);
				break;
			}
		}
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			
			for(int j = 0;j < dpos.size();j++){
				os.writeObject(dpos.get(j));
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
