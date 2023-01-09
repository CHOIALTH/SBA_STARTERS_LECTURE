package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 받아서 - 분석 - 결과 어떤.. dao, dto, 화면 제공
		String menu = request.getParameter("menu");
		MemberDAO dao = new MemberDAO(); //JSP로 이동해도 사용 가능한 문장이긴 하지만..궁극적으로 자바로 처리하는 것을 최대로 줄이는게 JSP의 목적임
		String jspName = "";
		if(menu == null) {
			menu = "insertform";
		}
		else if(menu.equals("memberlist")) {
			int page = Integer.parseInt(request.getParameter("page"));
			ArrayList<MemberDTO> memberlist = dao.getMemberList(page, 3);
			request.setAttribute("memberlist", memberlist);
			jspName = "member/memberlist.jsp";
			// <jsp:useBean id = "memberlist" class = "java.util.ArrayList" scope = "request">
		}
		else if(menu.equals("member")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			MemberDTO dto = dao.getMember(id,pw);
			request.setAttribute("member", dto);
			jspName = "member/member.jsp";
			
		}
		else if(menu.equals("insertform")) {
			jspName = "member/insert_db.jsp";
		}
		else if(menu.equals("insertprocess")) {
			request.setAttribute("dao", dao);
			//<jsp:bean
			jspName = "member/insertresult.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspName);
		rd.forward(request, response);
		
	}

}
