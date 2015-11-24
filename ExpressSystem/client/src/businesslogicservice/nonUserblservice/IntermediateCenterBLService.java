package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.IntermediateCenterVO;

public interface IntermediateCenterBLService {
	
	/**
	 * ���û���Ϣ��ѯ����õ�ĳ����ת������Ϣ
	 * @param id
	 * @return
	 */
	public IntermediateCenterVO getIntermediateCenterInfo(String id);
	
	/**
	 * ���û���Ϣ��ѯ����õ�������ת������Ϣ
	 * @return
	 */
	public ArrayList<IntermediateCenterVO> getAllIntermediateCenterInfo();
	
	/**
	 * ����һ����ת����
	 * @param intermediateCenter
	 */
	public void addIntermediateCenter(IntermediateCenterVO intermediateCenter);
	
	/**
	 * ɾ��һ����ת����
	 * @param id
	 */
	public void deleteIntermediateCenter(String id);
	
	/**
	 * ���ӿڣ�������ת�������ڳ���
	 */
//	public void getcity();
	
	
}
