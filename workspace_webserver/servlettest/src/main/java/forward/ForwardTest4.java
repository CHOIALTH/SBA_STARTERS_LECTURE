package forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;


@WebServlet("/forward4")
public class ForwardTest4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	ArrayList<MemberDTO> obj = (ArrayList<MemberDTO>)request.getAttribute("memberlist");
	 	
	 	response.setContentType("text/html;charset=utf-8");
	 	PrintWriter out = response.getWriter();
	 	String output = "<ul>";
	 	for(MemberDTO dto : obj) {
	 		output = "<li>" + dto.getId()+":" + dto.getName() + ":" + dto.getPw() + ":" + dto.getIndate() + "</li>" ;
	 	}
	 	output += "</ul>";
	 	out.println(output);
	 	request.removeAttribute("memberlist");//공유할 일이 없을 경우
	}

}
