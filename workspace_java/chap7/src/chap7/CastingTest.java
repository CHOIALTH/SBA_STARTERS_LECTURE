package chap7;

class Parent{
	int su = 10;
	void print() {
		System.out.println("Parent 내부의 수 " +su); // 10.
	}
	void mp() {
		System.out.println("Parent클래스");//non-overriding 메서드. 부모.
	}
}

class Child1 extends Parent{
	int su = 20;
	void print(){
		System.out.println("Child1 내부의 수 " + su);
	}//overriding한 메서드. 20.
	void mc() {
		System.out.println("mc - Child1클래스"); //자식추가
	}
}

class Child2 extends Parent{
	int su = 30;
	void print() {
		System.out.println("Child2 내부의 수 " + (super.su + su));
		//super.su는 Parent에 있는 su = 10!
	}
	void mc2() {
		System.out.println("mc2 - Child2클래스"); //자식추가
	}
}


public class CastingTest {
	public static void main(String[] args) {
		Parent p1 = new Parent(); 
		//형변환 발생X
		System.out.println(p1.su);
		p1.print();
		p1.mp();
		//p1.mc();
		//오류 발생 이유 : 메모리 존재 X
		Child1 c1 = new Child1();
		//형변환 발생X
		System.out.println(c1.su);
		c1.print();
		c1.mp();
		c1.mc();
		
		Parent p2 = new Child1(); //자동형변환 발생
		//자동형변환 발생O : 부모클래스는 언제든 자식클래스가 될 수 있으므로
		System.out.println("p2의 수 " + p2.su); //10
		p2.print();//overriding 메서드 - Child1
		p2.mp(); //사용메서드 - Parent
		//p2.mc(); //메모리 생성
		//오류 발생 이유 : p2메서드 안에 mc 호출할 요소가 존재하지 X
		
		//Child1 c2 = (Child1)p2; //명시적형변환 발생
		//c2.mc();
		//if(변수명 instanceof 클래스명) 
		if(p2 instanceof Child1) {
			//형변환이 가능한지 물어보는 조건문.
			((Child1)p2).mc(); // 위 2문장(line 59-60)을 한문장으로 정리
		}
		else {
			System.out.println("p2 Child1 타입 형변환 불가");
		}
		
		Parent p3 = new Child2(); //자동형변환발생
		System.out.println("p3의수 " + p3.su); //사용변수 - Parent
		p3.print(); //overriding 메서드 - Child2
		//((Child1)p3).mc(); //not 컴파일오류 but 실행오류
		if(p3 instanceof Child2) {
			//형변환이 가능한지 물어보는 조건문.
			((Child2)p3).mc2();
		}
		else {
			System.out.println("p3 Child2 타입 형변환 불가");
		}
		
	}
}
