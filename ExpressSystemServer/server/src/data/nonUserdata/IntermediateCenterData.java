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
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import src.data.logdata.MyObjectOutputStream;
import src.dataservice.nonUserdataservice.IntermediateCenterDataService;
import src.po.IntermediateCenterPO;

public class IntermediateCenterData extends UnicastRemoteObject implements IntermediateCenterDataService{
	
	public IntermediateCenterData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final String IntermediateCenterFILE_PATH = "intermediatecenter.ser";
	File file = new File(IntermediateCenterFILE_PATH);

	@Override
	public IntermediateCenterPO findIntermediateCenterPO(String id)
			throws RemoteException {
		IntermediateCenterPO ipo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				IntermediateCenterPO po = (IntermediateCenterPO) os.readObject();
				if (po.getCity().equals(id)){
					ipo = po;
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
		if(ipo == null)	System.out.println("Not found!!");
		
		
		return ipo;
	}

	@Override
	public ArrayList<IntermediateCenterPO> findsIntermediateCenterPO()
			throws RemoteException {
		ArrayList<IntermediateCenterPO> ipos = new ArrayList<IntermediateCenterPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				IntermediateCenterPO po = (IntermediateCenterPO) os.readObject();
				if (po == null)
					break;
				ipos.add(po);
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
		
		
		return ipos;
	}

	@Override
	public void insert(IntermediateCenterPO ipo) throws RemoteException {
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(IntermediateCenterFILE_PATH);
			
			try {
				if (file.length() == 0) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(ipo);
					oos.flush();
					oos.close();
				} else {
					moos = new MyObjectOutputStream(new FileOutputStream(file, true));
					moos.writeObject(ipo);
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
	public void deleteIntermediateCenterPO(String id) throws RemoteException {
		File file = new File(IntermediateCenterFILE_PATH);
		ArrayList<IntermediateCenterPO> ipos = new ArrayList<IntermediateCenterPO>();
		ipos = findsIntermediateCenterPO();
		
		for(int i = 0;i < ipos.size();i++){
			if(ipos.get(i).getCity().equals(id)){
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
