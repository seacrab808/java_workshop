package com.self.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 승환님 테스트

import com.self.service.BookManager;

import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerImpl implements BookManager {
	private List<Book> books = new ArrayList<>();
	public static final int MAX_SIZE = 100;

	private static BookManagerImpl service = new BookManagerImpl();

	private BookManagerImpl() {
		books = new ArrayList<>();
	}

	public static BookManagerImpl getInstance() {
		return service;
	}

	@Override
	public void insertBook(Book book) {
		books.add(book);
		System.out.println(book.getTitle() + "등록되었습니다.");
	}

	@Override
	public void deleteBook(int isbn) {
		Book bookToDelete = null;
		for (Book book : books) {
			if(book.getIsbn() == isbn) {
				bookToDelete = book;
				break;
			}
		}
		if (bookToDelete != null) {
			books.remove(bookToDelete);
			System.out.println(bookToDelete.getTitle()+"삭제되었습니다.");
			
		}
	}

	@Override
	public void updateBook(Book book) {
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn() == book.getIsbn()) {
				books.set(i, book);
				System.out.println(book.getTitle()+"업데이트되었습니다.");
			return;
			}
		System.out.println("업데이트할 책을 찾을 수 없습니다.");
		}
	}

	@Override
	public Book getBook(int isbn) {
		for (Book bk : books) {
			if (bk.getIsbn() == isbn) {
				return bk;
			}
		}
		System.out.println("찾으시는 번호의 책이 없습니다.");
		return null;
	}

	@Override
	public List<Book> getAllBook() {
		return books;
	}

	@Override
	public int getNumberOfBooks() {
	    int numberOfBook = books.size();
	    return numberOfBook;
	}

	@Override
	public List<Book> searchBookByTitle(String title) {
		List<Book> result = new ArrayList<>();

		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				result.add(b);
			}
		}

		if (result.isEmpty()) {
			System.out.println("찾으시는 제목의 책이 없습니다.");
		}

		return result;
	}

	@Override
	public List<Book> searchBookByPrice(int min, int max) {
		List<Book> result = new ArrayList<>();

		for (Book b : books) {
			if (b.getPrice() > min && b.getPrice() < max) {
				result.add(b);
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
		for (Book b : books) {
			sumPrice += b.getPrice();
		}
		return sumPrice;
	}

	@Override
	public double getAvgPriceOfBooks() {
		if (books.isEmpty())
			return 0;
		return getSumPriceOfBooks() / books.size();
	}

	public void estimatedReadTime(int isbn) {
		for (Book b : books) {
			if (b.getIsbn() == isbn) {
				if (b instanceof Novel) {
					double multiGenre;
					switch (((Novel) b).getGenre()) {
					case "로맨스":
						multiGenre = 0.03;
						break;
					case "판타지":
						multiGenre = 0.04;
						break;
					default:
						multiGenre = 0.05;
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
				break;
			}
		}
	}
	
	public List<Book> getBooksSortedByTitle(){
		List<Book> sortedList = new ArrayList<>(books);
		Collections.sort(sortedList, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getTitle().compareTo(o2.getTitle()); // title 기준 오름차순
			}
		});
		return sortedList;
	}
	
	public ArrayList<Book> magazineOfThisYearInfo(int year) {
		ArrayList<Book> temp= new ArrayList<>();
		   for(Book b : books) {
		        if(b instanceof Magazine) {
		            if(((Magazine) b).getMyDate().getYear()==year) temp.add(b);
		        }
		    }
				
		     return temp;
		}
}
