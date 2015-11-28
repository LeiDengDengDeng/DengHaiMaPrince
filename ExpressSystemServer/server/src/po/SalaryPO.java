package src.po;

import java.io.Serializable;

public class SalaryPO implements Serializable{
	private int basic;		//�µ�н
	private int time;		//���μ�
	private int commission; //���
	
	public SalaryPO(int basic){
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
	
	public int getCommission(){
		return commission;
	}
	
	public void setCommission(int commission){
		this.commission = commission;
	}

}