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
import src.dataservice.nonUserdataservice.IntermediateCenterDataService;
import src.po.IntermediateCenterPO;

public class IntermediateCenterData implements IntermediateCenterDataService{
	
	public static final String IntermediateCenterFILE_PATH = "intermediatecenter.ser";

	@Override
	public IntermediateCenterPO findIntermediateCenterPO(String id)
			throws RemoteException {
		IntermediateCenterPO ipo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("IntermediateCenterFILE_PATH"));

			for (;;) {
				IntermediateCenterPO po = (IntermediateCenterPO) os.readObject();
				if (po.getCity() == id){
					ipo = po;
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
		if(ipo == null)	System.out.println("Not found!!");
		
		
		return ipo;
	}

	@Override
	public ArrayList<IntermediateCenterPO> findsIntermediateCenterPO()
			throws RemoteException {
		ArrayList<IntermediateCenterPO> ipos = new ArrayList<IntermediateCenterPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("IntermediateCenterFILE_PATH"));

			for (;;) {
				IntermediateCenterPO po = (IntermediateCenterPO) os.readObject();
				if (po == null)
					break;
				ipos.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return ipos;
	}

	@Override
	public void insert(IntermediateCenterPO ipo) throws RemoteException {
		if(findIntermediateCenterPO(ipo.getCity()) == null){
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(IntermediateCenterFILE_PATH);
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				moos = new MyObjectOutputStream(new FileOutputStream(file, true));
				if (file.length() == 0) {
					oos.writeObject(ipo);
					oos.flush();
					oos.close();
				} else {
					moos.writeObject(ipo);
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
	public void deleteIntermediateCenterPO(String id) throws RemoteException {
		File file = new File(IntermediateCenterFILE_PATH);
		ArrayList<IntermediateCenterPO> ipos = new ArrayList<IntermediateCenterPO>();
		ipos = findsIntermediateCenterPO();
		
		for(int i = 0;i < ipos.size();i++){
			if(ipos.get(i).getCity() == id){
				ipos.remove(i);
				break;
			}
		}
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			
			for(int j = 0;j < ipos.size();j++){
				os.writeObject(ipos.get(j));
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
