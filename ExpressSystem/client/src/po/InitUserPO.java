package src.po;

import java.io.Serializable;

public class InitUserPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2686858217123319820L;
	private long personalID;   //����
	private String myPosition;//ְλ
	private int salary;     //нˮ
	private String personalName;    //����
	public InitUserPO(long personalID, String myPosition, int salary, String personalName) {
		super();
		this.personalID = personalID;
		this.myPosition = myPosition;
		this.salary = salary;
		this.personalName = personalName;
	}
	public long getPersonalID() {
		return personalID;
	}
	public String getMyPosition() {
		return myPosition;
	}
	public int getSalary() {
		return salary;
	}
	public String getPersonalName() {
		return personalName;
	}
	
}
