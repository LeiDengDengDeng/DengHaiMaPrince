package src.po;

import java.io.Serializable;

public class TruckPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4423168177178972631L;
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
