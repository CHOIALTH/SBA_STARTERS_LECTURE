package anno.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemeberMain {

	public static void main(String[] args) {
		ApplicationContext factory
			= new ClassPathXmlApplicationContext("anno/memberservice/member.xml");
		MemberService service = factory.getBean("service1", MemberJanService.class); // 이름이 service인 것
		service.registerMember();
	}

}
