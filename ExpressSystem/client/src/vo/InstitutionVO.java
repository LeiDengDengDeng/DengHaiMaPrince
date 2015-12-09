package src.vo;

import java.util.ArrayList;

import src.po.UserPO;

public class InstitutionVO {
	private String InstitutionName;
	private long InstitutionID;
	private ArrayList<UserVO> staff;
	private String function;
	
	public InstitutionVO(String InstitutionName,long InstitutionID
			,ArrayList<UserVO> staff,String function) {
		// TODO Auto-generated constructor stub
		this.InstitutionName = InstitutionName;
		this.InstitutionID = InstitutionID;
		this.staff = staff;
		this.function = function;
		
	}
	
	public void setInstitutionName(String InstitutionName){
		this.InstitutionName = InstitutionName;
		
	}
	
	public String getInstitutionName(){
		return InstitutionName;
	}
	
	public void setInstitutionID(long InstitutionID){
		this.InstitutionID = InstitutionID;
	}
	
	public long getInstitutionID(){
		return InstitutionID;
	}
	
	public void updateStaff(ArrayList<UserVO> staff){
		this.staff = staff;
	}
	
	public ArrayList<UserVO> getStaff(){
		return staff;
	}
	
	public void setFunction(String function){
		this.function = function;
	}
	
	public String getFunction(){
		return function;
	}
}
