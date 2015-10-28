package demo.data;

import demo.data.stub.CommodityDataStub;
import demo.data.stub.ImportListDataStub;
import demo.data.stub.SupplierDataStub;
import demo.dataservice.CommodityDataService;
import demo.dataservice.DataFactoryService;
import demo.dataservice.ImportListDataService;
import demo.dataservice.SupplierDataService;
import demo.dataservice.impl.CommodityDataServiceMysqlImpl;
import demo.dataservice.impl.CommodityDataServiceSerializableFileImpl;
import demo.dataservice.impl.CommodityDataServiceTxtFileImpl;
import demo.dataservice.impl.ImportListDataServiceMysqlImpl;
import demo.dataservice.impl.ImportListDataServiceTxtFileImpl;
import demo.dataservice.impl.ImportListDataServiceSerializableFileImpl;
import demo.dataservice.impl.SupplierDataServiceMysqlImpl;
import demo.dataservice.impl.SupplierDataServiceSerializableFileImpl;
import demo.dataservice.impl.SupplierDataServiceTxtFileImpl;


public class DataFactory implements DataFactoryService {

	public CommodityDataService getCommodityData() {
		CommodityDataService data = new CommodityDataServiceTxtFileImpl();            //商品数据操作txt实现
//		CommodityDataService data = new CommodityDataServiceSerializableFileImpl();   //商品数据操作序列化文件实现
//		CommodityDataService data = new CommodityDataServiceMysqlImpl();              //商品数据操作Mysql实现
		return data;
	}

	public SupplierDataService getSupplierData() {
		SupplierDataService data = new SupplierDataServiceTxtFileImpl();                  //供应商数据操作txt实现
//		SupplierDataService data = new SupplierDataServiceSerializableFileImpl();     //供应商数据操作序列化文件实现
//		SupplierDataService data = new SupplierDataServiceMysqlImpl();                //供应商数据操作mysql实现
		return data;
	}

	public ImportListDataService getImportListData() {
		ImportListDataService data = new ImportListDataServiceTxtFileImpl();  //进货单数据操作txt实现
//		ImportListDataService data = new ImportListDataServiceSerializableFileImpl();  //进货单数据操作序列化文件实现
//		ImportListDataService data = new ImportListDataServiceMysqlImpl();  //进货单数据操作Mysql实现
		return data;
	}

}
