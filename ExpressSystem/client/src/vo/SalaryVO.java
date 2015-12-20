package src.vo;

public class SalaryVO {
	private int basic;		//�µ�н
	private int time;		//���μ�
	private int commission; //���(0-100)
	private int eachPay; //ÿ�εļ۸�
	
	public SalaryVO(int basic){
		this.basic = basic;
		this.time = 0;
		this.commission = 0;
	}
	
	public int getBasic(){
		return basic;
	}
	
	public void setBasic(int basic){
		this.basic = basic;
	}
	
	public int getTime(){
		return time;
	}
	
	public void setTime(int time){
		this.time = time;
	}
	
	public void setEachPay(int eachPay){
		this.eachPay = eachPay;
	}
	
	public int getEachPay(){
		return eachPay;
	}
	
	public int getCommission(){
		return commission;
	}
	
	public void setCommission(int commission){
		this.commission = commission;
	}
	
	public int getTotal(){
		return basic * (100 + commission) / 100 + time * eachPay;
	}
}
