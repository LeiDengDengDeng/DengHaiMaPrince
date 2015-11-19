package src.po;

import src.enums.SheetType;

public class OrderSheetPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5527627863328717617L;

	long courierNumber; // ����������
	String senderName; // ����
	String senderAddress; // ��ַ
	String senderOrganization; // ��λ
	String senderTelNum; // �绰
	String senderMobNum; // �ֻ�����
	String receiverName;
	String receiverAddress;
	String receiverOrganization;
	String receiverTelNum;
	String receiverMobNum;
	String actualReceiverName; // ʵ���ռ���
	String recevingState; //�ռ�״̬
	String time; // �ռ�ʱ��
	
	long ID;
	SheetType type = SheetType.ORDER_SHEET;

	public OrderSheetPO(long courierNumber, String senderName,
			String senderAddress, String senderOrganization,
			String senderTelNum, String senderMobNum, String receiverName,
			String receiverAddress, String receiverOrganization,
			String receiverTelNum, String receiverMobNum, long ID) {
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
		this.ID = ID;
	}

	public void setReceivingInformation(String actualReceiverName,String recevingState,String time) {
		this.actualReceiverName = actualReceiverName;
		this.recevingState = recevingState;
		this.time = time;
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
		// TODO �Զ����ɵķ������
		return type;
	}
	
	public long getID() {
		// TODO �Զ����ɵķ������
		return ID;
	}
}
