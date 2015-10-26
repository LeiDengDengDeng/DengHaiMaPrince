package src.data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.commoditybl.GoodsType;
import src.dataservice.commoditydataservice.CommodityDataService;
import src.po.GoodsPO;
import src.po.StoragePO;

/**
 * ʵ�ֿ�����ݲ����Ľӿ�
 * @author Potter
 *
 */
public class CommodityData_Stub implements CommodityDataService{

	@Override
	public GoodsPO findGoodsPO(long id) throws RemoteException {
		System.out.println("�ɹ��ҵ�GoodsPO!");
		ArrayList<String> local = new ArrayList<>();
		local.add("������");
		GoodsPO gpo = new GoodsPO(local, 1, 1.0, 1.0, 1.0, 1.0, 1.0, 
				"����ĸ��", GoodsType.ECONOMIC, GoodsType.WOODPACKAGE, 
				0000000000000000, 20151025, "�Ͼ�", GoodsType.RAIL, 001, 
				001, 001, 001, "0250201510250000000", 
				"0250201510250000000");
		return gpo;
	}

	@Override
	public StoragePO findStoragePO(long id) throws RemoteException {
		System.out.println("�ɹ��ҵ�StoragePO!");
		ArrayList<GoodsPO> gposList = new ArrayList<>();
		gposList.add(findGoodsPO(1));
		StoragePO spo = new StoragePO(100, 100, 1000, 200, 300, 300, 200,
				0.9, 1, 200, 201, 500, 501, 800, 801, 1000, gposList);
		return spo;
	}

	@Override
	public ArrayList<GoodsPO> finds(GoodsType type) throws RemoteException {
		System.out.println("�ɹ��ҵ�һ��GoodsPO");
		ArrayList<GoodsPO> gposList = new ArrayList<>();
		gposList.add(findGoodsPO(1));
		return gposList;
	}

	@Override
	public void insert(GoodsPO gpo) throws RemoteException {
		System.out.println("�ɹ�����GoodsPO!");
		
	}

	@Override
	public void insert(StoragePO spo) throws RemoteException {
		System.out.println("�ɹ�����StoragePO!");
		
	}

	@Override
	public void update(GoodsPO gpo) throws RemoteException {
		System.out.println("�ɹ�����GoodsPO !");
		
	}

	@Override
	public void update(StoragePO spo) throws RemoteException {
		System.out.println("�ɹ�����StoragePO!");
	}

	@Override
	public void finish() throws RemoteException {
		System.out.println("�ɹ�����commodity����ʹ��!");
		
	}
	
}
