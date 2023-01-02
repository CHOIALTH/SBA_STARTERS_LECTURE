package udemyJava;

class Calculator {
	int triangle2(int an1, int an2) {
		int an3 = 180 - (an1 + an2);
		return an3;
	}
}

public class Lec221231 {
	static void hello() {
		// void : 리턴타입을 갖지 않는(리턴하는게 없는) 메서드
		// 메서드 특징
		// 1. 메서드를 불러낸다? = 그 메서드의 코드를 실행한다
		// 2. 메서드 제목은 보통 소문자로 시작(자바가 대문자로 시작하는 것을 허용은 함..)
		// 3. 변수 선언 규칙을 따른다 (키워드와 같은 이름 사용 불가.. camelCase 등등)
		System.out.println("Hello World!");
		System.out.println("Hello World!");
	}
	static void printMultiplicationTable(int x) {
		for(int i = 1; i <= x; i++) {
			System.out.printf("%d * %d = %d \n", 4, i, 4 * i);
		}
	}
	static void printMultiplicationTest(int x) {
		for(int i = 1; i <= x; i++) {
			System.out.printf("%d * %d = %d \n", x, i, x * i);
		}
	}
	
	static void printMultiplicationTest2(int table, int from, int to) {
		for(int i = from; i <= to; i++) {
			System.out.printf("%d * %d = %d", table, i, table * i).println();
		// .println() 붙여서 줄바꿈 효과 줄 수도 있음
		}
	}
	
	static int triangle(int a1, int a2) {
		int a3 = 180 -(a1 + a2);
		return a3;
	}

	public static void main(String[] args) {
		// hello();
		// printMultiplicationTable(10);
		// printMultiplicationTest(11);
		// printMultiplicationTest(12);

		// triangle(90, 45);
		// System.out.println(triangle(90, 45));
		// triangle(30, 30);
		// System.out.println(triangle(30, 30));
		// Calculator cc = new Calculator();
		// System.out.println(cc.triangle2(60, 30)) ;
		// System.out.println(cc.triangle2(90, 45)) ;
		// cc.triangle2(90, 45);
		printMultiplicationTest2(12, 6, 12);
		printMultiplicationTest2(5, 2, 12);
		
	
	}

}
