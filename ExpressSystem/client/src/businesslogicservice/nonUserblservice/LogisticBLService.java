package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;


public interface LogisticBLService {
	/**
	 * ���ӿڣ��ṩ�޸�����״̬
	 */
	public void changeLogisticsState(String logisticsState);
	
	/**
	 * ������Ϣ��ѯ
	 * @param expressNumber
	 * @return
	 */
	public ArrayList<String> getLogisticsState(long expressNumber);
}
