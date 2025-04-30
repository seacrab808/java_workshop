package com.self.vo;

import com.self.util.MyDate;

public abstract class Book {
	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private double price;
	private MyDate myDate;
	
	public Book() {
		super();
	};
	
	public Book(int isbn, String title, String author, String publisher, double price, MyDate myDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public MyDate getMyDate() {
		return myDate;
	}

	public void setMyDate(MyDate myDate) {
		this.myDate = myDate;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + "]";
	}
	
	
	
}	
