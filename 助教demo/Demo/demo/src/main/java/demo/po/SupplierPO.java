package demo.po;

import java.io.Serializable;

public class SupplierPO implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private int id; //编号
	private String name; //供应商名
	private boolean mark;
	
	/**
	 * 供应商
	 * @param id 编号
	 * @param name 供应商名
	 * @param mark 删除标记
	 */
	public SupplierPO(int id, String name, boolean mark){
		this.id = id;
		this.name = name;
		this.setMark(mark);
	}
	
	public SupplierPO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}
}
