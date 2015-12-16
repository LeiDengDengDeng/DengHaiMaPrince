package src.vo;

import src.enums.Sex;

public class DriverInfoVO {
	private long number; // ˾�����
	private String name; // ˾������
	private int year; // �������
	private int month; // �����·�
	private int day; // ������
	private String ID; // ���֤��
	private String mobNum;// �ֻ�����
	private Sex sex; // �Ա�
	private int yearOfExpiring; // ��ʻ֤�������
	
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
