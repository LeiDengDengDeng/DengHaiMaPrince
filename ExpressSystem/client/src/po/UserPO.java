package src.po;

import java.io.Serializable;
import java.util.ArrayList;

public class UserPO implements Serializable{
	
	private long personalID;   //����
	private long personalAccount;   //�˺�
	private String myPassword;//����
	private String personalName;    //����
	private String myPosition;//ְλ
	private ArrayList<Integer> authority;  //Ȩ��
	private int salary;     //нˮ
	
	public UserPO(long personalID,long personalAccount,String myPassword
			,String personalName,String myPosition,ArrayList<Integer> authority,int salary){
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
	
	public ArrayList<Integer> getAuthority(){
		return authority;
		
	}
	
	public int getSalary(){
		return salary;
		
	}
}
