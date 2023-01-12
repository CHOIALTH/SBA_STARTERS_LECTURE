package anno.memberservice;
// 인터페이스 위에는 @(어노테이션) 붙이지 X : 인터페이스는 객체를 생성하지 못하니까
public interface MemberService {
	// 기능 위주 메서드 선언
	void registerMember();
}
