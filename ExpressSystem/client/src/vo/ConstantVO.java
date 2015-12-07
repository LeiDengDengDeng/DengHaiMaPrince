package src.vo;

import src.enums.SheetType;

public class ConstantVO implements SheetVO{
    SheetType type = SheetType.CONSTANT;

	double distant;
	double price ;
	String city;

	public double getDistant() {
		return distant;
	}
	public double getPrice() {
		return price;
	}
	public String getCity() {
		return city;
	}
	public ConstantVO(double distant, double price, String city) {
		super();
		this.distant = distant;
		this.price = price;
		this.city = city;
	}

	@Override
	public SheetType getType() {
		return type;
	}
}
