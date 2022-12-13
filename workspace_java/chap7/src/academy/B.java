package academy;
import java.util.Date;
import java.util.HashSet;

//import간 순서는 무관
//B클래스 저장 폴더 설정 (첫문장!!!!)
import sba.A;
//A클래스가 어느 패키지에 있는지 알려주는 문장.
//import sba.*;
//sba 패키지 내 모든 클래스 불러옴
/*
 * 1. B클래스 같은 패키지 속한 클래스 자동 import
 * 2. java.lang.패키지 속한 클래스 자동 import
*/

public class B {
	public static void main(String[] args) {
		A a1 = new A();
		//sba.A a1 = new sba.A();
		//sba. 을 붙여 다른 패키지 내에서 불러옴을 인식
		Date now = new Date();
		//라이브러리에서 제공해주는 클래스.. 현재시각을 나타내는 객체 생성
		HashSet set = new HashSet();
		//java.util. 40여개 클래스 내포..
	}
	
	
}
