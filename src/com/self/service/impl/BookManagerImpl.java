package com.self.service.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 승환님 테스트

import com.self.service.BookManager;

import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerImpl implements BookManager {
	private Map<Integer, Book> books = new HashMap<>();
	public static final int MAX_SIZE = 100;

	private static BookManagerImpl service = new BookManagerImpl();

	private BookManagerImpl() {
		books = new HashMap<>();
	}

	public static BookManagerImpl getInstance() {
		return service;
	}

	@Override
	public void insertBook(Book book) {
		books.put(book.getIsbn(), book);
		System.out.println(book.getTitle() + "등록되었습니다.");
	}

	@Override
	public void deleteBook(int isbn) {
		Book removed = books.remove(isbn);
		if (removed != null) {
			System.out.println(removed.getTitle() + " 삭제되었습니다.");
		}
	}

	@Override
	public void updateBook(Book book) {
		if (books.containsKey(book.getIsbn())) {
			books.put(book.getIsbn(), book);
			System.out.println(book.getTitle() + " 업데이트되었습니다.");
		} else {
			System.out.println("업데이트할 책을 찾을 수 없습니다.");
		}
	}

	@Override
	public Book getBook(int isbn) {
		Book book = books.get(isbn);
		if (book == null) {
			System.out.println("찾으시는 번호의 책이 없습니다.");
		}
		return book;
	}

	@Override
	public Map<Integer, Book> getAllBook() {
	    return new HashMap<>(books); 
	}

	@Override
	public int getNumberOfBooks() {
	    return books.size();
	}

	@Override
	public Map<Integer, Book> searchBookByTitle(String title) {
	    Map<Integer, Book> result = new HashMap<>();
	    for (Map.Entry<Integer, Book> entry : books.entrySet()) {
	        if (entry.getValue().getTitle().equals(title)) {
	            result.put(entry.getKey(), entry.getValue());
	        }
	    }
	    if (result.isEmpty()) {
	        System.out.println("찾으시는 제목의 책이 없습니다.");
	    }
	    return result;
	}

	@Override
	public Map<Integer, Book> searchBookByPrice(int min, int max) {
	    Map<Integer, Book> result = new HashMap<>();
	    for (Map.Entry<Integer, Book> entry : books.entrySet()) {
	        double price = entry.getValue().getPrice();
	        if (price > min && price < max) {
	            result.put(entry.getKey(), entry.getValue());
	        }
	    }
	    if (result.isEmpty()) {
	        System.out.println("찾으시는 가격대의 책이 없습니다.");
	    }
	    return result;
	}

	@Override
	public double getSumPriceOfBooks() {
	    double sumPrice = 0;
	    for (Book b : books.values()) {
	        sumPrice += b.getPrice();
	    }
	    return sumPrice;
	}

	@Override
	public double getAvgPriceOfBooks() {
	    if (books.isEmpty()) return 0;
	    return getSumPriceOfBooks() / books.size();
	}

	public void estimatedReadTime(int isbn) {
	    Book b = books.get(isbn);
	    if (b != null) {
	        if (b instanceof Novel) {
	            double multiGenre;
	            switch (((Novel) b).getGenre()) {
	                case "로맨스": multiGenre = 0.03; break;
	                case "판타지": multiGenre = 0.04; break;
	                default: multiGenre = 0.05;
	            }
	            double time = ((Novel) b).getPage() * multiGenre;
	            int hours = (int) time;
	            int minutes = (int) ((time - hours) * 60);
	            System.out.println("Novel: " + hours + "시간 " + minutes + "분");
	        } else if (b instanceof Magazine) {
	            double time = ((Magazine) b).getRead() * ((Magazine) b).getContentDensity();
	            int minutes = (int) time;
	            int seconds = (int) ((time - minutes) * 60);
	            System.out.println("Magazine: " + minutes + "분 " + seconds + "초");
	        }
	    }
	}
	
	public Map<Integer, Book> getBooksSortedByTitle() {
	    return books.entrySet().stream()
	        .sorted(Map.Entry.comparingByValue(Comparator.comparing(Book::getTitle)))
	        .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
	}
	
	public Map<Integer, Book> magazineOfThisYearInfo(int year) {
	    Map<Integer, Book> result = new HashMap<>();
	    for (Map.Entry<Integer, Book> entry : books.entrySet()) {
	        Book b = entry.getValue();
	        if (b instanceof Magazine && b.getMyDate() != null && b.getMyDate().getYear() == year) {
	            result.put(entry.getKey(), b);
	        }
	    }
	    return result;
	}
}
