package src.businesslogicservice.logblservice;

public interface LogBLService {

	/**
	 * �鿴��־
	 * @param date
	 */
	public void checkLog(String date);
	
	/**
	 * ���ɲ�����־
	 * @param position
	 * @param name
	 * @param operation
	 */
	public void generateLog(String position, String name, String operation);
}
