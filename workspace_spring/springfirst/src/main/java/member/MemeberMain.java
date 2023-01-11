package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemeberMain {

	public static void main(String[] args) {
		ApplicationContext factory
			= new ClassPathXmlApplicationContext("member/member.xml");
		MemberDAO dao = factory.getBean("dao", MemberDAO.class);
		boolean isLogin = dao.selectMember();
		if(isLogin) { // true 라면
			System.out.println(dao.dto.getId() + " 회원님 정상 로그인되었습니다");
		}
		else{
			dao.insertMember();
		}
	}

}
