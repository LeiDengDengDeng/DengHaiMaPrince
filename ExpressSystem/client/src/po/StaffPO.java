package src.po;


public class StaffPO {
	private long StaffID;        //工号
	private long account;   //账号
	private String password;//密码
	private String name;    //姓名
	private String position;//职位
//	private ArrayList<Integer> authority;  //权限
	private int salary;     //薪水
	
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
