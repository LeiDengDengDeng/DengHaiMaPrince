package src.vo;

import src.enums.SheetType;

public class PaymentSheetVO implements SheetVO {
	SheetType type = SheetType.PAYMENT_SHEET;

	String time; // 付款日期
	double money; // 付款金额
	String name; // 付款人
	String account; // 付款账号
	String way; // 条目
	String remark; // 备注

	public PaymentSheetVO(String time, double money, String name, String account, String way, String remark) {
		super();
		this.time = time;
		this.money = money;
		this.name = name;
		this.account = account;
		this.way = way;
		this.remark = remark;
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

	@Override
	public SheetType getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
