package src.vo;

public class TruckInfoVO {
	private String number; // ��������
	private int activeTime; // ����ʱ��
	private String licensePlateNum; // ���ƺ�
	
	public TruckInfoVO(String number, int activeTime, String licensePlateNum) {
		super();
		this.number = number;
		this.activeTime = activeTime;
		this.licensePlateNum = licensePlateNum;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(int activeTime) {
		this.activeTime = activeTime;
	}

	public String getLicensePlateNum() {
		return licensePlateNum;
	}

	public void setLicensePlateNum(String licensePlateNum) {
		this.licensePlateNum = licensePlateNum;
	}
	
	

}
