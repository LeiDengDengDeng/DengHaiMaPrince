package src.businesslogicservice.commodityblservice;

import java.util.ArrayList;


public interface LogisticBLService {
	/**
	 * ���ӿڣ��ṩ�޸�����״̬
	 */
	public void changeLogisticsState(String expressNumber,String logisticsState);
	
	/**
	 * ������Ϣ��ѯ
	 * @param expressNumber
	 * @return
	 */
	public ArrayList<String> getLogisticsState(String expressNumber);
}
