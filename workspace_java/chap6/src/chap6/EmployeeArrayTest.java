package chap6;
//기본적으로 자바에선 우리가 만든 클래스명 = 자바 파일명
//여러개의 클래스가 하나의 파일에 있을 경우, public 키워드 1개 클레스에만 선언해야한다.
//따라서 이 경우 public 클래스 명 = 파일명 이어야 함.
//회사원 변수 + 메소드

class Employee{
	int id;
	String name;
	String title; //직급
	String dept; //부서
	double salary;
}//class

public class EmployeeArrayTest {
//변수들
//메소드

//자바 어플리케이션 클래스(특정기능부여) - "대장" -main
	public static void main(String[] args) {
		//배열 - Employee 객체만 10개
		Employee arr[] = new Employee[10];
		Employee e1 = new Employee();
		//Employee 클래스 찾아서 복사본을 만든것.
		e1.id = 100; //형식 : 객체주소참조변수명.객체내부속성표현변수명(통칭 객체변수명) = 값;
		e1.name = "이명호";
		e1.title = "사원";
		e1.dept = "IT 개발부";
		e1.salary = 10000;
		System.out.printf("사번(%d) %s %s은(는) %s 소속으로 급여는 %.0f원입니다.", e1.id, e1.name, e1.title, e1.dept, e1.salary);
	
		Employee e2 = new Employee();
		e2.id = 200; //형식 : 객체주소참조변수명.객체내부속성표현변수명(통칭 객체변수명) = 값;
		e2.name = "박주호";
		e2.title = "대리";
		e2.dept = "인재 개발부";
		e2.salary = 18000;
		System.out.printf("사번(%d) %s %s은(는) %s 소속으로 급여는 %.0f원입니다.", e2.id, e2.name, e2.title, e2.dept, e2.salary);
	}

}
