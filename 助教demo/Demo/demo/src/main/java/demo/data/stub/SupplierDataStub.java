package demo.data.stub;

import java.util.ArrayList;

import demo.dataservice.SupplierDataService;
import demo.po.SupplierPO;

public class SupplierDataStub implements SupplierDataService {

	public ArrayList<SupplierPO> findAll() {
		SupplierPO supplier1 = new SupplierPO(1, "供应商1", false);
		SupplierPO supplier2 = new SupplierPO(2, "供应商2", false);
		ArrayList<SupplierPO> list = new ArrayList<SupplierPO>();
		list.add(supplier1);
		list.add(supplier2);
		return list;
	}
	
}
