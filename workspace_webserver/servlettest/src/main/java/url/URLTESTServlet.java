package url;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 홈페이지 시작화면. 요청 url --> url 분석(Controller) --> dao, dto 리턴 / 컬렉션 리턴(Model.. 화면에 보여줄 data) ---> 보여줄 화면(View)
@WebServlet("/urltest")
public class URLTESTServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 url 받아오되
		// http://ip.port/sevlettest/board -> @게시물 boardwriting
		// http://ip.port/sevlettest/member -> @회원 forward4
		// http://ip.port/sevlettest/product -> @상품 이페이지는 없습니다 출력하도록!
		String uri = request.getRequestURI();
		String uri_arr[] = uri.split("/");
		String forward_uri = uri_arr[uri_arr.length - 1];
		System.out.println(request.getRequestURI());
		System.out.println(forward_uri);
		if(forward_uri.equals("board")) {
			forward_uri = "boardwriting"; // sessionid 세션정보
		}
		else if(forward_uri.equals("member")){
			forward_uri = "forward4"; // menu=memberlist&page=?
		}
		else {
			System.out.println("이동 url이 없습니다");
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward_uri);
		rd.forward(request, response);
	}

}
