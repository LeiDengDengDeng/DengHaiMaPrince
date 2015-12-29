package src.businesslogicservice.logblservice;

import src.vo.LogVO;

import java.util.ArrayList;

public interface LogBLService {

    /**
     * �鿴��־
     *
     * @param date
     */
    public ArrayList<LogVO> checkLog(String date);

    /**
     * ���ɲ�����־
     *
     * @param operation
     * @param statement
     */
    public void generateLog(String operation, String statement);
}
