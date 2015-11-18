package src.businesslogicservice.logblservice;

import java.util.ArrayList;

public interface LogBLService {

	/**
	 * 查看日志
	 * @param date
	 */
	public ArrayList<String> checkLog(String date);
	
	/**
	 * 生成操作日志
	 * @param position
	 * @param name
	 * @param operation
	 */
	public void generateLog(String position, String name, String operation,String statement);
}
