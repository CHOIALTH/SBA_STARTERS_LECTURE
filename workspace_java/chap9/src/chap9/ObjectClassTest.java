package chap9;

public class ObjectClassTest {
	public static void main(String[] args) {
		// Object o1 = new Object();
		// Object o2 = new Object();
		
		MyObject o1 = new MyObject("myobject");
		MyObject o2 = new MyObject("myobject");

	
		// getClass().getName() + '@' +_Integer.toHexString(hashCode())
		// 패키지명.클래스명@16진수(괄호안의 10진수값을 16진수로 변환. 해쉬코드)
		System.out.println(o1.toString());
		// java.lang.Object@58ceff1
		// = System.out.println(o1); o1만 써도 .toString()이 생략된상태로 처리되기 때문. 
		System.out.println(o2.toString());
		// java.lang.Object@7c30a502
		
		System.out.println(o1 == o2);
		// false
		// 주소 동등성 비교로.. 문자 같아도 false 출력. 연산자 overriding 불가능
		System.out.println(o1.equals(o2));
		// false
		// 문자 같으면 false -> true. overriding 가능
		
		String s3 = new String("myobject");
		System.out.println(o1.equals(s3));
		//false가 나와야 정상

	}
}

class MyObject /*extends Object*/{
	String message;
	MyObject(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return message;
	}
	// toString overriding
	// 이걸 함으로써 출력내용이 주소값에서 myobject, my 로 바뀜
	@Override
	/*o1.equals(o2)
	 * o2.message
	 * */
	public boolean equals(Object obj) {
		// 비교 전달받는 객체 obj : MyObject 타입이어야 하고..
		// message변수 값이 같은 지 비교해서, 2개 조건을 모두 만족하면 -> true
		if(obj instanceof MyObject){
			return message.equals(((MyObject)obj).message);
		
		}else{
			return false;
			
		}
			
	}
	// equals overriding
	
	
	// equals + ....Object클래스 결과 동일
}
