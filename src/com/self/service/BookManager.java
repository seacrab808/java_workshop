package com.self.service;
 
import java.util.ArrayList;
import java.util.List;
import com.self.vo.Book;

public interface BookManager {
	void insertBook(Book book);
	void deleteBook(int isbn);
	void updateBook(Book book);
	Book getBook(int isbn);
	List<Book> getAllBook();
	int getNumberOfBooks();
	List<Book> searchBookByTitle(String title);
	List<Book> searchBookByPrice(int min, int max);
	double getSumPriceOfBooks();
	double getAvgPriceOfBooks();
	List<Book> getBooksSortedByTitle();
	ArrayList<Book> magazineOfThisYearInfo(int year);
}

// feature#1
// KAN-2
//W1