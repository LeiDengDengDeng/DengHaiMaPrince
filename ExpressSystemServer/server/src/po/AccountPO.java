package src.po;

import java.io.Serializable;

public class AccountPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1081165244939370285L;
	String name;//银行账户名称
	long cardID;//银行账号
	double amount;//账户余额
	
	
	public AccountPO(String name,long cardID,double amount){
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

	public long getCardID() {
		return cardID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
