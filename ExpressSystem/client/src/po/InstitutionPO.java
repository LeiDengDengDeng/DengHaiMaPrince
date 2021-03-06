package src.po;

import java.io.Serializable;
import java.util.ArrayList;


public class InstitutionPO implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1618445577823868444L;
	
	private String InstitutionName;
	private long InstitutionID;	//6λ
	private ArrayList<UserPO> staff;
	private String function;
	
	public InstitutionPO(String InstitutionName,long InstitutionID
			,String function) {
		// TODO Auto-generated constructor stub
		this.InstitutionName = InstitutionName;
		this.InstitutionID = InstitutionID;
		this.staff = null;
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
	
	public void setStaff(ArrayList<UserPO> staff){
		this.staff = staff;
	}
	
	public ArrayList<UserPO> getStaff(){
		return staff;
	}
	
	public void setFunction(String function){
		this.function = function;
	}
	
	public String getFunction(){
		return function;
	}
}
