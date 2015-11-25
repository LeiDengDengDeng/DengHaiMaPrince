package src.po;

import src.businesslogic.sheetbl.SheetType;

public class OrderSheetPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5527627863328717617L;

	long courierNumber; // 快递物流编号
	String senderName; // 姓名
	String senderAddress; // 地址
	String senderOrganization; // 单位
	String senderTelNum; // 电话
	String senderMobNum; // 手机号码
	String receiverName;
	String receiverAddress;
	String receiverOrganization;
	String receiverTelNum;
	String receiverMobNum;
	String actualReceiverName; // 实际收件人
	String recevingState; //收件状态
	String time; // 收件时间
	
	SheetState state = SheetState.NOT_EXAMINED;
	long ID;
	SheetType type = SheetType.ORDER_SHEET;

	public OrderSheetPO(long courierNumber, String senderName,
			String senderAddress, String senderOrganization,
			String senderTelNum, String senderMobNum, String receiverName,
			String receiverAddress, String receiverOrganization,
			String receiverTelNum, String receiverMobNum) {
		super();
		this.courierNumber = courierNumber;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderOrganization = senderOrganization;
		this.senderTelNum = senderTelNum;
		this.senderMobNum = senderMobNum;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverOrganization = receiverOrganization;
		this.receiverTelNum = receiverTelNum;
		this.receiverMobNum = receiverMobNum;
	}

	public void setReceivingInformation(String actualReceiverName,String recevingState,String time) {
		this.actualReceiverName = actualReceiverName;
		this.recevingState = recevingState;
		this.time = time;
	}

	public void setID(long ID) {
		this.ID = ID;
	}
	
	public long getCourierNumber() {
		return courierNumber;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getSenderOrganization() {
		return senderOrganization;
	}

	public String getSenderTelNum() {
		return senderTelNum;
	}

	public String getSenderMobNum() {
		return senderMobNum;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public String getReceiverOrganization() {
		return receiverOrganization;
	}

	public String getReceiverTelNum() {
		return receiverTelNum;
	}

	public String getReceiverMobNum() {
		return receiverMobNum;
	}

	public String getActualReceiverName() {
		return actualReceiverName;
	}

	public String getRecevingState() {
		return recevingState;
	}

	public SheetType getType() {
		// TODO 自动生成的方法存根
		return type;
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
