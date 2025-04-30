package com.self.util;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate() { }

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
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

	public String toString() {
		return year+"-"+month+"-"+day;
	}	
}
