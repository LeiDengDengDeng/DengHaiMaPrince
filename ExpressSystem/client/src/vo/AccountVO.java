package src.vo;

public class AccountVO extends BeginVO{

	String name;
	String ID;
	double amount;
	public AccountVO(String name, String iD, double amount) {
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
