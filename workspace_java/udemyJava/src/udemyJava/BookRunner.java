package udemyJava;

class Book{
	void read() {
		System.out.println("책읽는다");
	}
	void noOfCopies(int num){
		System.out.printf("%d권의 카피를 갖고있다\n", num);
	}
}

public class BookRunner {
	public static void main(String[] args) {
		Book artOfComputerProgramming = new Book();
		Book effectiveJava = new Book();
		Book cleanCode = new Book();
		// 인스턴스 명칭은 항상 소문자로 시작 + camelCase
		artOfComputerProgramming.read();
		effectiveJava.read();
		cleanCode.read();
		artOfComputerProgramming.noOfCopies(100);
		effectiveJava.noOfCopies(30);
		cleanCode.noOfCopies(18);
	}
	
	
}
 