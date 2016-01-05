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
import src.dataservice.nonUserdataservice.TruckDataService;
import src.po.BussinessHallPO;
import src.po.DriverPO;
import src.po.TruckPO;

public class TruckData extends UnicastRemoteObject implements TruckDataService{
	
	public TruckData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	BusinessHallData businessHallData = new BusinessHallData();
	public static final String TruckFILE_PATH = "truck.ser";
	File file = new File(TruckFILE_PATH);

	@Override
	public TruckPO findTruckPO(String id) throws RemoteException {
		TruckPO tpo = null;
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				TruckPO po = (TruckPO) os.readObject();
				if (po.getNumber().equals(id)){
					tpo = po;
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
		if(tpo == null)	System.out.println("Not found!!");
		
		
		return tpo;
	}
	
	@Override
	public ArrayList<TruckPO> findsTruckPO(String id) throws RemoteException {
		ArrayList<BussinessHallPO> bpos = businessHallData.findsBussinessHallPO();
		BussinessHallPO bpo = null;
		ArrayList<TruckPO> tpos = new ArrayList<TruckPO>();
		for(int i = 0;i < bpos.size();i++){
			if(bpos.get(i).getHallName().equals(id)){
				bpo = bpos.get(i);
			}
		}
		if(bpo == null){
			return null;
		}
		else{
			tpos = bpo.getTrucks();
		}
		return tpos;
	}

	@Override
	public ArrayList<TruckPO> findsTruckPO() throws RemoteException {
		ArrayList<TruckPO> tpos = new ArrayList<TruckPO>();
		ObjectInputStream os = null;
		
		try {
			os = new ObjectInputStream(new FileInputStream(file));

			for (;;) {
				TruckPO po = (TruckPO) os.readObject();
				if (po == null)
					break;
				tpos.add(po);
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
		
		
		return tpos;
	}

	@Override
	public void insert(TruckPO tpo) throws RemoteException {
			ObjectOutputStream oos = null;
			MyObjectOutputStream moos = null;
			File file = new File(TruckFILE_PATH);
			
			try {
				if (file.length() == 0) {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(tpo);
					oos.flush();
					oos.close();
				} else {
					moos = new MyObjectOutputStream(new FileOutputStream(file, true));
					moos.writeObject(tpo);
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
			
		BussinessHallPO bpo = businessHallData.findBussinessHallPO(tpo.getNumber()
				.substring(0, 6));
		ArrayList<TruckPO> tpos = new ArrayList<TruckPO>();
		if(bpo.getTrucks() != null){
			tpos = bpo.getTrucks();
		}
		tpos.add(tpo);
		bpo.setTrucks(tpos);
		businessHallData.update(tpo.getNumber().substring(0, 6), bpo);
	}

	@Override
	public void update(String id,TruckPO tpo) throws RemoteException {
		deleteTruckPO(id);
		insert(tpo);
	}

	@Override
	public void deleteTruckPO(String id) throws RemoteException {
		File file = new File(TruckFILE_PATH);
		ArrayList<TruckPO> tpos = new ArrayList<TruckPO>();
		tpos = findsTruckPO();
		
		for(int i = 0;i < tpos.size();i++){
			if(tpos.get(i).getNumber().equals(id)){
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
			System.out.println("FILE NOT FOUND ");
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
		}
		
		BussinessHallPO bpo = businessHallData.findBussinessHallPO(id.substring(0, 6));
		ArrayList<TruckPO> tpos2 = new ArrayList<TruckPO>();
		if(bpo != null){
			for(int i = 0;i < bpo.getTrucks().size();i++){
				if( bpo.getTrucks().get(i).getNumber().equals(id)){
					tpos2 = bpo.getTrucks();
					tpos2.remove(i);
					bpo.setTrucks(tpos2);
				}
			}
			businessHallData.update(id.substring(0, 6), bpo);
		}
		
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
