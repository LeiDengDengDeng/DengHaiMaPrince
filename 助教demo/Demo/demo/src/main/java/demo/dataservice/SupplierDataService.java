package demo.dataservice;

import java.util.List;

import demo.po.SupplierPO;

public interface SupplierDataService {

	/**
	 * 获得所有供应商
	 * @return 供应商列表
	 */
	public List<SupplierPO> findAll();
}
