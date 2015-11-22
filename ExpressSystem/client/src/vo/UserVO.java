package src.vo;

import java.util.ArrayList;

import src.po.SalaryPO;

public class UserVO {
	private long personalID;   //����
	private long personalAccount;   //�˺�
	private String myPassword;//����
	private String personalName;    //����
	private String myPosition;//ְλ
	private ArrayList<Integer> authority;  //Ȩ��
	private SalaryPO salary;     //нˮ
	
	public UserVO(long personalID,long personalAccount,String myPassword
			,String personalName,String myPosition,ArrayList<Integer> authority,SalaryPO salary){
		this.personalID = personalID;
		this.personalAccount = personalAccount;
		this.myPassword = myPassword;
		this.personalName = personalName;
		this.myPosition = myPosition;
		this.salary = salary;
		
	}
	
	public long getpersonalID(){
		return personalID;
		
	}
	
	public long getpersonalAccount(){
		return personalAccount;
		
	}
	
	public void setMyPassword(String myPassword){
		this.myPassword = myPassword;
		
	}
	
	public String getMyPassword(){
		return myPassword;
		
	}
	
	public String getpersonalName(){
		return personalName;
	}
		
	public String getMyPosition(){
		return myPosition;
		
	}
	
	public void setMyPosition(String myPosition){
		this.myPosition = myPosition;
	}
	
	public ArrayList<Integer> getAuthority(){
		return authority;
		
	}
	
	public SalaryPO getSalary(){
		return salary;
		
	}
	
	public void setSalary(SalaryPO salary){
		this.salary = salary;
	}
}

