package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.TruckInfoVO;

public interface TruckBLService {
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
	 * @param tvo
	 */
	public void changeTruckInfo(long truckId,TruckInfoVO tvo);
	
	/**
	 * ���ӿڣ��ṩ������Ϣ��ʼ��
	 * @param tvo
	 */
	public void initTruck(ArrayList<TruckInfoVO> tvolist);
}
