package chap7;

class A{
	//extends Object
	int i;
	A(){
		//super();
		i=10;
		System.out.println("A생성자 호출");
	}
	
}

class B extends A{
	int j;
	B(){
		//super();
		j = 20;
		System.out.println("B생성자 호출");
	}
}

public class SuperTest {

	public static void main(String[] args) {
		B b1 = new B();	
		System.out.println(b1.i);
		System.out.println(b1.j);
	}

}
