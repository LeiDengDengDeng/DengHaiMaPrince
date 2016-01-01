package src.businesslogicservice.commodityblservice;

import java.util.ArrayList;

import src.businesslogic.commoditybl.AlarmMessage;
import src.enums.GoodsType;
import src.po.GoodsPO;
import src.po.StorageInSheetPO;
import src.po.StorageOutSheetPO;
import src.po.StoragePO;
import src.vo.ExpressInfoVO;
import src.vo.GoodsVO;
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
	 * �̵����õ�������������Ϣ
	 */
	public ArrayList<ExpressInfoVO> stockTaking(String storageId);
	
	/**
	 * ���ⲿ����Excel
	 */
	public void exportExcel(String realPath,ArrayList<ExpressInfoVO> users);
	
	/**
	 * �޸ľ������
	 * @param alarmScale
	 */
	public void changeAlarmScale(double alarmScale,String storageId);
	
	/**
	 * ��õ�ǰ�������
	 * @param storageId
	 * @return
	 */
	public double getAlarmScale(String storageId);
	
	/**
	 * ���鿴����õ�һ��ʱ���ڵĿ����Ϣ
	 * @return 
	 */
	public ArrayList <StorageInfoVO> checkStorageMessage(String storageId,long startTime,long endTime);
	public StorageNumVO getStorageNum(String storageId,long startTime,long endTime);
	
	/**
	 * ��Ʒ������������ֵ��ʵ�ֿ�汨��
	 * @return
	 */
	public AlarmMessage alarm (String storageId);
	
	/**
	 * �õ�������������Ϣ
	 * @param areaNumber
	 * @return
	 */
	public ArrayList<ExpressInfoVO> getAreaGoodsPOs(String storageId,GoodsType areaNumber);
	
	/**
	 * �Ի�����п����������������Ŀ�����
	 * @param evos
	 */
	public void divide (String storageId,ArrayList<ExpressInfoVO> evos);
	
	/**
	 * ����������
	 */
	public void endCommodityManagement();
	

	/**
	 * ���ӿڣ��ṩ�޸Ŀ����Ϣ
	 */
	public void changeStorageInInfo(String storageId,SheetVO svo);
	
	/**
	 * ���ӿڣ��ṩ�޸���Ʒ��Ϣ
	 */
	public void changeGoodInfo(String storageId,GoodsVO gvo);
	
	/**
	 * ���ӿڣ��ṩ�����Ϣ��ʼ��
	 */
	public void initStorageInfo(ArrayList<StorageInitVO> svolist);

}
