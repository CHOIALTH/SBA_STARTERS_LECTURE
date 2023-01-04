package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestTestServlet")
public class RequestTestServlet extends HttpServlet {

	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath()); // /servlettest
		System.out.println(request.getMethod()); // GET
		System.out.println(request.getRequestURI()); // /sevlettest/RequestTestServlet
		System.out.println(request.getServletPath()); // /RequestTestServlet
		System.out.println(request.getRemoteAddr()); // ip v6 0:0:0:0:0:0:0:1 = ip v4 localhost
		// 이상 요청정보 추출
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		out.println("<h1>hello output</h1>");// 클라이언트 브라우저 출력
		out.println("<h1>안녕 클라이언트 완료</h1>");// 클라이언트 브라우저 출력
		out.println("<script src='" + request.getContextPath() + "/jquery-3.6.1.min.js'></script>");
		// 이상 응답
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
