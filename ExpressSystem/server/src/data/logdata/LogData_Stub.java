package src.data.logdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;

public class LogData_Stub implements LogDataService{

	@Override
	public LogPO find(long id) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功找到Log!");
		LogPO po = new LogPO("A","B","Z","2015/10/26");
		return po;
	}

	@Override
	public ArrayList<LogPO> findAll() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功找到一组Sheet!");
	    ArrayList<LogPO> logs = new ArrayList<LogPO>();
	    LogPO po = new LogPO("A","B","Z","2015/10/26");
	    logs.add(po);
		return logs;
	}

	@Override
	public void insert(LogPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功插入Log!");
	}

	@Override
	public void finish() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("成功结束Log数据使用!");
	}

}
