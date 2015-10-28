package demo.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ImportListPO implements Serializable {
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private String no;//进货单编号
	private int supplier_id;//供应商id
	private ArrayList<ImportItemPO> importList;//进货商品列表
	private Date add_time;//进货单添加时间
	
	/**
	 * 进货单
	 * @param no 进货单编号
	 * @param supplier_id 供应商id
	 * @param add_time 进货单添加时间
	 */
	public ImportListPO(String no, int supplier_id, Date add_time){
		this.no = no;
		this.supplier_id = supplier_id;
		this.add_time = add_time;
		importList = new ArrayList<ImportItemPO>();
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public ArrayList<ImportItemPO> getImportList() {
		return importList;
	}

	public void setImportList(ArrayList<ImportItemPO> importList) {
		this.importList = importList;
	}

	public Date getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
}
