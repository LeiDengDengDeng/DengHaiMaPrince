package src.po;

import src.enums.SheetState;
import src.enums.SheetType;

public class PaymentSheetPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8171053318599518781L;

	String time; // 付款日期
	double money; // 付款金额
	String name; // 付款人
	String account; // 付款账号
	String way; // 条目
	String remark; // 备注

	SheetState state = SheetState.NOT_EXAMINED;
	long ID;
	SheetType type = SheetType.PAYMENT_SHEET;

	public PaymentSheetPO(String time, double money, String name,
			String account, String way, String remark) {
		super();
		this.time = time;
		this.money = money;
		this.name = name;
		this.account = account;
		this.way = way;
		this.remark = remark;
		this.ID = ID;
	}

	public String getTime() {
		return time;
	}

	public double getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public String getAccount() {
		return account;
	}
	
	public String getWay() {
		return way;
	}

	public String getRemark() {
		return remark;
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

}