package src.po;

import java.io.Serializable;
import java.util.ArrayList;

public class UserPO implements Serializable{
	
	private long personalID;   //���ţ�6λ
	private long personalAccount;   //�˺ţ�6λ
	private String myPassword;//����
	private String personalName;    //����
	private String myPosition;//ְλ
	private ArrayList<Integer> authority;  //Ȩ��
	private int salary;     //нˮ
//	public boolean isFromUser = false;
	
	public UserPO(long personalID,long personalAccount,String myPassword
			,String personalName,String myPosition,ArrayList<Integer> authority){
		this.personalID = personalID;
		this.personalAccount = personalAccount;
		this.myPassword = myPassword;
		this.personalName = personalName;
		this.myPosition = myPosition;
		this.salary = 0;
		
	}
	
	public long getPersonalID(){
		return personalID;
	}
	
	public void setPersonalID(long personalID){
		this.personalID = personalID;
	}
	
	public long getPersonalAccount(){
		return personalAccount;
		
	}
	public void setPersonalAccount(long personalAccount){
		this.personalAccount = personalAccount;
	}
	
	
	public String getMyPassword(){
		return myPassword;
	}
	
	public void setMyPassword(String myPassword){
		this.myPassword = myPassword;
	}
	
	public String getPersonalName(){
		return personalName;
	}
		
	public void setPersonalName(String personalName){
		this.personalName = personalName;
	}
	
	public String getMyPosition(){
		return myPosition;
	}
	
	public void setPosition(String myPosition){
		this.myPosition = myPosition;
	}
	
	public ArrayList<Integer> getAuthority(){
		return authority;
	}
	
	public void setAuthority(ArrayList<Integer> authority){
		this.authority = authority;
	}
	
	public int getSalary(){
		return salary;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}
}