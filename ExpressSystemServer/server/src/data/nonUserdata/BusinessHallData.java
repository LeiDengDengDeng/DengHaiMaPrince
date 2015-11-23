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
import src.dataservice.nonUserdataservice.BusinessHallDataService;
import src.po.BussinessHallPO;

public class BusinessHallData implements BusinessHallDataService{
	
	public static final String BussinessHallFILE_PATH = "bussinesshall.ser";

	@Override
	public BussinessHallPO findBussinessHallPO(String id)
			throws RemoteException {
		BussinessHallPO bpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("BussinessHallFILE_PATH"));

			for (;;) {
				BussinessHallPO po = (BussinessHallPO) os.readObject();
				if (po.getHallName() == id){
					bpo = po;
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
		if(bpo == null)	System.out.println("Not found!!");
		
		
		return bpo;
	}

	@Override
	public ArrayList<BussinessHallPO> findsBussinessHallPO()
			throws RemoteException {
		ArrayList<BussinessHallPO> bpos = new ArrayList<BussinessHallPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream("BussinessHallFILE_PATH"));

			for (;;) {
				BussinessHallPO po = (BussinessHallPO) os.readObject();
				if (po == null)
					break;
				bpos.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return bpos;
	}

	@Override
	public void insert(BussinessHallPO bpo) throws RemoteException {
		if(findBussinessHallPO(bpo.getHallName()) == null){
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(BussinessHallFILE_PATH);
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				moos = new MyObjectOutputStream(new FileOutputStream(file, true));
				if (file.length() == 0) {
					oos.writeObject(bpo);
					oos.flush();
					oos.close();
				} else {
					moos.writeObject(bpo);
					moos.flush();
					moos.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("BussinessHallFile not found");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		else System.out.println("Already exist!!");
	}

	@Override
	public void deleteBussinessHallPO(String id) throws RemoteException {
		File file = new File(BussinessHallFILE_PATH);
		ArrayList<BussinessHallPO> bpos = new ArrayList<BussinessHallPO>();
		bpos = findsBussinessHallPO();
		
		for(int i = 0;i < bpos.size();i++){
			if(bpos.get(i).getHallName() == id){
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
