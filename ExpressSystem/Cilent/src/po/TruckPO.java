package po;

public class TruckPO {

	long number; // ��������
	int activeTime; // ����ʱ��
	String licensePlateNum; // ���ƺ�

	public TruckPO(long number, int activeTime, String licensePlateNum) {
		super();
		this.number = number;
		this.activeTime = activeTime;
		this.licensePlateNum = licensePlateNum;
	}
	
	public long getNumber() {
		return number;
	}
	public int getActiveTime() {
		return activeTime;
	}
	public String getLicensePlateNum() {
		return licensePlateNum;
	}
	

}
