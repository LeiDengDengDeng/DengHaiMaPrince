package src.po;

import src.businesslogic.sheetbl.SheetType;

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
	
	SheetType type = SheetType.ORDER_SHEET;

	public void setReceivingInformation(String actualReceiverName,String recevingState) {
		this.actualReceiverName = actualReceiverName;
		this.recevingState = recevingState;
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
	
	@Override
	public SheetType getType() {
		// TODO �Զ����ɵķ������
		return type;
	}
}
