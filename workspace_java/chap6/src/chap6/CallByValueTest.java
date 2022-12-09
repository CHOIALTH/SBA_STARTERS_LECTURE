package chap6;

class Data{
	int k = 10;
	
}

class C{
	void add(int i) {//기본형 매개변수 = 입력변수
		System.out.println(i++);
	}
	void addData(Data d) {//참조형 매개변수
		System.out.println(d.k++);
	}
}

public class CallByValueTest {
	public static void main(String[] args) {
		C c1 = new C();
		int j = 10;
		c1.add(j); // 인수 = 실제로 매개변수 전달값
		System.out.println("main에서 add종료 후 j = " + j);
		//주석3줄 : 기본형 변수 전달 테스트 코드
		Data main_d = new Data();
		c1.addData(main_d);
		System.out.println("main에서 add종료 후 main_d = " + main_d.k );
		//이상 참조형 변수 전달 테스트 코드
	}

}
