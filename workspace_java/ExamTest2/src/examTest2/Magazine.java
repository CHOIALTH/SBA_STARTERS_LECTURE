package examTest2;

public class Magazine extends Book {
	private int month;
	public Magazine(String bookNo, String bookTitle, String bookAuthor, int bookYear, int bookPrice,
			String bookPublisher, int month ) {
		super(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return super.toString() + " , " + month;
	}
	

}
