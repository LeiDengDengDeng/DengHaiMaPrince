package po;

import java.io.Serializable;

public class PaymentSheetPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8171053318599518781L;

	String time; // ��������
	double money; // ������
	String name; // ������
	String account; // �����˺�
	// PaymentDetail way; // ��Ŀ
	String remark; // ��ע

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
