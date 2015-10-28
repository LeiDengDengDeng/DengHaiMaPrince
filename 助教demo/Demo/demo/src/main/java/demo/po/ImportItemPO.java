package demo.po;

import java.io.Serializable;

public class ImportItemPO implements Serializable{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private String list_no;
	private String commidity_no;
	private double price;
	private int amount;
	private String note;
	
	/**
	 * 进货单进货项
	 * @param id 进货项id
	 * @param list_no 进货单编号
	 * @param commodity_no 商品编号
	 * @param price 单价
	 * @param amount 数量
	 * @param note 备注
	 */
	public ImportItemPO(String list_no, String commodity_no, double price, int amount,String note){
		this.list_no = list_no;
		this.commidity_no = commodity_no;
		this.setPrice(price);
		this.amount = amount;
		this.note = note;
	}



	public String getList_no() {
		return list_no;
	}

	public void setList_no(String list_no) {
		this.list_no = list_no;
	}

	public String getCommidity_no() {
		return commidity_no;
	}

	public void setCommidity_no(String commidity_no) {
		this.commidity_no = commidity_no;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
