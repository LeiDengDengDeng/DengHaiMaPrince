package src.businesslogic.commoditybl;

import java.util.ArrayList;

import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.po.GoodsPO;
import src.po.StoragePO;

/**
 * ���ҵ���߼��ӿڵ��ϲ�����
 * @author Potter
 *
 */
public class CommodityBLService_Driver {
	
	private GoodsPO gpo;
	private StoragePO spo;
	
	public void drive(CommodityBLService commodityBLService){
		
		ArrayList<String> local = new ArrayList<>();
		local.add("������");
		gpo  = new GoodsPO(local, 1, 1.0, 1.0, 1.0, 1.0, 1.0, 
				"����ĸ��", GoodsType.ECONOMIC, GoodsType.WOODPACKAGE, 
				0000000000000000, 20151025, "�Ͼ�", GoodsType.RAIL, 001, 
				001, 001, 001, "0250201510250000000", 
				"0250201510250000000");
		
		ArrayList<GoodsPO> gposList = new ArrayList<>();
		gposList.add(gpo);
		spo = new StoragePO("�Ͼ�",100, 100, 1000, 200, 300, 300, 200,
				0.9, 1, 200, 201, 500, 501, 800, 801, 1000, gposList);
		//����̵�
		commodityBLService.stockTaking();
		
		//����excel
		commodityBLService.exportExcel();
		
		//�޸ľ������
		commodityBLService.changeAlarmScale(0.9);
		
		//�����Ϣ�鿴
		commodityBLService.checkStorageMessage();
		commodityBLService.getStorageNum(20151010, 20151026);
		
		//��汨��
		commodityBLService.alarm();
		
		//������
		commodityBLService.divide(gpo, spo);
		
		//�ر�����
		commodityBLService.endCommodityManagement();
	}

}
