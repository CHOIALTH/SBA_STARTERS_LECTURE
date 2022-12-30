package member_crud;

import java.util.Scanner;

import member_crud.MemberDTO;

public class MemberSelectView implements View {
	public void input( ) {
		
		//MemberDAO 메소드 호출
		//MemberDTO 객체 생성 - 저장
		//키보드 입력 -> DB 저장
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("암호 입력 : ");
		String pw = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("폰번호 입력 : ");
		String phone = sc.next();
		System.out.print("이메일 입력 : ");
		String email = sc.next();
		// now()
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		
		MemberDAO dao = new MemberDAO();
		int result = dao.insertMember(dto);
		System.out.println(result);
	}
}