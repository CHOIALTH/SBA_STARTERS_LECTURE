package chap6;
class A{
	int i; //클래스 내부 변수 = member variable
	public void test() {
		int j = 20; // 메서드의 지역변수 local variable
		System.out.println(j);
	}
	public void test2() {
		//i라는 클래스 내부 변수 사용 가능
		//타 메서드의 지역변수 사용 불가능
	}
}
public class MemberLocalTest {
	public static void main(String[] args) {
		A a1 = new A();
		a1.i = 10;
		System.out.println(a1.i);
		a1.test();
		//a1.j = 200; 
		// 모든 변수는 선언된 위치에 따라 쓰임새가 달라짐. j변수의 사용범위는 test메서드 안.
	}

}
