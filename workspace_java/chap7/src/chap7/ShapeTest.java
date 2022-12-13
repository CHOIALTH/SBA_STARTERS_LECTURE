package chap7;

abstract class Shape{
	abstract void area(); //면적
	abstract void circum(); //둘레
	void print() {// 자식클래스 반드시 오버라이딩? -> 불필요
		System.out.println("면적과 둘레 출력 가능");
	}
	
}

class Rectangle extends Shape{
	int width, height;
	void area() {
		System.out.println("가로 : "+ width + ", 세로 : " + height + "인 사각형의 면적 = " + width*height);
	};
	void circum(){
		System.out.println("가로 : "+ width + ", 세로 : " + height + "인 사각형의 둘레 = " + 2 * (width+height));
	};
	public Rectangle(String width, String height) {
		this.width = Integer.parseInt(width);
		this.height = Integer.parseInt(height);
	}
}
class Circle extends Shape{
	int radius;
	final static double pi = 3.14;
	@Override
	void area() {
		System.out.println("반지름 : " + radius + "인 원의 면적 = " +radius * radius * pi);
	}
	@Override
	void circum() {
		System.out.println("반지름 : " + radius + "인 원의 둘레 = " + 2 * radius * pi);
	}
	public Circle(String radius) {
		this.radius = Integer.parseInt(radius);
	}
	
}

public class ShapeTest {
	public static void main(String[] args) {
		//명령행 매개변수 입력
		//rect 6 8 - 3개 입력받고 첫번째시작ㅁ누자가  "rect"이면 
		//Rectangle 객체 생성
		//면적 - area() 호출 : 2,3번째 가로, 세로 면적 출력 출력
		//둘레 - circum() 호출
		
		// cir 5 - 2개 입력받고 첫번째시작문자가 "cir"이면
		//Circle 객체 생성
		//2번째 반지름, 면적 둘레 출력
		
		//"면적"과 "둘레" 구할 수 있어야 한다. 구현 필수
		Shape s = null;
		System.out.println(args);
		
		if(args.length == 3 && args[0].equals("rect")) { 
			s = new Rectangle(args[1], args[2]); 
		} 
		else if(args.length == 2 && args[0].equals("cir"))
		{ s = new Circle(args[1]); 
		} 
		else { 
			System.out.println("지원하지 않는 도형 형태입니다."); 
		}
		//Shape 타입이면 2개 필수 포함. 서로 다른 내용 실행.
		//조건문 if와 else if 모두 불충족시 s는 그대로 null.
		s.area(); 
		s.circum();
		 
	}
}
