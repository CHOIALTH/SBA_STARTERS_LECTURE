package chap7;
//java 자동 포함 - 생성자, 상속
//java.lang.Object 클래스 라이브러리 있다
//java.lang.Object 클래스 변수나 메서드 java 모든 클래스 자동포함 사용가능
class Employee{ //사원
	int id;
	String name;
	String dept;
	String title = "사원";
	double salary;
	void calcSalary(int salary) {
		this.salary = salary * 2;
	}
/*DEFAULT 상태*/	void printAll () {
		System.out.printf("사번 =%d 이름=%s 부서=%s 급여=%.2f\n",id,name,dept,salary);
	}
	
	
}

class Manager extends Employee{ //관리직 사원
	Manager(int id, String name,String dept, String job){
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.job = job;
	}
	
	String title = "관리직";
	void test() { //상속X, 오버라이딩X, 현재 추가 메서드
		String title = "test 메서드 내부";
		System.out.println(title); // 지역변수
		System.out.println(this.title); //Manager
		System.out.println(super.title); //상속받은..
	}
	String job; //어떤 직종의 관리직인지.. 
	//calcSalary, printAll 메서드 Employee 정의한대로 상속받아 사용
	// 메소드 내용 수정 필요 - 상속받은 곳에서 수정한다.
	//상속 후에 하위클래스에서 메서드 내용 재정의 - 메서드 overriding
	//@Override : '@'(at(앳) 싸인) 자바컴파일러 알려주는 주석문
	void printAll (int id) {
		super.printAll();
		System.out.printf("관리직종=%s\n",job);
	}
}

/*
 * class A{ int i = 10;
 * 
 * } class B{ int j = 20;
 * 
 * } class C extends A, B{ //2개 이상 클래스 동시 상속 가능하다 가정했을때 k변수 외에 i,j변수도 있는것. 하지만
 * 애매모호한 상황발생을 막고자, 자바는 2개 이상 상속 금지시킴 int k = 30;
 * 
 * }
 */


public class ManagerTest { //extends java.lang.Object

	public static void main(String[] args) {
		Manager m = new Manager(100, "김광현", "영업부", "영업관리");
		m.id = 100; //상속
		m.name = "김광현"; //상속
		m.dept = "영업부"; //상속
		m.job = "영업관리"; //자식
		m.calcSalary(50000); //상속
		m.printAll(); //상속
		m.test();
		
		//System.out.printf("사번 =%d 이름=%s 부서=%s 관리직정=%s\n",m.id, m.name, m.dept, m.job);
	}

}
