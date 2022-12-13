package salary;

class Employee{
	int id; //사번
	String name; //이름
	int baseSalary; //본봉
	
	int totalSalary; //총급여
}

public class SalaryTest {

	public static void main(String[] args) {
		Employee e [] = new Employee[4];
		// 1.상속 2.생성자(타입 순서 갯수....)
		e[0] = new Employee(1000,"이사원",10000,5000);
		e[1] = new Manager(2000,"김간부",20000,10000,10000);
		e[2] = new Engineer(3000,"박기술",15000,7500,5000,5000);
		e[3] = new Secretary(4000,"최비서",15000,7000,10000);
		System.out.println("사번 : 이름 : 본봉 : 총급여");
		for(int i = 0; i < e.length; i++) {
			e[i].calcSalary(); // 4개 객체 overriding
			System.out.println(e[i].id + ":" + e[i].name + ":" + e[i].baseSalary + ":" + e[i].totalSalary);
			if(e[i] instanceof Engineer) {
				System.out.println("기술직 사원의 경우 : " + ((Engineer)e[i]).techFee + " , " + ((Engineer)e[i]).certiFee);
			}
		}
		/* 배열 내의 각 객체의
		 급여계산메소드 호출하고
		사번, 이름, 총급여 출력
		 단, 기술직 사원은 기술수당, 자격수당도 출력
		사번:이름:본봉:총급여
		1000:이사원:10000:xxxxx
		2000:김간부:20000:xxxxx
		3000:박기술:15000:xxxxx
		기술직사원의 경우 : 기술수당 자격수당
		4000:최비서:15000:xxxxx
		 */
	}

}
