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
import src.po.IntermediateCenterPO;

public class BusinessHallData extends UnicastRemoteObject implements BusinessHallDataService{
	
	public BusinessHallData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	IntermediateCenterData intermediateCenterData = new IntermediateCenterData();
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
//				System.out.println("b: " + po.getHallId());
				if (po.getHallId().equals(id)){
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
	public ArrayList<BussinessHallPO> findBussinessHallPOByCity(String city)
			throws RemoteException {
		ArrayList<BussinessHallPO> bpos = intermediateCenterData.findIntermediateCenterPO(city)
				.getBpos();
		return bpos;
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
				System.out.println("-----"+po.getHallName());
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
			
			IntermediateCenterPO ipo = null;
			ArrayList<IntermediateCenterPO> ipos = intermediateCenterData.findsIntermediateCenterPO();
			ArrayList<BussinessHallPO> bpos = new ArrayList<BussinessHallPO>();
			for(int i = 0;i < ipos.size();i++){
//				System.out.println(ipos.get(i).getId().substring(0,3).equals(bpo.getHallId().substring(0,3)));
//				System.out.println("i: " + ipos.get(i).getId().substring(0,3));
//				System.out.println("b: " + bpo.getHallId().substring(0,3));
				if(ipos.get(i).getId().substring(0,3).equals(bpo.getHallId().substring(0,3))){
					ipo = ipos.get(i);
				}
			}
			if(ipo.getBpos() != null){
				bpos = ipo.getBpos();
			}
			bpos.add(bpo);
			ipo.setBpos(bpos);
			intermediateCenterData.update(ipo.getCity(), ipo);
	}
	
	@Override
	public void update(String id, BussinessHallPO bpo) throws RemoteException {
		deleteBussinessHallPO(id);
		insert(bpo);
	}

	@Override
	public void deleteBussinessHallPO(String id) throws RemoteException {
		File file = new File(BussinessHallFILE_PATH);
		ArrayList<BussinessHallPO> bpos = new ArrayList<BussinessHallPO>();
		bpos = findsBussinessHallPO();
		for(int i = 0;i < bpos.size();i++){
//			System.out.println(bpos.get(i).getHallName());
			if(bpos.get(i).getHallId().equals(id)){
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
		
		IntermediateCenterPO ipo = null;
		ArrayList<IntermediateCenterPO> ipos = intermediateCenterData.findsIntermediateCenterPO();
		ArrayList<BussinessHallPO> bpos2 = new ArrayList<BussinessHallPO>();
		for(int i = 0;i < ipos.size();i++){
//			System.out.println(hallId);
			if(ipos.get(i).getId().substring(0,3).equals(id.substring(0,3))){
				ipo = ipos.get(i);
			}
		}
		if(ipo.getBpos() != null){
			for(int i = 0;i < ipo.getBpos().size();i++){
				if(ipo.getBpos().get(i).getHallId().equals(id)){
					bpos2 = ipo.getBpos();
					bpos2.remove(i);
					ipo.setBpos(bpos2);
				}
			}
			intermediateCenterData.update(ipo.getCity(), ipo);
		}
	}

	@Override
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}



}
