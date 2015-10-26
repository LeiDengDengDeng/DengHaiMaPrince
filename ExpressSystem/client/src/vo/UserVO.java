package src.vo;

import java.util.ArrayList;

public class UserVO {
	private long personalID;   //工号
	private long personalAccount;   //账号
	private String myPassword;//密码
	private String personalName;    //姓名
	private String myPosition;//职位
	private ArrayList<Integer> authority;  //权限
	private int salary;     //薪水
	
	public UserVO(long personalID,long personalAccount,String myPassword
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

