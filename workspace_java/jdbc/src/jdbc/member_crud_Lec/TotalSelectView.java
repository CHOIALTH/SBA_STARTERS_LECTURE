package member_crud;

import java.util.ArrayList;
import java.util.Scanner;

public class TotalSelectView implements View {

	@Override
	public void input() {
		Scanner key = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		int total = dao.getTotalMember();//10
		int pagenum = 0;
		int memberPerPage= 3;
		if( total % 3 == 0 ) { pagenum = total / memberPerPage;}
		else {pagenum = total / memberPerPage + 1 ; }
		System.out.println("1 - " + pagenum + " 페이지까지 입력 가능합니다.");
		System.out.print("페이지번호 입력 : ");
		int currentpage = key.nextInt();

		ArrayList<MemberDTO> list = dao.getMemberList
				(currentpage,  memberPerPage);
		for(MemberDTO d : list) {
			System.out.println(d);// id, name, indate 
		}
		
	}

}





