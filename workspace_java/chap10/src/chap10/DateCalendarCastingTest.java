package chap10;

import java.util.Calendar;
import java.util.Date;

public class DateCalendarCastingTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date calDate = cal.getTime();
		System.out.println(calDate.getClass().getName());
		// Calendar을 Date로 변환 
		
		Date da = new Date();
		cal.setTime(da);
		System.out.println(cal);
		// Date를 Calendar로 변환
	}

}
