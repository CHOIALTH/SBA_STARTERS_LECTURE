package chap9;

import java.util.Arrays;

public class SplitTest {

	public static void main(String[] args) {
		// 대한민국공공정보공개사이트 - 공공포탈api
		//String address = "서울시 용산구 청파동 전자월드 3층 새싹아카데미";
		//String[] result = address.split(" "); 
		//String[] result = address.split("(:;-)");//[0-9]
		//String[] result = address.split("(:|;|-)");//[0-9]
		// 공백을 중심으로 쪼갬. 위 세 줄 모두 같은 결과 출력
		
		String address = "서울시:용산구-청파동;전자월드==3층.새싹?아카데미";
		String[] result = address.split("(:|;|-|==|\\.|\\?)");//[0-9]

		System.out.println(Arrays.toString(result));
	}

}
