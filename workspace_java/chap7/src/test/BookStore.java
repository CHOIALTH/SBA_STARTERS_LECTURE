package test;

class Book{
	private String title;
	private int price;
	public void setTitle(String title) {
		this.title = title;
	}
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

class BookMgr extends Book {
	String book[];
	void booklist() {
		
	}
	BookMgr(String title, int price) {
		this.title = title;
		this.price = price;
		//super.getTitle() = title;
		//super.getPrice() = thePrice;
	}

	//String [] booklist = new int [];
	void printBooklist() {
		System.out.printf("책제목 : %s , 가격 : %d원\n", this.title, this.price);
	}
	void printTotalPrice() {
		
	}
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
