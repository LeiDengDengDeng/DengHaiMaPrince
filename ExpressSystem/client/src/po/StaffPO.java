package src.po;


public class StaffPO {
	private long StaffID;        //����
	private long account;   //�˺�
	private String password;//����
	private String name;    //����
	private String position;//ְλ
//	private ArrayList<Integer> authority;  //Ȩ��
	private int salary;     //нˮ
	
	public void setStaffID(long StaffID){
		this.StaffID = StaffID;
		
	}
	
	public long getID(){
		return StaffID;
		
	}
	
	public void setAccount(long account){
		this.account = account;
		
	}
	
	public long getAccount(){
		return account;
		
	}
	
	public void setPassword(String password){
		this.password = password;
		
	}
	
	public String getPassword(){
		return password;
		
	}
	
	public void setName(String name){
		this.name = name;
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setPosition(String position){
		this.position = position;
		
	}
	
	public String getPosition(){
		return position;
		
	}
	
//	public void setAuthority(int authority){
//		this.authority = authority;
//		
//	}
//	
//	public int getAuthority(){
//		return authority;
//		
//	}
	
	public void setSalary(int salary){
		this.salary = salary;
		
	}
	
	public int getSalary(){
		return salary;
		
	}
	

}
