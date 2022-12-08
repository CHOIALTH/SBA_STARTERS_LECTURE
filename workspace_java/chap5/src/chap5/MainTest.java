package chap5;

public class MainTest {

	public static void main(String[] args) {
		System.out.println("입력한 변수의 개수 = " + args.length);
		System.out.println("입력한 내용은 다음과 같습니다");
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
//		//입력변수 개수 + 1 크기 배열 생성
//		String userarray[] = new String[args.length + 1];
//		
//		for(int i = 0; i < args.length; i++) {
//			userarray[i] = args[i]; //입력변수를 복사
//			System.out.println(userarray[i]);
//		}
//		System.out.println("==============================");
//		userarray[args.length] = "내가 추가한 문자열";
//		for(int i = 0; i < userarray.length; i++) {			
//			System.out.println(userarray[i]);
//		}
		//100 45 2개를 자바프로그램 String 타입 입력 덧셈
		System.out.println(args[0] + args[1]); //10045
		System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
	}
}


