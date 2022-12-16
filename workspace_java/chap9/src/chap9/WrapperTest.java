package chap9;

public class WrapperTest {

	public static void main(String[] args) {
		int i = 10;
		System.out.println(Integer.toBinaryString(i));
		// 2진수로 변환
		System.out.println(Integer.toOctalString(i));
		// 8진수로 변환
		System.out.println(Integer.toHexString(i));
		// 16진수로 변환
		
		
		Integer jn = new Integer(10); // 10 정수. 메서드 이용.
		int j = 10; // 10 정수. 연산자 이용.
		System.out.println(jn);
		System.out.println(j);
		// 기존 타입 고수
		
		Integer jn2 = 10;
		int j2 = new Integer(10);
		System.out.println(jn2);
		System.out.println(j2);
		//  auto boxing / auto unboxing 활용 (jdk 1.5부터 추가됨)
		// (jdk 1.9부터 변경된점)에러는 아니라 실행은 되지만.. Integer 생성자 사용 자제를 java에서 권고함. 
		// 취소선? 앞으로 사용하지 말 것을 권고하는 java의 표시. 기존에 구현된 프로젝트 등에서 사용중일 수 있으니 당장 막지 않는다고 보자.
		
	}

}
