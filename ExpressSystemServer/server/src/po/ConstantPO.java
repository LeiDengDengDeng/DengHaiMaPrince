package src.po;

import src.enums.SheetState;
import src.enums.SheetType;

public class ConstantPO implements SheetPO {

	/**
	 *
	 */
	private static final long serialVersionUID = 7774935977364748669L;

	double distant;
	double price;
	String cityOne;
	String cityTwo;

	String builder;
	String time;
	long ID;
	SheetState state = SheetState.PASSED;
	SheetType type = SheetType.CONSTANT;

	public ConstantPO(String builder, String time, double distant, double price, String cityOne, String cityTwo,
			long ID) {
		super();
		this.time = time;
		this.builder = builder;
		this.distant = distant;
		this.price = price;
		this.cityOne = cityOne;
		this.cityTwo = cityTwo;
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

	public String getCityOne() {
		return cityOne;
	}
	public String getCityTwo() {
		return cityTwo;
	}
	public void setCityOne(String city) {
		this.cityOne = city;
	}
	public void setCityTwo(String city) {
		this.cityTwo = city;
	}
	public void setType(SheetType type) {
		this.type = type;
	}

	public SheetType getType() {
		// TODO 自动生成的方法存根
		return type;
	}

	@Override
	public void setID(long ID) {
		this.ID = ID;
	}

	public long getID() {
		// TODO 自动生成的方法存根
		return ID;
	}

	@Override
	public void setSheetState(SheetState state) {
		// TODO 自动生成的方法存根
		this.state = state;
	}

	@Override
	public SheetState getSheetState() {
		// TODO 自动生成的方法存根
		return state;
	}

	@Override
	public String getBuilder() {
		return builder;
	}

	@Override
	public String getTime() {
		return time;
	}

}
