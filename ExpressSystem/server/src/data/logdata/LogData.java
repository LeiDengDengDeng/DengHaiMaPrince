package src.data.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;

public class LogData implements LogDataService {

	@Override
	public LogPO find(long id) throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<LogPO> findAll() throws RemoteException {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void insert(LogPO po) throws RemoteException {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void finish() throws RemoteException {
		// TODO �Զ����ɵķ������

	}

}
