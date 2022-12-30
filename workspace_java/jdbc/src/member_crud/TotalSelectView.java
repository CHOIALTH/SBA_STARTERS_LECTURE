package member_crud;

import java.util.ArrayList;
import java.util.Scanner;

import member_crud.MemberDTO;

public class TotalSelectView implements View {
	@Override
	public void input() {
		
		Scanner key = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		int total = dao.getTotalMember();
		int pagenum = 0;
		if( total % 3 == 0) {
			pagenum = total / 3;
		}
		else {
			pagenum = total / 3 + 1;
		}
		System.out.println("1 - " + pagenum + " 페이지까지 입력 가능합니다.");
		System.out.println("페이지번호 입력 : ");
		int currentpage = key.nextInt();
		ArrayList<MemberDTO> list = dao.getMemberList(currentpage);
		// 10명 저장 / 1페이지 3명
		// member 테이블 전체데이터개수 조회
		// select count(*) from member
		// 1-3 
		

	}
}