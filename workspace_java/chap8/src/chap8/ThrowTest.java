package chap8;

class Test2{
	void m1(int i ) throws NumberFormatException {
		// 전달받은 i가 소수일때만 취급하겠다
		// 소수의 정의 - 1과 자기 자신의 수로만 나누어지는(나머지가 0인경우) 자연수
		// 1~자신의 수까지 나머지 0인 경우 2개(1로나눈경우, 자신의 수로 나눈경우) 나올 시 소수!
		
		if(i < 0) {
			//throw new NumberFormatException(); 
			// 음수인경우, 내가 원하는 숫자 format이 아니므로 강제로 NumberFormatException
			// 예외발생 - 중단
			throw new NumberFormatException("자연수만 가능하고, 음수는 안됩니다."); 
			// system.out.println(e.getMessage()); 와 같이 사용하면, 위 "" 내의 문장이 오류 발생시 출력된다.

		}
		
		int count = 0;
		for(int index = 1; index <= i; index++ ) {
			if(i % index == 0) {
				// index가 1이거나 i랑 같은 경우 소수
				count++;
			}// if-조건문 end
		}// for end
		if(count == 2) {
			System.out.println(i + "는 소수이다");
		}
		else {
			System.out.println(i + "는 소수가 아니다");
		}// if-else 조건문 end
	}
}

public class ThrowTest {

	public static void main(String[] args) {
		try {
			Test2 t2 = new Test2();
			t2.m1(13);
			t2.m1(14);
			t2.m1(-13); 
			// 음수.. 예외발생하면, try-catch 블럭이 없으면 예외 중단되고 있으면 try블록 중단하고 catch블록으로 이동	
			// 따라서 다음행은 출력되지 x
			t2.m1(79);
		} catch (NumberFormatException e) {
			// System.out.println("음수여서 오류 발생함");
			System.out.println(e.getMessage());
		}
	}

}
