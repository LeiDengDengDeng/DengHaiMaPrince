package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.po.BussinessHallPO;
import src.po.DriverPO;
import src.po.TruckPO;
import src.vo.BussinessHallVO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

/**
 * ���û���Ϣҵ���߼��Ľӿ�
 * @author Potter
 *
 */
public interface NonUserBLService {
	
	/**
	 * ���û���Ϣ��ѯ����õ�ĳ��������Ϣ
	 * @param truckId
	 */
	public TruckInfoVO getTruckInfo(long truckId);
	
	/**
	 * ���û���Ϣ��ѯ����õ����г�����Ϣ
	 * @return
	 */
	public ArrayList<TruckInfoVO> getAllTruckInfo();
	
	/**
	 * ����һ������
	 * @param truck
	 */
	public void addTruckInfo(TruckInfoVO truck);
	
	/**
	 * ɾ��һ������
	 * @param truckId
	 */
	public void deleteTruckInfo(long truckId);
	
	/**
	 * �޸ĳ�����Ϣ
	 * @param truckId
	 */
	public void changeTruckInfo(long truckId);
	
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
	 * ���û���Ϣ��ѯ����õ�ĳ��Ӫҵ����Ϣ
	 * @param bussinessHallId
	 * @return
	 */
	public BussinessHallVO getBussinessHallInfo(long bussinessHallId);
	
	/**
	 * ���û���Ϣ��ѯ����õ�����Ӫҵ����Ϣ
	 * @return
	 */
	public ArrayList<BussinessHallVO> getAllBussinessHallInfo();
	
	/**
	 * ����һ��Ӫҵ��
	 * @param bussinessHall
	 */
	public void addBussinessHallInfo(BussinessHallVO bussinessHall);
	
	/**
	 * ɾ��һ��Ӫҵ��
	 * @param bussinessHallId
	 */
	public void deleteBussinessHallInfo(long bussinessHallId);
	
	/**
	 * ���ӿڣ��ṩ�޸�����״̬
	 */
	public void changeLogisticsState(String logisticsState);

}
