package po;

import java.util.ArrayList;


public class InstitutionPO {
	private String InstitutionName;
	private long InstitutionID;
	private ArrayList<StaffPO> staff;
	private String function;
	
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
	
	public void updateStaff(ArrayList<StaffPO> staff){
		this.staff = staff;
	}
	
	public ArrayList<StaffPO> getStaff(){
		return staff;
	}
	
	public void setFunction(String function){
		this.function = function;
	}
	
	public String getFunction(){
		return function;
	}
}
