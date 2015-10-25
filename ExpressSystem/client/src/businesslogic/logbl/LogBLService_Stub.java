package src.businesslogic.logbl;

import src.businesslogicservice.logblservice.LogBLService;

public class LogBLService_Stub implements LogBLService {

	@Override
	public void checkLog(String date) {
		// TODO 自动生成的方法存根
		System.out.println("你正在查看日志！");

	}

	@Override
	public void generateLog(String position, String name, String operation) {
		// TODO 自动生成的方法存根
		System.out.println("日志已生成！---" + position + "-" + name + "-"
				+ operation + "-2015/10/26");
	}

}
