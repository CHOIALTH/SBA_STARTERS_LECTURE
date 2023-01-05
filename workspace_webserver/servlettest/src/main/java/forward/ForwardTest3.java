package forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/forward3")
public class ForwardTest3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward3?memberlist&page=페이지번호
		// forward3?menu=login
		
		String menu = request.getParameter("menu");
		
		if(menu.equals("memberlist")) {
			response.setContentType("text/html;charset=utf-8"); 
			PrintWriter out = response.getWriter(); 
			out.println("<h1>멤버리스트입니다</h1>");
			// MemberDAO 객체생성
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> list = 
			dao.getMemberList(Integer.parseInt(request.getParameter("page")),4);
			// 한페이지당 출력 멤버수 = 4
			// getMemberList 호출 -> 결과 하나 받아옴(리턴)
			// forward4로 속성 전달
			// forward4로 이동
			RequestDispatcher dis = request.getRequestDispatcher("/forward4"); // "웹어플리케이션명포함"
			request.setAttribute("memberlist", list);
			dis.forward(request, response);
		}
	}

}
