package po;

import java.io.Serializable;

public class PaymentSheetPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8171053318599518781L;

	String time; // 付款日期
	double money; // 付款金额
	String name; // 付款人
	String account; // 付款账号
	// PaymentDetail way; // 条目
	String remark; // 备注

	public PaymentSheetPO(String time, double money, String name,
			String account, String remark) {
		super();
		this.time = time;
		this.money = money;
		this.name = name;
		this.account = account;
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

	public String getRemark() {
		return remark;
	}

}
