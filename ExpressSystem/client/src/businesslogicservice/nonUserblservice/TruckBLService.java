package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.TruckInfoVO;

public interface TruckBLService {
	/**
	 * ���û���Ϣ��ѯ����õ�ĳ��������Ϣ
	 * @param truckId
	 */
	public TruckInfoVO getTruckInfo(String truckId);
	
	/**
	 * ���û���Ϣ��ѯ����õ�ĳӪҵ�����г�����Ϣ
	 * @param id
	 * @return
	 */
	public ArrayList<TruckInfoVO> getTruckByBusinesshall(String id);
	
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
	public void deleteTruckInfo(String truckId);
	
	/**
	 * �޸ĳ�����Ϣ
	 * @param truckId
	 * @param tvo
	 */
	public void changeTruckInfo(String truckId,TruckInfoVO tvo);
	
	/**
	 * ���ӿڣ��ṩ������Ϣ��ʼ��
	 * @param tvo
	 */
	public void initTruck(ArrayList<TruckInfoVO> tvolist);
}
