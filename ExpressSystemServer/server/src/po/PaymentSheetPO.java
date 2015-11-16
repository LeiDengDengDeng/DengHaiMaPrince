package src.po;

import src.enums.SheetType;

public class PaymentSheetPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8171053318599518781L;

	String time; // ��������
	double money; // ������
	String name; // ������
	String account; // �����˺�
	String way; // ��Ŀ
	String remark; // ��ע

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
		// TODO �Զ����ɵķ������
		return type;
	}

}
