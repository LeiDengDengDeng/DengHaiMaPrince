package src.data.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;

public class LogData_Stub implements LogDataService{

	public LogPO find(long id) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ��ҵ�Log!");
		LogPO po = new LogPO("A","B","Z","2015/10/26");
		return po;
	}

	public ArrayList<LogPO> findAll() throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ��ҵ�һ��Sheet!");
	    ArrayList<LogPO> logs = new ArrayList<LogPO>();
	    LogPO po = new LogPO("A","B","Z","2015/10/26");
	    logs.add(po);
		return logs;
	}

	public void insert(LogPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ�����Log!");
	}

	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������
		System.out.println("�ɹ�����Log����ʹ��!");
	}

}
