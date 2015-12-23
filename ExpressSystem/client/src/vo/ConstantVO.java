package src.vo;

import src.enums.SheetState;
import src.enums.SheetType;

public class ConstantVO implements SheetVO {
	SheetType type = SheetType.CONSTANT;
	SheetState state;
	String builder;
	String time;
	long ID;

	double distant;
	double price;
	String cityOne;
	String cityTwo;

	public ConstantVO(String builder, String time, double distant, double price, String cityOne, String cityTwo) {
		super();
		this.builder = builder;
		this.time = time;
		this.distant = distant;
		this.price = price;
		this.cityOne = cityOne;
		this.cityTwo = cityTwo;
	}

	public double getDistant() {
		return distant;
	}

	public double getPrice() {
		return price;
	}

	public String getCityOne() {
		return cityOne;
	}

	public String getCityTwo() {
		return cityTwo;
	}

	public String getTime() {
		return time;
	}

	public String getBuilder() {
		return builder;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public long getID() {
		return ID;
	}

	public void setState(SheetState state) {
		this.state = state;
	}

	public SheetState getState() {
		return state;
	}

	public SheetType getType() {
		return type;
	}
}
