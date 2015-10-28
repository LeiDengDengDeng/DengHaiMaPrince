package demo.dataservice;

public interface DataFactoryService {

	public CommodityDataService getCommodityData();
	
	public SupplierDataService getSupplierData();
	
	public ImportListDataService getImportListData();
	
}
