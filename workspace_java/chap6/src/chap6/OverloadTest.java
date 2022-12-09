package chap6;

class D{
	int add(int i, int j){
		return i + j; // 정수 + 정수 = 정수
	}
	String add(String i, String j) {
		return i + j; // 문자열결합
	}
	//위 두문장은 형태는 같아 보이지만, 기능은 전혀 다름.
	double add(double i, double j){
		return i + j; // 실수 + 실수 = 실수
	}
	
}


public class OverloadTest {

	public static void main(String[] args) {

	}

}
