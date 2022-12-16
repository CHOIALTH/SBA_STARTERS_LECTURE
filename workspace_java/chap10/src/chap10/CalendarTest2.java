package chap10;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest2 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();// 현재시각
		cal.set(2022, 11,17);
		System.out.println(cal);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int date = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(date);
		final String weekdays[] = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		// 0 - ? 1 - 일 2 - 월 3 - 화 4 - 수 5 - 목 6 - 금 7 - 토

		
		System.out.printf("현재 시각은 %d년 %d월 %d일 %s요일 %d시 %d분 %d초 입니다.\n", year, month, day, weekdays[date - 1], hour, min, sec);
	}

}
