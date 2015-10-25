package src.businesslogicservice.logblservice;

public interface LogBLService {

	/**
	 * 查看日志
	 * @param date
	 */
	public void checkLog(String date);
	
	/**
	 * 生成操作日志
	 * @param position
	 * @param name
	 * @param operation
	 */
	public void generateLog(String position, String name, String operation);
}
