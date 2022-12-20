package chap14;

import java.util.Arrays;

// 함수형 인터페이스
@FunctionalInterface
// 위와같은 @선언 권고
interface Calculable {
	int sum(int a, int b);
	//int mul(int a, int b);
}

@FunctionalInterface
interface MyFunction{
	public int getValue(int x, int y);
}

public class LambdaTest2 {
	static int test(MyFunction fu, int a, int b) {
		return fu.getValue(a, b);
	}
	public static void main(String[] args) {
		// 이하 test3 제네릭
		GenericInterface<String> gen = (str1,str2)->str1+str2;
		GenericInterface<String> gen2 = (str1,str2)->str1+str2;
		String result = gen.getValue("람다","식");
		int result2 = gen2.getValue(10,20);
		
		// 이하 test2 람다식 매개변수
		MyFunction mf = (x,y)->x>y?x:y;
		int maxValue = test(mf,10,5);
		System.out.println(maxValue);
		
		
		
		
		
		
		Calculable calc = null;
		// 이하 1. 함수형 인터페이스 무명클래스 구현
		calc = new Calculable() {
			
			@Override
			public int sum(int a, int b) {
				return a + b;
			}
		};
		System.out.println(calc.sum(10, 9));
		// 이하 2. 람다식
		calc = (int a, int b) ->{return a + b;};
		System.out.println(calc.sum(10, 9));
		// 이하 람다식 - 매개변수 타입 유추. 생략
		calc = (a,b) ->{return a + b;};
		System.out.println(calc.sum(10, 9));
		// 이하 람다식  {}.return 키워드 생략
		calc = (a,b) -> a + b;
		System.out.println(calc.sum(10, 9));
		
	};	
}

