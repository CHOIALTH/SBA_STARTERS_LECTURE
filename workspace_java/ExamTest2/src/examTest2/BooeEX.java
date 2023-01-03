package examTest2;

import java.util.Arrays;

public class BooeEX {
	public static void main(String[] args) {
		Book a = new Book("B001", "자바프로그래밍", "홍길동", 2021, 30000, "서울출판사");
		Book b = new Book("B002", "데이터베이스", "이몽룡", 20210, 25000, "대한출판사");
		Book c = new Book("B003", "HTML/CSS", "성춘향", 2022, 18000, "민국출판사");
		Book d = new Magazine("M001", "자바 월드", "홍길동", 2021, 3000, "서울출판사", 5);
		Book e = new Magazine("M002", "웹 월드", "이몽룡", 2021, 2500, "서울출판사", 7);
		Book f = new Magazine("M003", "게임 월드", "성춘향", 2022, 1800, "서울출판사", 9);
		Book[] bs = {a,b,c,d,e,f,};
		System.out.println("도서번호     도서명     저자     출판년도     가격     출판사     발행월");
		System.out.println("=========================================================");
		System.out.println(Arrays.toString(bs));
		
		for(Book book : bs) {
			// book은 배열 bs에서 각 원소를 꺼내기위한 임의의 키워드
			// Book : 자료형
			// JS의 of와 같은 역할이다
			// 이상 enhanced-for문
			System.out.println(book);
		}
		for(int i = 0; i < bs.length ; i++) {
			System.out.println(bs[i]);
		}
		
	}
	
}
