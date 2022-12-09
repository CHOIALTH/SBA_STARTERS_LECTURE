package chap6;

class D{
	int add(int i, int j){
		return i + j; // 정수 + 정수 = 정수
	}
	String add(String i, String j) {
		return i + j; // 문자열결합
	}
	//위 두문장은 형태는 같아 보이지만, 기능은 전혀 다름.
	double add(double i, double j){
		return i + j; // 실수 + 실수 = 실수
	}
	
}


public class OverloadTest {

	public static void main(String[] args) {
		D d1 = new D();
		String result1 = d1.add("spring", "framework");
		double result2 = d1.add(2.5,1.1);
		int result3 = d1.add(1,2);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		d1.add(3.14, 5); //자동 형변환으로 오류 발생 X  int => double
		System.out.println(d1.add(3.14, 5));
		//d1.add(3.14, true); 오류O
		d1.add(3.14,'a');
		System.out.println(d1.add(3.14,'a'));
		
		int dec = Integer.parseInt("100");
		// "100" --> 10진수 정수 변환
		int bin = Integer.parseInt("100",2);
		System.out.println(dec);
		System.out.println(bin);

	}

}
