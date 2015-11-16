package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.vo.SheetVO;
import src.vo.StorageInitVO;

public class MockCommodity extends Commodity{

	public MockCommodity(LogBLService log) {
		super(log);
	}
	
	public String getStorageId() {
		return "������˹";
	}
	
	public void changeStorageInInfo(ArrayList<SheetVO> svolist) {
		System.out.println("���յ������Ϣ");
	}
	
	public void initStorageInfo(StorageInitVO sivo) {
		System.out.println("�����Ϣ�ѳ�ʼ��");
	}

}
