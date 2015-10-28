package src.businesslogicservice.commodityblservice;

import java.util.ArrayList;

import src.po.GoodsPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.StorageInfoVO;

/**
 * ���ҵ���߼��Ľӿ�
 * @author Potter
 *
 */
public interface CommodityBLService {
	
	/**
	 * �̵����õ�������������Ϣ
	 */
	public ArrayList<ExpressInfoVO> stockTaking();
	
	/**
	 * ���ⲿ����Excel
	 */
	public void exportExcel();
	
	/**
	 * �޸ľ������
	 * @param alarmScale
	 */
	public void changeAlarmScale(double alarmScale);
	
	/**
	 * ���鿴����õ�һ��ʱ���ڵĿ����Ϣ
	 * @return 
	 */
	public ArrayList<StorageInfoVO> checkStorageMessage();
	public StoragePO getStorageNum(long startTime,long endTime);
	
	/**
	 * ��Ʒ������������ֵ��ʵ�ֿ�汨��
	 */
	public void alarm ();
	
	/**
	 * �Ի�����п����������������Ŀ�����
	 * @param gpo
	 * @param spo
	 */
	public void divide (GoodsPO gpo, StoragePO spo);
	
	/**
	 * ����������
	 */
	public void endCommodityManagement();

}
