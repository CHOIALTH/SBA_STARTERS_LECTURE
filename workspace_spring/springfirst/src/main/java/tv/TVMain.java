package tv;

public class TVMain {

	public static void main(String[] args) {
		/*
		 * SamsungTV tv = new SamsungTV(); tv.powerOn(); tv.soundUp(5);
		 * tv.soundDown(3); tv.powerOff();
		 */
		/*
		 * LgTV tv = new LgTV(); tv.powerOn(); tv.soundUp(5); tv.soundDown(3);
		 * tv.powerOff();
		 */
		TVFactory factory = new TVFactory();
		TV tv = factory.getTV("삼성");
		tv.powerOn(); 
		tv.soundUp(5);
		tv.soundDown(3); 
		tv.powerOff();
		
	}

}
/*개발자 - 일부 코드 수정시에 같이 따라서 변경 부분 많아진다.. -> 최소화!
 *  인터페이스 공통 기능 명세서 각각 tv들은 공통 메서드 구현
 *  외부 공장으로부터 전달받은 TV객체 사용 - MAIN(객체생성제어권 포기하고.. 이를 factory객체에 전달)
 *  ㄴ 이런 원리를 inversion of control 이라 함. 이는 spring의 기본개념임 
 *   그러나 현재 코드는 spring이 아닌 독립적인 메서드로 구현해본것
 * 스프링 구현시 TVFactory를 없애고 스프링화 할 것
 * */
