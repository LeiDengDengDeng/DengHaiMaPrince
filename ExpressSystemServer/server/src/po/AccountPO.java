package src.po;

import java.io.Serializable;

public class AccountPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1081165244939370285L;
	String name;//�����˻�����
	long ID;//�����˺�
	double amount;//�˻����
	
	public AccountPO(String name,long ID,double amount){
		this.name=name;
		this.ID=ID;
		this.amount=amount;
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
