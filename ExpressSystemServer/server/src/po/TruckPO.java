package src.po;

import java.io.Serializable;

public class TruckPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4423168177178972631L;
	String number; // ��������
	int activeTime; // ����ʱ��
	String licensePlateNum; // ���ƺ�
	
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
