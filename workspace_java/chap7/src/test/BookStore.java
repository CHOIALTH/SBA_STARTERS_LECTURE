package test;

class Book{
	private String title;
	private int price;
	Book(String title, int price){
		this.title = title;
		this.price = price;
	}
	//왜?? line 6~9 코드가 필요한지
	public Book() {
	}
	public void setTitle(String title) {
		this.title = title;
	}
	//(참고)같은 패키지 내 다른 클래스에서 사용할때 굳이 public 안붙여도 된다.
	public String getTitle() {
		return title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
}

class BookMgr{
	Book booklist [] ;
	//String book[];
	BookMgr(Book [] booklist){
		this.booklist = booklist;
	}
	void printBooklist() {
		for(int i = 0; i < booklist.length; i++) {
			Book b = booklist[i];
			System.out.println(b.getTitle());
			//그냥 b.title / b.price 로 작성시 못읽어온다
			//System.out.println(booklist[i].getTitle() + " : " + booklist[i].getPrice()); 라고 작성해도 위와 같음.
		}
	}
	void printTotalPrice() {
		int totalPrice = 0; //지역변수 명시적 초기화
		for(int i = 0; i < booklist.length; i++) {
			totalPrice += booklist[i].getPrice();
			System.out.println("전체 책 가격의 합 :" + totalPrice);
		}
		
	}
	/*
	 * void printBooklist() { System.out.printf("책제목 : %s , 가격 : %d원\n", this.title,
	 * this.price); }
	 */
	
	/*
	 * BookMgr(String title, int price) { this.title = title; this.price = price;
	 * //super.getTitle() = title; //super.getPrice() = thePrice; }
	 */

	//String [] booklist = new int [];
}


public class BookStore {

	public static void main(String[] args) {
		Book booklist[] = new Book[5];

		Book book1 = new Book("Java Program", 25000);
		Book book2 = new Book("JSP Program", 15000);
		Book book3 = new Book("SQL Fundamentals", 30000);
		Book book4 = new Book("JDBC Program", 28000);
		Book book5 = new Book();
		book5.setTitle("EJB Program");
		book5.setPrice(34000);
		booklist[0] = book1;
		booklist[1] = book2;
		booklist[2] = book3;
		booklist[3] = book4;
		booklist[4] = book5;
		
		BookMgr mgr = new BookMgr(booklist);
		System.out.println("=== 책 목록 ===");
		mgr.printBooklist();
		System.out.println("");
		System.out.println("=== 책 가격의 총합 ===");
		mgr.printTotalPrice();
	}

}
