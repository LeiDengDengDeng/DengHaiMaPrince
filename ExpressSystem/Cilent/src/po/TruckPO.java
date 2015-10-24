package po;

public class TruckPO {

	long number; // 车辆代号
	int activeTime; // 服役时间
	String licensePlateNum; // 车牌号

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
