package src.vo;


public class OrderSheetVO implements SheetVO {
	long courierNumber; // ����������
	String senderName; // ����
	String senderAddress; // ��ַ
	String senderOrganization; // ��λ
	
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
	
}
