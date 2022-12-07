package chap4;

public class ScoreTest {

	public static void main(String[] args) {
		String name = "홍길동";
		int kor = 100 , eng = 50 , mat = 75;
		int sum; //총점
		sum = kor + eng + mat;
		double avg; //실수평균
		avg = sum / 3.0;
		System.out.println(avg);
		int avgInt; //정수평균
		avgInt = sum / 3;
		System.out.println(avgInt);
		String grade; //
		//강사님은 해설시 String grade = "" 로 하심.
		//avgInt가 90이상 100이하인 조건을 만족하면.. grade "A등급"
		//avgInt가 80이상 90미만인 조건을 만족하면.. grade "B등급"
		//avgInt가 70이상 80미만인 조건을 만족하면.. grade "C등급"
		//avgInt가 60이상 70미만인 조건을 만족하면.. grade "D등급"
		//avgInt가 그외인 조건을 만족하면.. grade "낙제등급"
		if(avgInt >= 90 && avgInt <= 100) {
			grade = "A";
			//System.out.println("등급은 A입니다");
		}
		else if(avgInt >= 80) {
			grade = "B";
			//System.out.println("등급은 B입니다");
		}
		else if(avgInt >= 70) {
			grade = "C";
			//System.out.println("등급은 C입니다");
		}
		else if(avgInt >= 60) {
			grade = "D";
			//System.out.println("등급은 D입니다");
		}
		else {
			grade = "낙제";
			//ystem.out.println("등급은 낙제입니다"); 
		}
	system
		System.out.printf("%s 학생은 국어 = %3d점, 영어 = %3d점, 수학 = %3d점입니다. \n" + "총점은 %d점이고 평균(실수평균)은 %.2f점입니다.\n등급은 %s등급입니다. \n ", name, kor, eng, mat, sum, avg, grade );
		//이상 if 조건문
		// %nd : n자리 수를 기준으로 n보다 자리수가 작은 수는 그 차이만큼 공백을 줌
		int avgInt2 = avgInt / 10;
		switch(avgInt2){
		//case 9 : // = if(avgInt == 90)
		case 10 : 
			grade = "A";
			break;
		case 9 : 
			grade = "A";
			break;
		case 8 : 
			grade = "B";
			break;
		case 7 : 
			grade = "C";
			break;
		case 6 : 
			grade = "D";
			break;
		default : 
			grade = "낙제";
			
		}
		
		
	}

}
