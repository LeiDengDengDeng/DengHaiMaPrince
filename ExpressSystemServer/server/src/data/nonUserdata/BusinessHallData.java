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
import src.dataservice.nonUserdataservice.BusinessHallDataService;
import src.po.BussinessHallPO;

public class BusinessHallData extends UnicastRemoteObject implements BusinessHallDataService{
	
	public BusinessHallData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static final String BussinessHallFILE_PATH = "bussinesshall.ser";
	File file = new File(BussinessHallFILE_PATH);

	@Override
	public BussinessHallPO findBussinessHallPO(String id)
			throws RemoteException {
		BussinessHallPO bpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				BussinessHallPO po = (BussinessHallPO) os.readObject();
				if (po.getHallName().equals(id)){
					bpo = po;
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
		if(bpo == null)	System.out.println("Not found!!");
		
		
		return bpo;
	}

	@Override
	public ArrayList<BussinessHallPO> findsBussinessHallPO()
			throws RemoteException {
		ArrayList<BussinessHallPO> bpos = new ArrayList<BussinessHallPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				BussinessHallPO po = (BussinessHallPO) os.readObject();
				if (po == null)
					break;
				bpos.add(po);
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
		
		
		return bpos;
	}

	@Override
	public void insert(BussinessHallPO bpo) throws RemoteException {
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(BussinessHallFILE_PATH);
			
			try {
				if (file.length() == 0) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(bpo);
					oos.flush();
					oos.close();
				} else {
					moos = new MyObjectOutputStream(new FileOutputStream(file, true));
					moos.writeObject(bpo);
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
	public void deleteBussinessHallPO(String id) throws RemoteException {
		File file = new File(BussinessHallFILE_PATH);
		ArrayList<BussinessHallPO> bpos = new ArrayList<BussinessHallPO>();
		bpos = findsBussinessHallPO();
		
		for(int i = 0;i < bpos.size();i++){
			if(bpos.get(i).getHallName().equals(id)){
				bpos.remove(i);
				break;
			}
		}
		
		ObjectOutputStream os = null;
		
		try {
			os = new ObjectOutputStream(new FileOutputStream(file,false));
			
			for(int j = 0;j < bpos.size();j++){
				os.writeObject(bpos.get(j));
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
