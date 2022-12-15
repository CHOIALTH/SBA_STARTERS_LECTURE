package chap9;

import java.util.StringJoiner;

public class JoinTest {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		String arr2[] = new String[arr.length];
		/*
		 * for(int i = 0; i < arr.length; i++){ System.out.print(arr[i] + "."); }// for
		 * end System.out.println();
		 */
		for(int i = 0; i < arr.length; i++){
			arr2[i] = String.valueOf(arr[i]);
			// arr의 int 원소를 바로 string을 넣을 수 없으므로
			// int -> String : String.valueOf(1) 활용
			// String -> int : Integer.parseInt("")
		}
		System.out.println(String.join("-" , arr2));
		// 1-2-3-4-5-6 출력
		
		// StringJoiner sj = new StringJoiner("-");
		StringJoiner sj = new StringJoiner("-", "(", ")");
		// StringJoiner에선 시작과 끝에도 설정을 줄 수 있음. String에서는 안됨.
		for(int i = 0 ; i < arr.length; i++) {
			sj.add(String.valueOf(arr[i]));
			// add는 StringJoiner에 내장된 메서드
		}
		System.out.println(sj.toString());
		// sj 정상 출력 위해 .toString 붙여줘야함..
	}

}
