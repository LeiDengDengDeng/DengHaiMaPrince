package src.vo;

public class TruckInfoVO {
	private long number; // ��������
	private int activeTime; // ����ʱ��
	private String licensePlateNum; // ���ƺ�
	
	public TruckInfoVO(long number, int activeTime, String licensePlateNum) {
		super();
		this.number = number;
		this.activeTime = activeTime;
		this.licensePlateNum = licensePlateNum;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
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
