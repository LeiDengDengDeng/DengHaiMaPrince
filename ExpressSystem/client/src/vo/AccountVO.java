package src.vo;

public class AccountVO {

	String name;
	long ID;
	double amount;
	public AccountVO(String name, long iD, double amount) {
		this.name = name;
		ID = iD;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
