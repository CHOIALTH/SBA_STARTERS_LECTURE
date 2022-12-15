package chap8;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Test{
	/*
	 * void m1(int i) { System.out.println(10 / i); // ArithmeticException - 반드시
	 * 처리구문 존재해야 하는것은 아니다 // 컴파일러에선 체크해주지 X }
	 */
	void m1(int i) throws ArithmeticException, FileNotFoundException {
		System.out.println(10 / i);
		FileReader fr = new FileReader("none.txt");
		// ArithmeticException - 반드시 처리구문 존재해야 하는것은 아니다
		// 컴파일러에선 체크해주지 X
	}
	void m2(){
		try {
			m1(0);
		} catch (ArithmeticException e) {
			try {
				m1(2);
			} catch (FileNotFoundException e2) {
				System.out.println("파일명 혹은 경로명을 확인하세요.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일명 혹은 경로명을 확인하세요.");
		}
	}
	void m3() throws FileNotFoundException{
		m1(2);
	}
}

public class ThrowsTest {
	// main 호출한 자바 시스템으로 전달 - 자바 시스템 기본 예외처리기 동작 - 예외메시지 출력
	public static void main(String[] args) throws FileNotFoundException {
		Test t = new Test();
		t.m2();
		t.m3();
	}

}
