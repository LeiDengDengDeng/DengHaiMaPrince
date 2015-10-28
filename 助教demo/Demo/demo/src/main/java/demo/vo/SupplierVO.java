package demo.vo;

public class SupplierVO {
	private int id; //编号
	private String name; //供应商名
	
	/**
	 * 供应商
	 * @param id 编号
	 * @param name 供应商名
	 * @param mark 删除标记
	 */
	public SupplierVO(int id, String name){
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString(){
		return name;
	}
}
