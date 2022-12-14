package innerclass;

class Outer {
	int i = 10; //멤버변수
	void mo () {
		System.out.println(i);// 외부클래스 메서드는 내부클래스 요소 접근 불가
	}
	class Inner{ //멤버변수 유사 취급
		int j = 20;
		void mi () {
			System.out.println(i - j); //내부클래스 메서드는 외부클래스 요소 접근 가능
		}
	}
}

public class InnerClassTest {

	public static void main(String[] args) {
		//Outer o = new Outer();	
		Outer.Inner inner = new Outer().new Inner();
		System.out.println(new Outer().i);
		System.out.println(inner.j);
		
	}

}
