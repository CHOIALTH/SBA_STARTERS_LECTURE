package chap8;

public class ExceptionTest {

	public static void main(String[] args) {
		// 2개이상 명령행 매개변수 입력, 정수 변경가능한 값, 0은 아닌 값입력돼야.
		// 100 100 - 예외발생x - 끝 완료
		// 100 - ArrayIndexOutOfBoundsException - 중단
		// 100 0 - ArithmeticException - 중단
		// 백 백 - NumberFormatException - 중단 
		int k = 0;
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			k = i / j;	
			//try중단 - catch 이동 - 순서대로 실행
		}catch (ArithmeticException e) {// 자식 예외처리 우선
			System.out.println("0을 입력하실 수 없습니다.");
		}finally {
			System.out.println("항상 출력됩니다.");
		}
		
		
		/*
			 * catch (Exception e) {// 부모 예외처리 나중에
			 * System.out.println("예외 종류에 상관없이 동일하게 처리함"); }
			 */
		
		
		
		/*catch (ArithmeticException e) {
			System.out.println("0을 입력하실 수 없습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("2개 이상의 값을 입력하셔야 합니다.");
			e.printStackTrace();//오류발생원인추적 출력. 더 자세함
			S.O.P(e.getMessage())//오류발생원인 출력
			
		} catch (NumberFormatException e) {
			System.out.println("정수로 변경 가능한 값을 입력 하셔야 합니다");
		}*/
		
		
		
		System.out.println("나누기결과 = "+ k);
		System.out.println("main 종료");
	}

}
