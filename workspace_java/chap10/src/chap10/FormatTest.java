package chap10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatTest {

	public static void main(String[] args) {
		double d = 3.14 * 10;
		d = 1234.5678;
		d = -12.5678;
		System.out.println(d);
		
		// DecimalFormat df = new DecimalFormat("##.#");
		// DecimalFormat df = new DecimalFormat("##.##");
		// # - 한 자리에 10진수 한칸을 나타냄. 기본설정은 소숫점 등의 마지막자리 0등은 생략.
		// 아래와 같이 0을 사용해 설정해주면 노출됨.
		// DecimalFormat df = new DecimalFormat("##.000");
		// DecimalFormat df = new DecimalFormat("000.000");
		// DecimalFormat df = new DecimalFormat("0##.#0");
		// ㄴjava.lang.IllegalArgumentException 오류 발생
		// DecimalFormat df = new DecimalFormat("000.00");
		// ㄴ정수의경우 표기설정한 자리수가 부족해도 다 출력됨.
		// DecimalFormat df = new DecimalFormat("##.00+;##.00-");
		DecimalFormat df = new DecimalFormat("###,###.00");
		String dStr = df.format(d);
		System.out.println(dStr);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy / MM / dd / DDD / HH-mm-ss E");
		// y-연도 M-월 d-일(월기준 몇번째 일(1~31)) D-일(연도기준 몇번째 일(1~366)) H-24시간 m-분 s-초 E-요일
		Calendar date = Calendar.getInstance();
		String dateStr = sdf.format(date.getTime());
		System.out.println(dateStr);
		
		
		// 명령행매개변수로 데이터 하나를 입력 받음 - 2023 1 2 3 4 5 
		//System.out.printf();
		// 1년 중 몇주(w)째인지 출력
		// 해당월의 몇주째(W)인지 출력
		// 요일(E) 출력
		if(args.length < 6) {
			return;
		}
		int [] argsInt = new int[args.length];
		for(int i = 0; i < args.length; i++) {
			argsInt[i] = Integer.parseInt(args[i]);
		}
		Calendar date2 = Calendar.getInstance();
		date2.set(argsInt[0],argsInt[1],argsInt[2],argsInt[3],argsInt[4],argsInt[5]);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 년도의 w번째 주이고 MM 월의 W번째 주이며 E요일입니다.");
		// Run Configurations - Arguments 에 데이터 넣고 실행! 이때 월은 마찬가지로 배열개념이므로.. 1월=0 ~12월=11 로 대입해야한다.
		System.out.println(sdf2.format(date2.getTime()));
		
		
		
	}

}
