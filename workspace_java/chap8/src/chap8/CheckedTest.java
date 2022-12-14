package chap8;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedTest {

	public static void main(String[] args) {
		//sample.txt 입력용 사용 오픈 허락
		//java.io.FileNotFoundException 발생
		//예외처리 반드시 try-catch
		//checkedexception 종류
		// class FileNotFoundException extends Exception
		try {
			FileReader fr = new FileReader("sample.txt");
			
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println(10 / 0);
		//ArithmeticException발생 -컴파일러 경고안한다 예외-실행
		//ArithmeticException extends RuntimeException
	}
	
}
