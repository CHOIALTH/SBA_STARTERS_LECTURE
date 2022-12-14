package innerclass2;

class Outer {
	static int i = 10; //멤버변수
	void mo () {
		System.out.println(i + new Inner().j);// 외부클래스 메서드는 내부클래스 요소 접근 불가
	}
	//protected ,private 내부클래스 가능 
	static class Inner{ //멤버변수 유사 취급
		static int j = 20;
		static void mi () {
			System.out.println(i - j); //static 내부클래스 메서드는 외부클래스 static 요소 접근 가능
		}
	}
}

public class InnerClassTest {

	public static void main(String[] args) {
		//Outer o = new Outer();	
		/*
		 * Outer.Inner inner = new Outer().new Inner(); System.out.println(new
		 * Outer().i); System.out.println(inner.j);
		 */
		Outer.Inner.mi();
		
	}

}
