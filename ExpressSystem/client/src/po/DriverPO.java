package src.po;

import java.io.Serializable;

import src.enums.Sex;

public class DriverPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5894748451667870139L;

	String number; // 司机编号
	String name; // 司机姓名
	int year; // 出生年份
	int month; // 出生月份
	int day; // 出生日
	String ID; // 身份证号
	String mobNum;// 手机号码
	Sex sex; // 性别
	int yearOfExpiring; // 行驶证到期年份
	
	public DriverPO(String number, String name, int year, int month, int day,
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public int getYearOfExpiring() {
		return yearOfExpiring;
	}

	public void setYearOfExpiring(int yearOfExpiring) {
		this.yearOfExpiring = yearOfExpiring;
	}

}
