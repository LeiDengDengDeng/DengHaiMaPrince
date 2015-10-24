package po;


public class OrderSheetPO implements Sheet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5527627863328717617L;

	long courierNumber;  // ����������
	
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
	// ReceivingState state; //�ռ�״̬
	// String time; //�ռ�ʱ��

	public OrderSheetPO(long ID, String senderName, String senderAddress,
			String senderOrganization, String senderTelNum,
			String senderMobNum, String receiverName, String receiverAddress,
			String receiverOrganization, String receiverTelNum,
			String receiverMobNum, String actualReceiverName) {
		super();
		this.courierNumber = ID;
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
		this.actualReceiverName = actualReceiverName;
	}
	
	public void setReceivingInformation(String n) {
		actualReceiverName = n;
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
}
