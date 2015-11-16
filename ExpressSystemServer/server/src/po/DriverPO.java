package src.po;

import java.io.Serializable;

import src.enums.Sex;

public class DriverPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5894748451667870139L;

	long number; // ˾�����
	String name; // ˾������
	int year; // �������
	int month; // �����·�
	int day; // ������
	String ID; // ���֤��
	String mobNum;// �ֻ�����
	Sex sex; // �Ա�
	int yearOfExpiring; // ��ʻ֤�������

	public DriverPO(long number, String name, int year, int month, int day,
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

	public String getMobNum() {
		return mobNum;
	}

	public int getYearOfExpiring() {
		return yearOfExpiring;
	}
	
	public Sex getSex() {
		return sex;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public void setYearOfExpiring(int yearOfExpiring) {
		this.yearOfExpiring = yearOfExpiring;
	}
	
}
