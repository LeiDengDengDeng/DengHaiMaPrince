package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.BussinessHallVO;

public interface BussinessHallBLService {
	/**
	 * ���û���Ϣ��ѯ����õ�ĳ��Ӫҵ����Ϣ
	 * @param bussinessHallId
	 * @return
	 */
	public BussinessHallVO getBussinessHallInfo(String bussinessHallId);
	
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
	public void deleteBussinessHallInfo(String bussinessHallId);
}
