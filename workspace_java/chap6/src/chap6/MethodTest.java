package chap6;

import java.util.Arrays;

class B{
	int m1(){
		int local = 10;
		return local * 10;
	}
	int m2(int param){
		return param * 10;
	}
	String m3(int param1, int param2){
		return param1 * param2 + " 결과를 리턴합니다.";
	}
//	int[] m4(int[] ar){
//		int[] result = new int [ar.length];
//		//매개변수로 배열 ar을 전달받음.
//		for(int i = 0; i < ar.length; i++) {
//			result[i] = ar[i] * 10;
//		}
//		return result;
//	}
//	void m4(int[] ar){
//		//ar배열 각 요소에 * 10 배열 저장 리턴
//		for(int i = 0; i < ar.length; i++) {
//			result[i] = ar[i] * 10;
//			
//		}
//		return result;
//		
//		int[] result = new int [ar.length];
//		//매개변수로 배열 ar을 전달받음.
//		for(int i = 0; i < ar.length; i++) {
//		}
//	}
	void m5(){
		System.out.println("B클래스에서 메소드를 테스트합니다.");
		//return문 있어도 없어도 출력됨.
	}
	
}

public class MethodTest {

	public static void main(String[] args) {
		B b1 = new B();
		//B의 복사본 만듦
		int result1 = b1.m1();              
		System.out.println(result1); //결과 고정.
		System.out.println(b1.m2(5)); // 전달해주는 데이터에 따라 다른 결과 도출.
		System.out.println(b1.m3(11,10));
		System.out.println(b1.m3(6,7));
		int main_ar [] = {10,20,45,1,99};
//		int[] main_result = b1.m4(main_ar);                                          
		//import java.util.Arrays; source탭 - Organize imports 누르면 알아서 import문 입력 단축키 : Ctrl + Shift + O
//		System.out.println(Arrays.toString(main_result));
		b1.m5();
	}

}
