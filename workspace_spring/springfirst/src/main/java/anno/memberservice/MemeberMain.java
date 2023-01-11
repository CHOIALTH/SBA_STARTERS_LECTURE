package anno.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemeberMain {

	public static void main(String[] args) {
		ApplicationContext factory
			= new ClassPathXmlApplicationContext("memberservice/member.xml");
		MemberService service = factory.getBean("service", MemberBasicService.class);
		service.registerMember();
	}

}
