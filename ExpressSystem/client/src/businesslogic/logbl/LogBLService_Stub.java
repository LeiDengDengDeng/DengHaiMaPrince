package src.businesslogic.logbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;

public class LogBLService_Stub implements LogBLService {

	@Override
	public ArrayList<String> checkLog(String date) {
		// TODO 自动生成的方法存根
		System.out.println("你正在查看日志！");

		return null;
	}

	@Override
	public void generateLog(String position, String name, String operation,
			String statement) {
		// TODO 自动生成的方法存根
		System.out.println("日志已生成！---" + position + "-" + name + "-"
				+ operation + "-2015/10/26");
	}

}
