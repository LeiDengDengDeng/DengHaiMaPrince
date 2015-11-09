package src.vo;


public class OrderSheetVO implements SheetVO {
	long courierNumber; // 快递物流编号
	String senderName; // 姓名
	String senderAddress; // 地址
	String senderOrganization; // 单位
	
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
