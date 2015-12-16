package src.data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.dataservice.commoditydataservice.CommodityDataService;
import src.enums.GoodsType;
import src.po.GoodsPO;
import src.po.StoragePO;

/**
 * ʵ�ֿ�����ݲ����Ľӿ�
 * @author Potter
 *
 */
public class CommodityData_Stub implements CommodityDataService{

	public GoodsPO findGoodsPO(long id) throws RemoteException {
		System.out.println("�ɹ��ҵ�GoodsPO!");
		ArrayList<String> local = new ArrayList<String>();
		local.add("������");
		GoodsPO gpo = new GoodsPO(local, 1, 1.0, 1.0, 1.0, 1.0, 1.0, 
				"����ĸ��", GoodsType.ECONOMIC, GoodsType.WOODPACKAGE, 
				0000000000000000, 20151025, "�Ͼ�", GoodsType.RAIL, 001, 
				001, 001, 001, "0250201510250000000", 
				"0250201510250000000");
		return gpo;
	}

	public StoragePO findStoragePO(long id) throws RemoteException {
		System.out.println("�ɹ��ҵ�StoragePO!");
		ArrayList<GoodsPO> gposList = new ArrayList<GoodsPO>();
		gposList.add(findGoodsPO(1));
		StoragePO spo = null;
		return spo;
	}

	public ArrayList<GoodsPO> finds(GoodsType type) throws RemoteException {
		System.out.println("�ɹ��ҵ�һ��GoodsPO");
		ArrayList<GoodsPO> gposList = new ArrayList<GoodsPO>();
		gposList.add(findGoodsPO(1));
		return gposList;
	}

	public void insert(GoodsPO gpo) throws RemoteException {
		System.out.println("�ɹ�����GoodsPO!");
		
	}

	public void insert(StoragePO spo) throws RemoteException {
		System.out.println("�ɹ�����StoragePO!");
		
	}

	public void update(GoodsPO gpo) throws RemoteException {
		System.out.println("�ɹ�����GoodsPO !");
		
	}

	public void update(StoragePO spo) throws RemoteException {
		System.out.println("�ɹ�����StoragePO!");
	}

	public void finish() throws RemoteException {
		System.out.println("�ɹ�����commodity����ʹ��!");
		
	}
	
}
