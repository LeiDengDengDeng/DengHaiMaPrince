package src.vo;

public class InitUserVO {
	private long personalID;   //工号
	private String myPosition;//职位
	private int salary;     //薪水
	private String personalName;    //姓名
	public InitUserVO(long personalID, String myPosition, int salary, String personalName) {
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
