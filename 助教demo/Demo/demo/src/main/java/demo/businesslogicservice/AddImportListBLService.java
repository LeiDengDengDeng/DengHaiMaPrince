package demo.businesslogicservice;

import java.util.List;

import demo.vo.ImportItemVO;
import demo.vo.SupplierVO;

public interface AddImportListBLService {
	
	/**
	 * 获取供应商列表
	 * @return 返回供应商列表
	 */
	public List<SupplierVO> getSupplierList();
	
	/**
	 * 选择供应商
	 * @param selected 选择的供应商
	 * @return 返回是否成功选择供应商
	 */
	public boolean selectSupplier(SupplierVO selected);
	
	/**
	 * 添加进货项
	 * @param no 商品编号
	 * @param amount 数量
	 * @param note 备注
	 * @return 返回进货项信息，包括商品编号、名称、类型、数量、单价、总价、备注
	 */
	public ImportItemVO addItem(String no, int amount, String note);
	
	/**
	 * 获得总价
	 * @return 返回总价
	 */
	public double getTotalPrice();
	
	/**
	 * 删除进货项
	 * @param index 进货项的序号（0开始）
	 * @return 返回是否成功删除进货项
	 */
	public boolean deleteItem(int index);
	
	/**
	 * 提交进货单
	 * @return 返回是否成功提交进货单
	 */
	public boolean submit();
}
