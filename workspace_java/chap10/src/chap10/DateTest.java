package chap10;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now/*.toString()*/);
		System.out.println(now.getYear()); 
		// 122 출력됨. (1900년을 기준으로 삼기때문에!!) 
		// Deprecated(중요도가 떨어져 더 이상 사용되지 않고 앞으로는 사라지게 될 (컴퓨터 시스템 기능 등)) 메서드.
		// 취소선? 소스 구현상 문제.. 다른 메서드 충돌 여러가지 발생 이후 사용 자제를 권고하는 것. 실행은 된다.
		//Calendar
		
	}

}
