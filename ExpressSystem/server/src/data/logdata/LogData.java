package src.data.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;

public class LogData implements LogDataService {

	@Override
	public LogPO find(long id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<LogPO> findAll() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void insert(LogPO po) throws RemoteException {
		// TODO 自动生成的方法存根

	}

	@Override
	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根

	}

}
