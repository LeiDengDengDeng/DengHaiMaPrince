package src.po;

import java.io.Serializable;

public class AccountPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1081165244939370285L;
	String name;//�����˻�����
	String cardID;//�����˺�
	double amount;//�˻����
	
	
	public AccountPO(String name,String cardID,double amount){
		this.name=name;
		this.cardID=cardID;
		this.amount=amount;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardID() {
		return cardID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
