package src.po;

import java.io.Serializable;
import java.util.ArrayList;


public class InstitutionPO implements Serializable{
	private String InstitutionName;
	private long InstitutionID;
	private ArrayList<StaffInfoPO> staff;
	private String function;
	
	public InstitutionPO(String InstitutionName,long InstitutionID
			,ArrayList<StaffInfoPO> staff,String function) {
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
	
	public void updateStaff(ArrayList<StaffInfoPO> staff){
		this.staff = staff;
	}
	
	public ArrayList<StaffInfoPO> getStaff(){
		return staff;
	}
	
	public void setFunction(String function){
		this.function = function;
	}
	
	public String getFunction(){
		return function;
	}
}
