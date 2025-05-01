package com.self.service;

import java.util.Map;

import com.self.exception.RecordNotFoundException;
import com.self.vo.Book;

public interface BookManager {
	void insertBook(Book book);
	void deleteBook(int isbn) throws RecordNotFoundException;
	void updateBook(Book book) throws RecordNotFoundException;
	Book getBook(int isbn);
	Map<Integer, Book> getAllBook();
	int getNumberOfBooks();
	Map<Integer, Book> searchBookByTitle(String title);
	Map<Integer, Book> searchBookByPrice(int min, int max);
	double getSumPriceOfBooks();
	double getAvgPriceOfBooks();
	Map<Integer, Book> getBooksSortedByTitle();
	Map<Integer, Book> magazineOfThisYearInfo(int year);
}
