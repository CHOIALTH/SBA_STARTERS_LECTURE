package chap2;

public class VariableTest {

	public static void main(String[] args) {
		// 0~100 사이의 점수를 표현하겠다
//		byte score = 100; 
//		//128까지 저장 가능.. 범위를 넘어섰다
//		System.out.println(score);
//		score = score + 100; 
//		//출력안됨
		int score = 99; 
		//128까지 저장 가능.. 범위를 넘어섰다
		System.out.println(score);
//		score = score + 100; //출력안됨
		System.out.println(score);
		int score2 = 95 , score3 = 60;
		//정수 산술연산자 정수 ==> 정수
		//실수 산술연산자 정수 ==> 실수 
		//실수 산술연산자 실수 ==> 실수
		
		
		
		//평균 - java 언어에서 정수 타입 데이터간 연산 시, 결과는 정수 타입!
		int avg = (score + score2 + score3) / 3;
		System.out.println("avg = " + avg);
		double avgDouble = (score + score2 + score3) / 3.0;
		System.out.println("avgDouble = " + avgDouble);
		System.out.println(Math.round(avgDouble));
		
		System.out.printf("%d를 표현합니다.", 10);
		System.out.printf("%d를 표현합니다. \n", 10); //정수
		System.out.printf("%f를 표현합니다", 10.99); 
		System.out.printf("%f를 표현합니다. \n", 10.99); //부동소수점
		System.out.printf("%s를 표현합니다", "홍길동");
		System.out.printf("%s를 표현합니다. \n", "홍길동"); //문자열
		System.out.printf("%c를 표현합니다.", '웅');
		System.out.printf("%c를 표현합니다. \n", '웅'); //문자
		
		String loc = "새싹 용산캠퍼스";
		String title = "클라우드 기반 웹서버 과정";
		int week = 3;
		System.out.printf("우리는 새싹 용산캠퍼스에서 클라우드기반 웹서버 과정을 수강합니다.\n 현재 3주째 시작합니다.\n");
		//System.out.printf는 전체가 하나의 String
		System.out.printf("우리는 %s에서 %s을 수강합니다.\n 현재 %d주째 시작합니다.\n", loc , title, week);
		//앞에서 지시자(%) 사용한만큼 변수의 값을 입력해야한다
		byte b = 127;
		//b = 127 + 1; //이렇게 쓰면 컴파일 오류 발생
		//JS의 parseInt(9.9999)--> 9 (소숫점 걍 다 버리고 정수부분만 들고옴)-- 실수 > 정수로의 형변환 도와줌
		int ii = b + 1;
		//byte + int  ==> int
				
	}
	

}
