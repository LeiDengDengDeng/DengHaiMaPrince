package src.po;

import java.io.Serializable;

public class InitUserPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2686858217123319820L;
	private long personalID;   //工号
	private String myPosition;//职位
	private int salary;     //薪水
	private String personalName;    //姓名
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
