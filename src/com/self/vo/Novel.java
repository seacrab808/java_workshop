package com.self.vo;

import com.self.util.MyDate;

public class Novel extends Book {
	private String genre;
	private int page;
	
	private static final String DFT_GENRE = "로맨스";
	private static final int DFT_PAGE = 10;
	
	public Novel(int isbn, String title, String author, String publisher, double price, MyDate myDate) {
		this(isbn, title, author, publisher, price, myDate, DFT_GENRE, DFT_PAGE);
	}

	public Novel(int isbn, String title, String author, String publisher, double price, MyDate myDate, String genre, int page) {
		super(isbn, title, author, publisher, price, myDate);
		this.genre = genre;
		this.page = page;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return super.toString() + "Novel [genre=" + genre + ", page=" + page + "]";
	}
	
}
