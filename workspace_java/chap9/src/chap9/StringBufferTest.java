package chap9;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer("초기값");
		StringBuffer sb3 = new StringBuffer(100);
		
		System.out.println("sb1의 용량 = " + sb1.capacity());
		// 16. 저장공간(저장할 수 잇는 크기)이 16개의 공간만큼 존재.
		System.out.println("sb2의 용량 = " + sb2.capacity());
		// 19.
		System.out.println("sb3의 용량 = " + sb3.capacity());
		// 100.
		System.out.println("sb1의 문자열 개수 = " + sb1.length());
		System.out.println("sb2의 문자열 개수 = " + sb2.length());
		System.out.println("sb3의 문자열 개수 = " + sb3.length());
		sb2.append("추가한값");		
		sb2.append("추가한값");		
		sb2.append("추가한값");		
		sb2.append("추가한값");		
		sb2.append("추가한값");		
		System.out.println("sb2의 문자열 개수 = " + sb2.length());

		System.out.println("문자열 추가('추가한값' 5번) 후 sb2의 용량 = " + sb2.capacity());
		
		sb2.delete(0, 10);
		System.out.println("문자열 삭제 후 sb2의 용량 = " + sb2.capacity());
		// delete 해도 capacity는 변하지 x? 
		System.out.println("삭제 후 sb2의 문자열 개수 = " + sb2.length());
		
		System.out.println(sb2.reverse());


		/*
		 * String s2 = new String("초기값"); System.out.println(s2.length());
		 * System.out.println(s2 + "추가한값"); System.out.println(s2.length());
		 */
	}

}
