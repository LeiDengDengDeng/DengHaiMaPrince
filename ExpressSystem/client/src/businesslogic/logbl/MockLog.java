package src.businesslogic.logbl;

import java.util.ArrayList;

import src.dataservice.logdataservice.LogDataService;
import src.vo.LogVO;

public class MockLog extends Log {

	ArrayList<LogVO> logs;

	public MockLog() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public MockLog(ArrayList<LogVO> logs) {
		super();
		this.logs = logs;
	}

	@Override
	public ArrayList<LogVO> checkLog(String date) {
		return logs;
	}

	@Override
	public void generateLog(String position, String name, String operation,
			String statement) {
		System.out.println("������ɣ����ɲ�����־");
	}

}
