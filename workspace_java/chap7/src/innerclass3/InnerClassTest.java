package innerclass3;

class Outer {
	void test() {
		class LocalInner{
			int j = 20;
			void mi() {
				System.out.println(j);
			}
		}
	}//test
}//Outer

public class InnerClassTest {

	public static void main(String[] args) {
		//Outer o = new Outer();	
		Outer.Inner inner = new Outer().new Inner();
		System.out.println(new Outer().i);
		System.out.println(inner.j);
		
	}

}
