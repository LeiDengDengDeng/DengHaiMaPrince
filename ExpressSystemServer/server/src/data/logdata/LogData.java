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
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;

public class LogData extends UnicastRemoteObject implements LogDataService {

    /**
     *
     */
    private static final long serialVersionUID = -4547810155502739071L;

    private static final String FILE_PATH = "log.ser";
    private static final File FILE = new File(FILE_PATH);
    
    private static LogData logData;

    private LogData() throws RemoteException {
    }
    
	public static LogData getLogData(){
		if(logData == null)
			try {
				return logData = new LogData();
			} catch (RemoteException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		return logData;
	}

    public LogPO find(long id) throws RemoteException {
        // TODO �Զ����ɵķ������
        return null;
    }

    public ArrayList<LogPO> findAll() throws RemoteException {
        // TODO �Զ����ɵķ������
        ArrayList<LogPO> logs = new ArrayList<LogPO>();

		ObjectInputStream os = null;
		try {
			os = new ObjectInputStream(new FileInputStream(FILE));

			for (;;) {
				LogPO po = (LogPO) os.readObject();
				if (po == null)
					break;
				logs.add(po);
			}

			os.close();
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO �Զ����ɵ� catch ��
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
        return logs;
    }

    public void insert(LogPO po) throws RemoteException {
        // TODO �Զ����ɵķ������
        ObjectOutputStream oos = null;
        MyObjectOutputStream moos = null;

        try {
            if (FILE.length() == 0) {
                oos = new ObjectOutputStream(new FileOutputStream(FILE));
                oos.writeObject(po);
                oos.flush();
                oos.close();
            } else {
                moos = new MyObjectOutputStream(new FileOutputStream(FILE, true));
                moos.writeObject(po);
                moos.flush();
                moos.close();
            }
        } catch (FileNotFoundException e) {
            // TODO �Զ����ɵ� catch ��
            System.out.println("LogFile not found");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }

    }

    public void finish() throws RemoteException {
        // TODO �Զ����ɵķ������

    }

}
