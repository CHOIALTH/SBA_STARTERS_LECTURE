package chap5;

public class ArrayTest {

	public static void main(String[] args) {
		int []ar;
		//사용자 입력값에 따라
		ar = new int[5];
		System.out.println("ar배열의 길이 = " + ar.length);
		System.out.println("정수배열의 자동 초기화값");
		for(int i = 0; i < 5; i++) {
			System.out.print(ar[i] + " - ");
		}
//		for(int i = 0; i <= 5; i++) {
//			System.out.print(ar[i] + " - ");
//		}
		// 실행시 java.lang.ArrayIndexOutOfBoundsException 오류 발생. 5번 인덱스가 없어서 발생하는 것 
		System.out.println("\n"); 
		//System.out.println();
		
		System.out.println("정수배열의 사용자 저장 값");
		for(int i = 0; i < 5; i++) {
			ar[i] = (i + 1)*10;
			ar[i] = (int)(Math.random() * 50) + 1; //1~50 난수
			System.out.print(ar[i] + " - ");
		}
		System.out.println();
		int min = 1000;
		//min 값은 배열 조건 살펴봐서 나올 수 없는 큰값으로 임의로 준다.
		//ar[23, 49, 50, 1, 5] 로 배열원소에 난수가 담길때 
		//첫 원소부터 min 과 비교해서 min보다 더 작을시 min의 값을 그 원소의값으로 대체
		//마지막 원소가 min과 비교해서 더 작을시 값 대체하지 않고 멈춤
	}

}
