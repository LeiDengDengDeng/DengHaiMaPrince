package src.po;

import src.businesslogic.sheetbl.SheetType;

public class ConstantPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7774935977364748669L;

	double distant;
	double price ;
	String city;

	long ID;
	SheetType type = SheetType.CONSTANT;

	public ConstantPO(double distant, double price, String city,long ID) {
		super();
		this.distant = distant;
		this.price = price;
		this.city = city;
		this.ID = ID;
	}

	public double getDistant() {
		return distant;
	}

	public void setDistant(double distant) {
		this.distant = distant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setType(SheetType type) {
		this.type = type;
	}

	public SheetType getType() {
		// TODO 自动生成的方法存根
		return type;
	}

	public long getID() {
		// TODO 自动生成的方法存根
		return ID;
	}
}
