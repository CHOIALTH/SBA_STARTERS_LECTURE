package test;

/*
  교육생 객체 표현 클래스
  1. 변수 6개: 학생명, 과정명, 교육기관, 교육비, 환급비, 부가금
  2. 단, 교육기관 = 새싹.. 모든 교육생 동일하다.
  3. 단, 부과금 = 5,000원 고정! 수정불가능.
  4. 메서드 - calc (매개변수O)
  4-1. 입력한 과정명이 "java"이면 환급금 = 교육비의 20% + 부가금
  4-2. 입력한 과정명이 "jsp"이면 환급금 = 교육비의 15% + 부가금
  4-3. 입력한 과정명이 "spring"이면 환급금 = 교육비의 10% + 부가금
  4-4. 입력한 과정명이 위 세경우 외라면 환급금 = 0
  실행 main 메서드 클래스
*/
class Student{
	String name, course; //학생명, 과정명
	static String institute = "새싹";
	int cost, refund; //교육비, 환급금
	final int surcharge = 5000; //부가금
	void calcReturnFee(){
		if(/*this.*/course.toLowerCase().equals("java")) {
			refund = (int)(cost * 0.2 + surcharge);
		}
		else if (course.toLowerCase().equals("jsp")){
			refund = (int)(cost * 0.15 + surcharge);
		}
		else if (course.toUpperCase().equals("SPRING")){
			refund = (int)(cost * 0.1 + surcharge);
		}
		else {
			System.out.println("해당하는 과정명이 없습니다.");
			//refund = 0;
		}
		System.out.printf(" 이름 : %s\n 과정명 : %s\n 교육기관 : 새싹\n 교육비 : %d\n 부가금 : %d\n 환급비 : %d\n",name, course,cost,surcharge,refund);
	}
}

public class Test1 {

	public static void main(String[] args) {
		//교육생 a1 = new 교육생();
		//이름, 과정명, 교육비 실행시 명령행 매개변수 입력받도록 하라.
		//교육생 환급비 계산 메서드 호출
		//환급 결과 리턴 출력
		/*
		이름 :xxx
		교육기관 : 새싹
		과정명 : xxx
		교육비 : xxx
		부가금 : 5000
		환급비 : xxx
		*/
		Student a1 = new Student();
		a1.name = args[0];
		a1.course = args[1];
		a1.cost = Integer.parseInt(args[2]);
		a1.calcReturnFee();
		//System.out.println("환급금" + a1.refund);
		
		
//		if(a1.course == "java") {
//			a1.refund = 0.2 * a1.cost
//			a1.refund =0.2 * a1.cost + a1.surcharge;
//		}
//		else if (a1.course == "jsp") {
//			a1.refund =0.15 * a1.cost + a1.surcharge;
//		}
//		else if (a1.course == "spring") {
//			a1.refund = 0.1 * a1.cost + a1.surcharge;
//		}
	}

}
