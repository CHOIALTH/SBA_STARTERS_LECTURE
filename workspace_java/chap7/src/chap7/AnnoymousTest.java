package chap7;

interface I1 {
	void m1();
}
interface I2 {
	void m2();
}

class Ano {
	/*
	 * interface I1 { void m1(); } interface I2 { void m2(); }
	 */
	
	
/*	@Override
	public void m2() {
		System.out.println("m2메서드 호출");
	}

	@Override
	public void m1() {
		System.out.println("m1메서드 호출");

	}*/
	
}

public class AnnoymousTest {

	public static void main(String[] args) {
		//I1 인터페이스 상속 클래스 정의 + 객체 생성 문장
		I1 i1 = new I1() {
			public void m1() {
				System.out.println("m1호출");
			}//M1 메서드
		};//new I1
	i1.m1();
	
	I2 i2 = new I2() {
		public void m2() {
			System.out.println("m2호출");
		}
	};
	i2.m2();
	}
	

}
