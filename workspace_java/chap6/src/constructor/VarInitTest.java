package constructor;

public class VarInitTest {

	/*
	 * int a; double b; String c;
	 * 
	 * VarInitTest(){ a = 10; b = 10.9; c ="생성자초기화"; }
	 */
	/*
	 * int a = 10; double b = 10.9; String c = "생성자초기화";
	 */
	int a;
	double b;
	String c;
	
	VarInitTest(){
		this.a = a;
		this.b = b;
		c ="생성자초기화"; 
		}
	
	public static void main(String[] args) {
		int d = 0; // 지역변수 자동초기화 안됨. 사용자가 초기화해야.,
		System.out.println(d);
		VarInitTest test = new VarInitTest();
		System.out.printf("a = %d, b = %f, c = %s\n", test.a, test.b, test.c);
	}

}
// static 메서드에서는 static으로 선언된 변수만 사용 가능함.