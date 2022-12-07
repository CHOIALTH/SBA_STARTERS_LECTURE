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
	}

}
