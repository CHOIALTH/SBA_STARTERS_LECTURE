package aop2;

import org.springframework.stereotype.Component;

@Component
public class Member {
// target으로 사용될..
	void login(String id) {
		System.out.println(id + "회원님 로그인하셨습니다.");
	}
	public void logout() {
		System.out.println("회원님 로그아웃하셨습니다.");
	}
	void insert(String id, int pw) {
		System.out.println(id + ":" + pw + " 로 회원가입하셨습니다");
	}
	
}
