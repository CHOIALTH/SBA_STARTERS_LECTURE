package chap10;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		/*
		 * Date now = new Date(); System.out.println(now.toString());
		 * System.out.println(now.getYear());
		 */
		// 122 출력됨. (1900년을 기준으로 삼기때문에!!)
		// Deprecated(중요도가 떨어져 더 이상 사용되지 않고 앞으로는 사라지게 될 (컴퓨터 시스템 기능 등)) 메서드.
		// 취소선? 소스 구현상 문제.. 다른 메서드 충돌 여러가지 발생 이후 사용 자제를 권고하는 것. 실행은 된다.

		//Calendar cal = new Calendar();
		// Cannot instantiate the type Calendar 오류 발생. 
		// why? Calendar class is an abstract class! 캘린더 = 추상클래스!

		java.util.Calendar cal = Calendar.getInstance();		
		// 구현 자식클래스를ㄹ 제공 - "한국"
		// static 메서드 - Calendar 객체 생성 리턴 메서드
		// locale(os) 설정 맞는 시간 날짜 생성 클래스 객체 리턴
		System.out.println(cal);
		int today;
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		//  cal.get(Calendar.Year); 은 배열을 담고, 1월은 0 , 12월은 11을 뱉어냄.. 
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		System.out.println("오늘 날짜는 " + year + "년 " + month + "월 " + date + "일 " + hour + "시 " + min + "분 " + sec + "초 입니다.");
	}

}
