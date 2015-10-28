package demo.po;

import java.io.Serializable;

public class CommodityPO implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String no; //商品编号
	private String name; //商品名称
	private String type; //类型
	private double b_price; //进价
	private double s_price; //售价
	private boolean mark; //删除标记
	
	/**
	 * 商品
	 * @param no 商品编号
	 * @param name 商品名称
	 * @param type 类型
	 * @param b_price 进价
	 * @param s_price 售价
	 * @param mark 删除标记	
	 */
	
	public CommodityPO(String no, String name, String type, double b_price, double s_price,boolean mark){
		this.no = no;
		this.name = name;
		this.type = type;
		this.b_price = b_price;
		this.s_price = s_price;
		this.setMark(mark);
	}

	public CommodityPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getB_price() {
		return b_price;
	}

	public void setB_price(double b_price) {
		this.b_price = b_price;
	}

	public double getS_price() {
		return s_price;
	}

	public void setS_price(double s_price) {
		this.s_price = s_price;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}
	
	
}
