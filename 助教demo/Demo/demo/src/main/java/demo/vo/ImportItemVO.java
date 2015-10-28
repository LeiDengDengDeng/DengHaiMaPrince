package demo.vo;

import java.util.Vector;

public class ImportItemVO extends Vector<String> {
	private static final long serialVersionUID = 1L;

	/**
	 * 进货单进货项VO
	 * @param no 商品编号
	 * @param name 商品名称
	 * @param type 商品类型
	 * @param amount 数量
	 * @param price 单价
	 * @param totalPrice 总价
	 * @param note 备注
	 */
	public ImportItemVO(String no, String name, String type, int amount, double price, double totalPrice, String note){
		this.add(no);
		this.add(name);
		this.add(type);
		this.add(""+amount);
		this.add(""+price);
		this.add(""+totalPrice);
		this.add(note);
	}

	public String getNo() {
		return this.get(0);
	}

	public String getName() {
		return this.get(1);
	}
	
	public String getType(){
		return this.get(2);
	}
	
	public int getAmount() {
		int amount = Integer.parseInt(this.get(3));
		return amount;
	}

	public double getPrice() {
		double price = Double.parseDouble(this.get(4));
		return price;
	}

	public double getTotalPrice() {
		double totalPrice = Double.parseDouble(this.get(5));
		return totalPrice;
	}

	public String getNote() {
		return this.get(6);
	}
}
