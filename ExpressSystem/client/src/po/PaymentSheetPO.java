package src.po;

import src.enums.SheetState;
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
		// TODO �Զ����ɵķ������
		return type;
	}

	@Override
	public void setID(long ID) {
		this.ID = ID;
	}

	public long getID() {
		// TODO �Զ����ɵķ������
		return ID;
	}

	@Override
	public void setSheetState(SheetState state) {
		// TODO �Զ����ɵķ������
		this.state = state;
	}

	@Override
	public SheetState getSheetState() {
		// TODO �Զ����ɵķ������
		return state;
	}

}