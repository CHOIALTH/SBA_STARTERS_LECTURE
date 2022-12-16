package chap9;

import java.util.Random;

public class RandomClassTest {

	public static void main(String[] args) {
		/*
		 * int mathran = (int)(Math.random() * 100) + 1; // 난수의 범위 : 1 ~ 100 Random ran
		 * = new Random(); // 난수의 범위 : 아직 정해지지 X
		 * System.out.println("Math.Random() 정수 = " + mathran);
		 * System.out.println("Random 정수 = " + ran.nextInt(100));
		 * System.out.println("Random 실수 = " + ran.nextDouble(100.0));
		 */
		Random ran = new Random();	
		for(int i = 1; i <= 5; i++) {
			System.out.println("Random 정수 = " + ran.nextInt(100));
		}
		System.out.println("=======================================");
		Random ran2 = new Random(2);	
		// (2) <- 시드값! 시드값을 주면, random 써도 고정된 값이 출력됨.
		for(int i = 1; i <= 5; i++) {
			System.out.println("Random 정수 = " + ran2.nextInt(100));
		}
		// 늘 똑같은 숫자가 출력됨
		/*
		 * Random 정수 = 8 Random 정수 = 72 Random 정수 = 40 Random 정수 = 67 Random 정수 = 89
		 */
		
	}
}
