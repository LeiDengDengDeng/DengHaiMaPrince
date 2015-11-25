package src.businesslogic.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;
import src.businesslogic.util.CommonUtil;

public class Log implements LogBLService {

	LogDataService logData;

	public Log(LogDataService logData) {
		this.logData = logData;
	}

	@Override
	public ArrayList<String> checkLog(String date) {
		// TODO 自动生成的方法存根
		ArrayList<String> logContents = new ArrayList<String>();
		try {
			ArrayList<LogPO> logs = logData.findAll();

			// date为空，返回所有日志
			if (date == null) {
				for (LogPO log : logs) logContents.add(log.getLog());
			} else {
				for (LogPO log : logs)
					if (log.getDate().equals(date))
						logContents.add(log.getLog());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return logContents;
	}

	@Override
	public void generateLog(String position, String name, String operation,
			String statement) {
		// TODO 自动生成的方法存根
		LogPO log = new LogPO(position, name, operation, statement,
				CommonUtil.getDate());

		try {
			logData.insert(log);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
