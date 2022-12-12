package constructor;
//기본적으로 자바에선 우리가 만든 클래스명 = 자바 파일명
//여러개의 클래스가 하나의 파일에 있을 경우, public 키워드 1개 클레스에만 선언해야한다.
//따라서 이 경우 public 클래스 명 = 파일명 이어야 함.
//회사원 변수 + 메소드
//회사원 5개 객체변수 (지역변수X, 클래스변수x, 매개변수x) "클래스" 정의

class Employee {
	//Employee(){ super(); }
	//이상 자바에 자동 포함된 문장
	/*
	 * Employee(int i, String n, String t , String d, double s){ id = i; name = n;
	 * title = t; dept = d; salary = s; }
	 */
	
	  Employee(int id, String name, String title , String dept, double salary){
	  this.id = id; this.name = name; this.title = title; this.dept = dept;
	  this.salary = salary; }
	 
	
	/*
	 * Employee(int id, String name){ this.id = id; this.name = name; title =
	 * "직급미정"; dept = "배치이전"; salary = -1; //같은 이름의 매개변수가 없는경우 this. 안붙여도 됨 }
	 */
	Employee(int id, String name){
		this(id, name, "직급미정" , "배치이전", -1);
/*		this.id = id;
		this.name = name;
		title = "직급미정";
		dept = "배치이전";
		salary = -1;*/ 
		//같은 이름의 매개변수가 없는경우 this. 안붙여도 됨
	}	
	
	
	Employee(){
		id = -1;
		name = "미상";
		title = "직급미정";
		dept = "배치이전";
		salary = -1; //같은 이름의 매개변수가 없는경우 this. 안붙여도 됨
	}	
	
	int id;
	String name;
	String title;
	String dept;
	double salary;
	
	void printInform() {
		int id = 1000;
		System.out.printf("사번 %d 이름 %s 직급 %s 부서명 %s 급여 %.2f 입니다. \n",this.id, this.name, title, dept, salary);
	}
}



public class EmployeeTest {
//변수들
//메소드
	/*
	 * int id; String name; String title; String dept; double salary;
	 */
	/*
	 * void printInform(){
	 * System.out.printf("%s %s(사번 : %d)은(는) %s 소속으로 급여는 %.0f원입니다. \\n", this.name,
	 * this.title, this.id,this.dept, this.salary); }
	 */

//자바 어플리케이션 클래스(특정기능부여) - "대장" -main
	public static void main(String[] args) {
		//배열 - Employee 객체만 저장 2개
		Employee arr[] = new Employee[2];
		Employee e1 = new Employee(100, "이명호", "사원", "IT 개발부", 10000);
		//Employee e1 = new Employee();
		//Employee 클래스 찾아서 복사본을 만든것.
		//e1.id = 100; //형식 : 객체주소참조변수명.객체내부속성표현변수명(통칭 객체변수명) = 값;
		//e1.name = "이명호";
		//e1.title = "사원";
		//e1.dept = "IT 개발부";
		//e1.salary = 10000;
		//arr[0] = e1;
		e1.printInform();
		
		
		
		
		Employee e2 = new Employee(200, "박주호", "대리", "인재 개발부", 18000 );

		
		//Employee e2 = new Employee();
		//e2.id = 200; //형식 : 객체주소참조변수명.객체내부속성표현변수명(통칭 객체변수명) = 값;
		//e2.name = "박주호";
		//e2.title = "대리";
		//e2.dept = "인재 개발부";
		//e2.salary = 18000;
		//arr[1] = e2;
		e2.printInform();

		Employee e3 = new Employee(150, "홍길동");
		e3.printInform();
		
		Employee e4 = new Employee(); //아무 정보 없는 경우
		e4.printInform();
		
		/*
		 * for(int i = 0; i < arr.length; i++) {
		 * System.out.printf("%s %s(사번 : %d)은(는) %s 소속으로 급여는 %.0f원입니다. \n", arr[i].name,
		 * arr[i].title, arr[i].id, arr[i].dept, arr[i].salary); }
		 */

	}

}
