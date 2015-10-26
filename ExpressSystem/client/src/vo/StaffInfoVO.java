package src.vo;

import java.util.ArrayList;

public class StaffInfoVO {
	private long StaffID;        //工号
	private long StaffAccount;   //账号
	private String password;//密码
	private String StaffName;    //姓名
	private String position;//职位
	private ArrayList<Integer> authority;  //权限
	
	public StaffInfoVO(long StaffID,long StaffAccount,String password
			,String StaffName,String position,ArrayList<Integer> authority){
		this.StaffID = StaffID;
		this.StaffAccount = StaffAccount;
		this.password = password;
		this.StaffName = StaffName;
		this.position = position;
		this.authority = authority;
	}
	
	public void setStaffID(long StaffID){
		this.StaffID = StaffID;
		
	}
	
	public long getID(){
		return StaffID;
		
	}
	
	public void setStaffAccount(long StaffAccount){
		this.StaffAccount = StaffAccount;
		
	}
	
	public long getAccount(){
		return StaffAccount;
		
	}
	
	public void setPassword(String password){
		this.password = password;
		
	}
	
	public String getPassword(){
		return password;
		
	}
	
	public void setStaffName(String StaffName){
		this.StaffName = StaffName;
		
	}
	
	public String getStaffName(){
		return StaffName;
	}
	
	public void setPosition(String position){
		this.position = position;
		
	}
	
	public String getPosition(){
		return position;
		
	}
	
	public void setAuthority(ArrayList<Integer> authority){
		this.authority = authority;
		
	}
	
	public ArrayList<Integer> getAuthority(){
		return authority;
		
	}
		
}
