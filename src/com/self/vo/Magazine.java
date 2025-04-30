package com.self.vo;

import com.self.util.MyDate;

public class Magazine extends Book {
	private int read;
	private double contentDensity;
	
	private static final int DFT_READ = 10;
	private static final double DFT_CONTENTDENSITY = 1.2;
	
	public Magazine(int isbn, String title, String author, String publisher, double price, MyDate myDate) {
		this(isbn, title, author, publisher, price, myDate, DFT_READ, DFT_CONTENTDENSITY);
	}

	public Magazine(int isbn, String title, String author, String publisher, double price, MyDate myDate, int read,
			double contentDensity) {
		super(isbn, title, author, publisher, price, myDate);
		this.read = read;
		this.contentDensity = contentDensity;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public double getContentDensity() {
		return contentDensity;
	}

	public void setContentDensity(double contentDensity) {
		this.contentDensity = contentDensity;
	}

	@Override
	public String toString() {
		return super.toString() + "Magazine [read=" + read + ", contentDensity=" + contentDensity + "]";
	}
	
	
}
