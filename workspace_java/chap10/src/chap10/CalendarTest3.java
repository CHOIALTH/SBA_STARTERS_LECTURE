package chap10;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest3 {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		Calendar end = Calendar.getInstance();// 현재시각
		end.set(2023, 2, 3); // 2023년도 3월 3일
		//오늘부터 교육마지막날(22.03.03)까지 몇일 남았는지 계산해볼것
		
		long nowmil = now.getTimeInMillis();
		long endmil = end.getTimeInMillis();
		// 1/1000초 단위
		System.out.println(endmil - nowmil + "((1/1000)초단위)");
		System.out.println(nowmil - endmil + "((1/1000)초단위)");//음수출력됨.
		System.out.println(Math.abs(nowmil - endmil) + "((1/1000)초단위)");
		// 음수출력되는 것을 Math.abs 씌우면 절대값 .. 양수 출력된다.
		System.out.println(Math.abs(nowmil - endmil)/1000 + "(초단위)");
		System.out.println(Math.abs(nowmil - endmil)/1000/60 + "(분단위)");
		System.out.println(Math.abs(nowmil - endmil)/1000/3600 + "(시간단위)");
		System.out.println(Math.abs(nowmil - endmil)/1000/3600/24 + "(일단위)");
		
		//월 단위로 치환? 월마다 일수 차이가 다르다.
	}

}
