package src.data.beginInfodata;

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

import src.dataservice.beginInfodataservice.BeginInfoDataService;
import src.po.BeginInfoPO;

public class BeginInfoData  extends UnicastRemoteObject implements BeginInfoDataService{
	public BeginInfoData()throws RemoteException{
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 6862085597944376483L;
	private static final String FILE_PATH = "beginInfo.ser";
	File file = new File(FILE_PATH);
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	/**
	 * ≤Â»ÎBeginInfoPO
	 */
	public boolean insert(BeginInfoPO po) {
		// TODO Auto-generated method stub
		try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(po);
				oos.flush();
				oos.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ");
			return false;
		} catch (EOFException e) {
			System.out.println("END OF FILE");
			return false;
		} catch (IOException e) {
			System.out.println("IO EXCEPTION");
			return false;
		}
		return true;
	}

	public BeginInfoPO get() {
		// TODO Auto-generated method stub
		BeginInfoPO beginInfo=null;
		try {
			ois=new ObjectInputStream(new FileInputStream(file));
			beginInfo=(BeginInfoPO)ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		} catch (IOException e) {
			System.out.println("IOEXCEPTION");
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
		}
		
		return beginInfo;
	}

}
