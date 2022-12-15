package chap8;

public class ClassInformationTest {

	public static void main(String[] args) {
		//java.lang.Obnject - 존재합니다
		// chap8.A - 존재하지않습니다
		// chap8.CheckedTest - 존재합니다
		
		//Class.forName("클래스명")
		try {
			Class.forName(args[0]);
			//c.getMethods();
			c.getDeclaredFields()
			//System.out.println(args[0] + " - 존재합니다");
		} catch (ClassNotFoundException e) {
			System.out.println(args[0] + " - 존재하지 않습니다");
		}
		/*class Class {
			xxx forName(String name) throws ClassNotFoundException {
				
			}*/
		}
	}

}
