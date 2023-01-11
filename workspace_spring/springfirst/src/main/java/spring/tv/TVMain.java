package spring.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		// 기본으로 Object 타입이므로 TV로 형변환 해줄 필요가 있음
		//TV tv = (TV)factory.getBean("tv");
		//tv.powerOn(); 
		//tv.soundUp(5);
		//tv.soundDown(3); 
		//tv.powerOff();
		// TV tv2 = (TV)factory.getBean("tv"); 
		// 기본적으로 scope = singletone으로 설정돼,
		// 스프링도 한번 만들어진 객체를 Main이 끝나기 전까지 공유한다(매번 새로 만든다? -> X)
		// 하지만 scope = prototype으로 설정시 매번 생상자가 생성돼 출력된다.
		// TV tv3 = (TV)factory.getBean("tv"); 
		TV tv2 = (TV)factory.getBean("tv2");
		tv2.powerOn();
		tv2.soundUp(5);
		tv2.soundDown(3); 
		tv2.powerOff();
		//TV tv3 = (TV)factory.getBean("tv3");
		TV tv3 = (TV)factory.getBean("tv3", TV.class);
		tv3.powerOn();
		tv3.soundUp(5);
		tv3.soundDown(3); 
		tv3.powerOff();
	
	}

}
/* 1> inversion of control
 * 2> pojo 클래스 사용 가능 --> #클래스의 재사용성
 * 3> 프로그램 구현 형식 - 자바 디자인 패턴 - 스프링에 내장된 factory pattern + 인터페이스 - ioc
 * 
 * */
