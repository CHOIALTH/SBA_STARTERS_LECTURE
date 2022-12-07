package test;

public class Test2 {

	public static void main(String[] args) {
		// int time = 10000;
		// time변수안에 들어간 10000초는 몇시간 몇분 몇초인가? (xx시간 xx분 xx초입니다.)
		int time = 10000;
		int hour;//60*60 = 3600s
		hour = (time - time % 3600) / 3600;
				//System.out.println(hour);
		int min;//60s
		min = (time % 3600) / 60;
		System.out.println(min);
		int sec;//1s
		sec = ((time % 3600) - (min * 60 ));
		System.out.println(sec);
		
		System.out.printf("%s초는 %s시간 %s분 %s초 입니다.",time, hour, min, sec);
	}

}
