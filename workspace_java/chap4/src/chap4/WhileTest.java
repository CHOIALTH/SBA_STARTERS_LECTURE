package chap4;

public class WhileTest {

	public static void main(String[] args) {
		while(true) {
			int test = (int)(Math.random() * 100) + 1;
			if(test == 50) continue; //50은 출력 x 
			if(test % 3 == 0) break; //3의배수이면 종료!
			System.out.println(test);
			
		}
		
//		while(true) {
//			int test = (int)(Math.random() * 100) + 1;
//			System.out.println(test);
//			if(test == 50) {
//				System.out.println("===중단합니다===");
//				break;
//			}//반복종료조건식. if블록 1문장만 포함시 {} 생략가능
			// 이는 for, while, do-while도 블록 내부 1문장만 포함시 {} 생략가능하다
			// continue 조건..
//		}
		
//		for(int i = 1; i <= 10; i++) {
//			int test = (int)(Math.random() * 100) + 1;
//			System.out.println(test);			
//		}
//		int test = (int)(Math.random() * 100) + 1;
//		System.out.println(test);	
////		int i = 1;
//		//test변수가 50이면 중단. 50이 아니면 무한반복
//		while(test != 50) {
//			test = (int)(Math.random() * 100) + 1;
//			System.out.println(test);
			
//			i++; // 안붙이면 무한루프 돌아버림..
		}//단순히 i <= 10 으로 조건을 주면 안되고, 먼저 int를 변수로 선언해줘야
	}


