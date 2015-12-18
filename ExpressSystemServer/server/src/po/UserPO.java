package src.po;

import java.io.Serializable;
import java.util.ArrayList;

public class UserPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7067844558930052226L;
	
	private long personalID;   //工号，6位
	private long personalAccount;   //账号，6位
	private String myPassword;//密码
	private String personalName;    //姓名
	private String myPosition;//职位
	private ArrayList<Integer> authority;  //权限
	private SalaryPO salary;     //薪水
	private String city;			//城市
	private String businessHall;	//营业厅
	
	
	
	public UserPO(long personalID,long personalAccount,String myPassword
			,String personalName,String myPosition,ArrayList<Integer> authority){
		this.personalID = personalID;
		this.personalAccount = personalAccount;
		this.myPassword = myPassword;
		this.personalName = personalName;
		this.myPosition = myPosition;
		this.salary = new SalaryPO(0);
		this.city = null;
		this.businessHall = null;
		
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
	
	public SalaryPO getSalary(){
		return salary;
	}
	
	public void setSalary(SalaryPO salary){
		this.salary = salary;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getBusinessHall(){
		return businessHall;
	}
	
	public void setBusinessHall(String businessHall){
		this.businessHall = businessHall;
		
	}
}
