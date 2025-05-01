package com.self.test;

import java.util.HashMap;
import java.util.Map;

import com.self.service.impl.BookManagerImpl;
import com.self.util.MyDate;
import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;
   
public class BookManagerTest {

	public static void main(String[] args) {
		BookManagerImpl manager = BookManagerImpl.getInstance();
		
		// 부모 틀에 자식 객체 생성
		Map<Integer, Book> allBooks = new HashMap<>();
        allBooks.put(123, new Magazine(123, "코스모폴리탄", "장원영", "허스트중앙", 30000, new MyDate(2025, 4, 13), 3, 1.7));
        allBooks.put(345, new Magazine(345, "인재경영", "젠슨 황표", "인싸이트코리아", 80000, new MyDate(2023, 3, 13), 5, 1.4));
        allBooks.put(678, new Magazine(678, "인재경영2", "젠슨스", "인싸이트코리아", 75000, new MyDate(2021, 7, 13), 5, 1.2));
        allBooks.put(456, new Novel(456, "소년이 온다", "한강", "창비", 13500, new MyDate(2015, 6, 13), "산문", 216));
        allBooks.put(555, new Novel(555, "소년이 온다", "한강", "창비", 14000, new MyDate(2022, 8, 13), "산문", 216));
        allBooks.put(567, new Novel(567, "쇼펜하우어 인생수업", "쇼펜하우어", "HIGHEST", 15750, new MyDate(2023, 7, 13), "철학", 320));

		
		// insert
		for(Book b : allBooks.values()) {
			manager.insertBook(b);
		}
		
		// delete
		manager.deleteBook(678);
		
		// update
		Book updateMagazineEx = new Magazine(345, "인재경영", "젠슨 황표씨", "인싸이트코리아", 85000,new MyDate(2023, 3, 13), 7, 1.5);
		manager.updateBook(updateMagazineEx);
		
		// getBook
		System.out.println("\n======= 책 구하기 =======");
		System.out.println("456번 책: " + manager.getBook(456));		
		
		// getNumberOfBooks
		System.out.println("\n======= 책 개수 구하기 =======");
		System.out.println("책 개수: " + manager.getNumberOfBooks() + "권");
		
	     // searchBookByTitle
        System.out.println("\n======= 제목으로 검색 =======");
        Map<Integer, Book> sameTitleBooks = manager.searchBookByTitle("소년이 온다");
        for (Book b : sameTitleBooks.values()) {
            System.out.println("같은 제목 책: " + b);
        }
		
        // searchBookByPrice
        System.out.println("\n======= 지정한 가격대 내 책 구하기 =======");
        Map<Integer, Book> priceBooks = manager.searchBookByPrice(1000, 40000);
        for (Book b : priceBooks.values()) {
            System.out.println("가격대 내 책: " + b);
        }
        
		// getSumPriceOfBooks
        System.out.println("\n======= 모든 책의 가격 합 구하기 =======");
        System.out.println("모든 책의 가격 합: " + manager.getSumPriceOfBooks() + "원");

		
		// getAvgPriceOfBooks
        System.out.println("\n======= 모든 책의 평균 가격 구하기 =======");
        System.out.println("모든 책의 평균: " + manager.getAvgPriceOfBooks() + "원");
		
		// 추가 기능 1: 예상 완독 시간
        System.out.println("\n======= 예상 완독 시간 구하기 =======");
        for (Book b : allBooks.values()) {
            if (b instanceof Magazine) {
                Magazine m = (Magazine) b;
                double frequency = m.getRead() * m.getContentDensity();
                double estimatedTime = frequency * 10;
                System.out.printf("ISBN %d번 잡지 예상 완독 시간: %.2f분%n", m.getIsbn(), estimatedTime);
            }
        }
		
		// 현재 배열 출력
        System.out.println("\n\n============ 전체 배열 출력 ============");
        for (Book b : manager.getAllBook().values()) {
            System.out.println(b);
        }
		
		// 제목 기준 오름차순 정렬 출력
        System.out.println("\n======= 제목 기준 정렬된 책 목록 =======");
        for (Book b : manager.getBooksSortedByTitle().values()) {
            System.out.println(b);
        }
		
        System.out.println("\n======== magazineOfThisYearInfo() ========");
        for (Book b : manager.magazineOfThisYearInfo(2023).values()) {
            System.out.println(b);
        }
	}

}
