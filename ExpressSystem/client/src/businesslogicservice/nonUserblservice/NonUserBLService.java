package src.businesslogicservice.nonUserblservice;

/**
 * ���û���Ϣҵ���߼��Ľӿ�
 * @author Potter
 *
 */
public interface NonUserBLService {
	
	/**
	 * ���û���Ϣ��ѯ����õ�������Ϣ
	 * @param truckId
	 */
	public void checkTruck(long truckId);
	
	/**
	 * ���û���Ϣ��ѯ����õ�˾����Ϣ
	 * @param driverId
	 */
	public void checkDriver (long driverId);

}
