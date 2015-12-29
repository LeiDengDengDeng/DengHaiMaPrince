package src.businesslogic.logbl;

import java.util.ArrayList;

import src.dataservice.logdataservice.LogDataService;
import src.vo.LogVO;

public class MockLog extends Log {

	ArrayList<LogVO> logs;

	public MockLog() {
		super();
		// TODO 自动生成的构造函数存根
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
		System.out.println("操作完成，生成操作日志");
	}

}
