package chap7;

class Parent{
	int su = 10;
	void print() {
		System.out.println("Parent내부의 수" +su);
	}
}

class Child1 extends Parent{
	int su = 20;
	void print(){
		System.out.println("Child1내부의 수" + su);
	}
}

public class CastingTest {
	public static void main(String[] args) {
		Parent p1 = new Parent(); 
		//형변환 발생X
		System.out.println(p1.su);
		p1.print();
		Child1 c1 = new Child1();
		//형변환 발생X
		System.out.println(c1.su);
		c1.print();
		Parent p2 = new Child1();
		//자동형변환 발생O : 부모클래스는 언제든 자식클래스가 될 수 있으므로
		System.out.println("p2의 수" + p2.su);
		p2.print();
		
		
	}
}
