package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

/**
 * Servlet implementation class LoginDBServlet
 */
@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 1. 요청 정보 추출(id, pw)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id == null || pw == null) {
			//응답
			out.println("필요 정보를 모두 입력하세요.");
			out.close();
		}
		
		// 2. 로그인 처리 -jdbc
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id, pw);
		
		// 3. 정상로그인 / 암호 다시 입력 / 회원가입대상 응답
//		dto id, pw 저장상태
//		dto id 저장, pw null
//		dto null
		
		String result = "";
		if(dto != null && dto.getPw() != null) {
			result = "<h1>" + id + " 회원님 정상 로그인 되셨습니다. </h1>";
		}
		else if(dto != null && dto.getPw() == null) {
			result = "<h1>" + id + " 회원님으로서 인증되지 않았습니다. " 
					+ "<a href='login_db.html'>다시로그인하러가기</a></h1>";
		}
		else if(dto == null) {
			result = "<h1>" + id + " 회원가입되지 않았습니다. "
					+ "<a href = 'insert_db.html'>회원가입하러가기</a></h1>";
		}
		
		out.println(result);
	}
}