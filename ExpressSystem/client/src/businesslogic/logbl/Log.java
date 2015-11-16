package src.businesslogic.logbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import src.businesslogicservice.logblservice.LogBLService;
import src.dataservice.logdataservice.LogDataService;
import src.po.LogPO;

public class Log implements LogBLService {

	LogDataService logData;

	public Log(LogDataService logData) {
		this.logData = logData;
	}

	@Override
	public ArrayList<String> checkLog(String date) {
		// TODO �Զ����ɵķ������
		ArrayList<String> logContents = new ArrayList<String>();
		try {
			ArrayList<LogPO> logs = logData.findAll();

			// dateΪ�գ�����������־
			if (date == null) {
				for (int i = 0; i < logs.size(); i++)
					logContents.add(logs.get(i).getLog());
			} else {
				for (int i = 0; i < logs.size(); i++) 
					if (logs.get(i).getDate() == date)
						logContents.add(logs.get(i).getLog());
			}
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return logContents;
	}

	@Override
	public void generateLog(String position, String name, String operation) {
		// TODO �Զ����ɵķ������
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LogPO log = new LogPO(position, name, operation,
				dateFormat.format(new Date()));

		try {
			logData.insert(log);
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
