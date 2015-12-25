package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.DriverInfoVO;

public interface DriverBLService {
	/**
	 * ���û���Ϣ��ѯ����õ�ĳ��˾����Ϣ
	 * @param driverId
	 */
	public DriverInfoVO getDriverInfo(String driverId);
	
	/**
	 * ���û���Ϣ��ѯ����õ�ĳӪҵ������˾����Ϣ
	 * @param id
	 * @return
	 */
	public ArrayList<DriverInfoVO> getDriverByBusinesshall(String id);
	
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
	public void deleteDriverInfo(String driverId);
	
	/**
	 * �޸�˾����Ϣ
	 * @param driverId
	 * @param dvo
	 */
	public void changeDriverInfo(String driverId,DriverInfoVO dvo);
	
	/**
	 * ���ӿڣ��ṩ˾����Ϣ��ʼ��
	 * @param dvolist
	 */
	public void initDriver(ArrayList<DriverInfoVO> dvolist);
}
