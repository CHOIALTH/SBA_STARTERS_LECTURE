package chap5;

public class StudentTest {

	public static void main(String[] args) {
		if(args.length < 5) {
			System.out.println("최소 5명의 이름을 입력하셔야 합니다.");
			return;//main중단하겠다
		}
		String names[] = new String[5];
		for(int i = 0; i < names.length; i++) {
			names[i] = args[i] + " 응시자 ";
		}
		int kor [] = new int[names.length]; //names배열의 길이만큼의 길이를 가짐
		for(int i = 0; i < kor.length; i++) {
			kor[i] = (int)(Math.random() * 100) + 1;
		}
		int eng [] = {96, 100, 66, 89, 49};
		int scores[][] = new int[2][names.length];
		scores[0] = kor;
		scores[1] = eng;		
		//입력변수 이름이 홍길동이 있다면, 이 응시자의 국어점수, 영어점수, 합계 출력하시오
		// 현재 : names 배열 --> {"홍길동 응시자 " , }
		//정수평균은 국어 60%, 영어는 40%의 비중으로 집계
		boolean condition = false; //홍길동 찾았는지 결과를 저장하는 변수
		for(int i = 0; i< names.length; i++) {
		//names[i].equals("홍길동 응사자 ")
		//args[i].equals("홍길동")
		//names[i].substring(0, 3).equals("홍길동")
			//System.out.println(names[i] + ":" + kor[i] + ":" + eng[i]);
			System.out.println(names[i] + ":" + scores[0][i] + ":" + scores[1][i]);
			if(names[i].trim().equals("홍길동 응시자")) {
				condition = true;
//				int sum = (int)(kor[i] * 0.6 + eng[i] * 0.4);
				int sum = (int)(scores[0][i] * 0.6 + scores[1][i] * 0.4);
				int avg = sum / 2;
				System.out.println("총점 : " + sum);
				System.out.println("평균 : " + avg);
			
			}//if end
			
		
		}//for end
		
		if(condition == false) {
			System.out.println("그런 이름의 응시자는 없습니다");
		}
		
	}

}
