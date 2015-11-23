package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.DriverInfoVO;

public interface DriverBLService {
	/**
	 * ���û���Ϣ��ѯ����õ�ĳ��˾����Ϣ
	 * @param driverId
	 */
	public DriverInfoVO getDriverInfo(long driverId);
	
	/**
	 * ���û���Ϣ��ѯ����õ�����˾����Ϣ
	 * @return
	 */
	public ArrayList<DriverInfoVO> getAllDriverInfo();
	
	/**
	 * ����һ��˾��
	 * @param driver
	 */
	public void addDriverInfo(DriverInfoVO driver);
	
	/**
	 * ɾ��һ��˾��
	 * @param driverId
	 */
	public void deleteDriverInfo(long driverId);
	
	/**
	 * �޸�˾����Ϣ
	 * @param driverId
	 */
	public void changeDriverInfo(long driverId);
	
	/**
	 * ���ӿڣ��ṩ˾����Ϣ��ʼ��
	 * @param dvolist
	 */
	public void initDriver(ArrayList<DriverInfoVO> dvolist);
}
