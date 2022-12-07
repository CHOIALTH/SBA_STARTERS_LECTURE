package test;

public class Test1 {
	public static void main(String[] args) {
		//int su = 123; su 3자리 정수가 들어감 1234
		//100의자리 숫자가 뭔지 찾아내는 출력
		//System.out.println();
		int su = 124;
		int su2;
		if(su < 1000 && su >= 100) {
			su2 = su / 100; 
			System.out.printf("%s의 100의 자리 수는 %s입니다.", su, su2);
		}
		else if(su >= 1000) {
//			su2 = su / (10^(int)(Math.log10(su)));
//			System.out.println((int)(Math.log10(su)));
			su2 =(su / 10^2)%10;
			System.out.printf("%s의 100의 자리 수는 %s입니다.", su, su2);
		}
		else{
			System.out.printf("%s는 100을 넘지 않습니다. 따라서 100의 자리 수를 구할 수 없습니다", su);
		}
	}

}
