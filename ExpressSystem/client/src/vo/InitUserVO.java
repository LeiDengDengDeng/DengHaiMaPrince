package src.vo;

public class InitUserVO {
	private long personalID;   //����
	private String myPosition;//ְλ
	private int salary;     //нˮ
	private String personalName;    //����
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
