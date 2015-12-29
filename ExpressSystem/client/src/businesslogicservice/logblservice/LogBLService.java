package src.businesslogicservice.logblservice;

import src.vo.LogVO;

import java.util.ArrayList;

public interface LogBLService {

	/**
	 * �鿴��־
	 * @param date
	 */
	public ArrayList<LogVO> checkLog(String date);
	
	/**
	 * ���ɲ�����־
	 * @param position
	 * @param name
	 * @param operation
	 */
	public void generateLog(String position, String name, String operation,String statement);
}
