package src.vo;

import java.util.ArrayList;

public class StaffInfoVO {
	private long StaffID;        //����
	private long StaffAccount;   //�˺�
	private String password;//����
	private String StaffName;    //����
	private String position;//ְλ
	private ArrayList<Integer> authority;  //Ȩ��
	private String city;			//����
	private String businessHall;	//Ӫҵ��
	private SalaryVO salary;		//нˮ
	
	public StaffInfoVO(long StaffID,long StaffAccount,String password
			,String StaffName,String position,ArrayList<Integer> authority,
			String city,String businessHall){
		this.StaffID = StaffID;
		this.StaffAccount = StaffAccount;
		this.password = password;
		this.StaffName = StaffName;
		this.position = position;
		this.authority = authority;
		this.city = city;
		this.businessHall = businessHall;
		this.salary = new SalaryVO(0);
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
	
	public SalaryVO getSalary(){
		return salary;
	}
	
}
