package test;

public class Test3 {

	public static void main(String[] args) {
		//int books = 100; : 가지고있는 도서의 수
		//int cntOfStu = 12; : 학생의 수
		//12명의 학생에게 xx권을 나누어줍니다. 남은 책은 xx 권입니다(이부분은 남았을때만 출력O 딱 떨어지면 출력 X).
		//System.out.println();
		int books = 144;
		int cntOfStu = 12;
		int share; //몫
		share = books / cntOfStu;
		//System.out.println(share);
		int remainder; //나머지
		remainder = (int)books % cntOfStu;
		//System.out.println(remainder);
		if(remainder != 0) {
			System.out.printf("%s권의 책을 12명의 학생에게 각 %s권씩 나누어줍니다. 남은 책은 %s권입니다.", books, share, remainder);
		}
		else if(remainder == 0) {
			System.out.printf("%s권의 책을 12명의 학생에게 %s권씩 나누어줍니다. 남은 책은 없습니다", books, share, remainder);
		}
	}

}
