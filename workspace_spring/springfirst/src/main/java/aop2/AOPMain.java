package aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("aop2/aop1.xml");
		Member m = factory.getBean("member", Member.class);
		System.out.println("=================================");
		m.insert("spring", 1111);
		System.out.println("=================================");
		m.login("spring");
		System.out.println("=================================");
		m.logout();
		System.out.println("=================================");
		
		Board b = factory.getBean("board", Board.class);
		System.out.println("=================================");
		b.insert(1);
		System.out.println("=================================");
		b.getList();
	}

}
