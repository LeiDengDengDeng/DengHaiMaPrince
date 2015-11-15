package src.businesslogicservice.commodityblservice;

import java.util.ArrayList;

import src.po.GoodsPO;
import src.po.StorageInSheetPO;
import src.po.StorageOutSheetPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.SheetVO;
import src.vo.StorageInSheetVO;
import src.vo.StorageInfoVO;
import src.vo.StorageInitVO;
import src.vo.StorageNumVO;
import src.vo.StorageOutSheetVO;

/**
 * ���ҵ���߼��Ľӿ�
 * @author Potter
 *
 */
public interface CommodityBLService {
	
	/**
	 * ��òֿ�id��
	 */
	public void getStorageId();
	
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
	public StorageNumVO getStorageNum(long startTime,long endTime);
	
	/**
	 * ��Ʒ������������ֵ��ʵ�ֿ�汨��
	 */
	public boolean alarm ();
	
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
	

	/**
	 * ���ӿڣ��ṩ�޸Ŀ����Ϣ
	 */
	public void changeStorageInInfo(ArrayList<SheetVO> svolist);
	
	/**
	 * ���ӿڣ��ṩ�����Ϣ��ʼ��
	 */
	public void initStorageInfo(StorageInitVO sivo);

}
