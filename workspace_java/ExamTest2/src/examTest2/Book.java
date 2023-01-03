package examTest2;

public class Book {
	private String bookNo, bookTitle, bookAuthor, bookPublisher;
	private int bookYear, bookPrice;
	
	public Book(String bookNo, String bookTitle, String bookAuthor, int bookYear, int bookPrice, String bookPublisher) {
		super();
		this.bookNo =bookNo;
		this.bookTitle =bookTitle;
		this.bookAuthor =bookAuthor;
		this.bookYear =bookYear;
		this.bookPrice =bookPrice;
		this.bookPublisher =bookPublisher;
	}
	
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookYear() {
		return bookYear;
	}
	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	
	public String toString() {
		return bookNo + " , " + bookTitle + " , " + bookAuthor + " , " 
	+  bookYear + " , " + bookPrice+ " , "+ bookPublisher ;
	}
}
