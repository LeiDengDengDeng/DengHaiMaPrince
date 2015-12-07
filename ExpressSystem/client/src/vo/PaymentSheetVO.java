package src.vo;

import src.enums.SheetType;

public class PaymentSheetVO implements SheetVO {
	SheetType type = SheetType.PAYMENT_SHEET;

	String time; // ��������
	double money; // ������
	String name; // ������
	String account; // �����˺�
	String way; // ��Ŀ
	String remark; // ��ע

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
