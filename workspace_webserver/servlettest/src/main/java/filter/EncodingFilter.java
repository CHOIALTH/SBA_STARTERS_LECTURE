package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*") // 어떤 Servlet을 대상으로 할지 괄호 안에 적어준다.
public class EncodingFilter extends HttpFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//ServletRequest : 상위클래스 / HttpServletRequest : 상속받은 하위클래스
		System.out.println("filter 시작");
		// 모든 서블릿 실행시(사용자가 url로 요청시)마다 호출하는 서블릿의 이름, 요청클라이언트IP 출력 - 서블릿 doGet/doPost 호출
		String servletname = ((HttpServletRequest)request).getServletPath();
		String clientip = request.getRemoteAddr(); // 0.0.0.0. (local접속시 0으로만 보임)
		System.out.println(clientip + " 컴퓨터가 " + servletname + "을 호출했습니다.");
		
		//서블릿 요청인코딩 변경
		request.setCharacterEncoding("utf-8");
		
		// 요청 - 요청필터 - 처리 - 응답필터 - 응답
		long start = System.currentTimeMillis();
		
		chain.doFilter(request, response); // 다른 필터 먼저 실행. 다른 필터 없으면 서블릿 실행
		long stop = System.currentTimeMillis();
		System.out.println((stop - start) + "실행 소요시간(1/1000초)");
		}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
