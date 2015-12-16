package src.vo;

import src.enums.Sex;

public class DriverInfoVO {
	private long number; // 司机编号
	private String name; // 司机姓名
	private int year; // 出生年份
	private int month; // 出生月份
	private int day; // 出生日
	private String ID; // 身份证号
	private String mobNum;// 手机号码
	private Sex sex; // 性别
	private int yearOfExpiring; // 行驶证到期年份
	
	public DriverInfoVO(long number, String name, int year, int month, int day,
			String iD, String mobNum, Sex sex, int yearOfExpiring) {
		super();
		this.number = number;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		ID = iD;
		this.mobNum = mobNum;
		this.sex = sex;
		this.yearOfExpiring = yearOfExpiring;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public int getYearOfExpiring() {
		return yearOfExpiring;
	}

	public void setYearOfExpiring(int yearOfExpiring) {
		this.yearOfExpiring = yearOfExpiring;
	}

	public long getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public String getID() {
		return ID;
	}

	public Sex getSex() {
		return sex;
	}
	
}
