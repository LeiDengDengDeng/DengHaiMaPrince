package src.businesslogicservice.nonUserblservice;

import java.util.ArrayList;

import src.vo.IntermediateCenterVO;

public interface IntermediateCenterBLService {
	
	/**
	 * 非用户信息查询界面得到某个中转中心信息
	 * @param id
	 * @return
	 */
	public IntermediateCenterVO getIntermediateCenterInfo(String id);
	
	/**
	 * 非用户信息查询界面得到所有中转中心信息
	 * @return
	 */
	public ArrayList<IntermediateCenterVO> getAllIntermediateCenterInfo();
	
	/**
	 * 增加一个中转中心
	 * @param intermediateCenter
	 */
	public void addIntermediateCenter(IntermediateCenterVO intermediateCenter);
	
	/**
	 * 删除一个中转中心
	 * @param id
	 */
	public void deleteIntermediateCenter(String id);
	
	/**
	 * 供接口，返回中转中心所在城市
	 */
//	public void getcity();
	
	
}
