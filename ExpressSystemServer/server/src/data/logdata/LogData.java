package src.data.logdata;

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

import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;

public class LogData implements LogDataService {

	private static final String FILE_PATH = "log.ser";

	public LogPO find(long id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<LogPO> findAll() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<LogPO> logs = new ArrayList<LogPO>();

		ObjectInputStream os = null;
		try {
			os = new ObjectInputStream(new FileInputStream("FILE_PATH"));

			for (;;) {
				LogPO po = (LogPO) os.readObject();
				if (po == null)
					break;
				logs.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO 自动生成的 catch 块
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return logs;
	}

	public void insert(LogPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		ObjectOutputStream oos = null;
		MyObjectOutputStream moos = null;
		File file = new File(FILE_PATH);

		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			moos = new MyObjectOutputStream(new FileOutputStream(file, true));
			if (file.length() == 0) {
				oos.writeObject(po);
				oos.flush();
				oos.close();
			} else {
				moos.writeObject(po);
				moos.flush();
				moos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			System.out.println("LogFile not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根

	}

}
