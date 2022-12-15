package chap8;

class MyException extends Exception{
	int error_code;
	MyException(String message, int error_code) {
		super(message);
		// message란 변수는 Exception에 존재하는거라 따로 변수 선언 필요없다.
		this.error_code = error_code;
		// error_code 초기화!
	}
	public int getError_code() {
		return error_code;
	}
	
}

class Subject{
	void search(String input) {
		String [] names = {"spring", "jsp", "servlet", "java"};
		// input 변수가 names 중 1개라도 일치하면 "수강신청 완료!"
		// 일치하는 게 없으면, MyException 의도적으로 발생 
		boolean isSearch = false;
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals(input)) {
				// 연산자는 주소만 비교하므로 여기선 사용 X
				// 일치하지 않는것을 만났는지 여부가 쟁점이므로 !(not) 사용한다.
				isSearch = true;
				break;
			}// if end
		} // for end
		if(isSearch == false) {
			throw new MyException(input + " 과정은 개설 전 입니다.", 404);
			// 404는 우리가 임의로 붙인 에러코드!
		}
		System.out.println("수강신청 완료!");
	}
}

public class MyExceptionTest {
	public static void main(String[] args) {
		try {
			new Subject().search("mariaDB");			
		}catch (MyException e) {
			System.out.println(e.getError_code() + ":" + e.getMessage());
		}
	}
}
