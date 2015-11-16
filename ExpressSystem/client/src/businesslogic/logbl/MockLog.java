package src.businesslogic.logbl;

import java.util.ArrayList;

import src.dataservice.logdataservice.LogDataService;

public class MockLog extends Log{
	
	ArrayList<String> logs;

	public MockLog(LogDataService logData) {
		super(logData);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public MockLog(ArrayList<String> logs){
		super(null);
		this.logs = logs;
	}

	@Override
	public ArrayList<String> checkLog(String date) {
		return logs;
	}

	@Override
	public void generateLog(String position, String name, String operation) {
		System.out.println("������ɣ����ɲ�����־");
	}
	

}
