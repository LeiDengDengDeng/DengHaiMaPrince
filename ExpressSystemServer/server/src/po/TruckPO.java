package src.po;

import java.io.Serializable;

public class TruckPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4423168177178972631L;
	String number; // 车辆代号
	int activeTime; // 服役时间
	String licensePlateNum; // 车牌号
	
	public TruckPO(String number, int activeTime, String licensePlateNum) {
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
