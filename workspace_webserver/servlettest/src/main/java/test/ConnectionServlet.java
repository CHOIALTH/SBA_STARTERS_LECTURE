package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ConnectionInform;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Class.forName(ConnectionInform.DRIVER_CLASS);
			//1.db 연결
			//long start = System.currentTimeMillis(); // 1000분의 1초 단위로 시간을 측정
			
			//for(int i = 1; i <= 10000; i++) {
			//	Connection con = DriverManager.getConnection
			//			(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			//	System.out.println(i + "번째 MariaDB 연결 성공");
			// con.close(); // 메모리 con "즉각" 삭제 아닌 .. 표시
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			
			long start = System.currentTimeMillis(); // 1000분의 1초 단위로 시간을 측정
			for(int i = 1; i <= 10000; i++) {
				Connection con = ds.getConnection();
				System.out.println(i + "번째 MariaDB 연결 성공");
				con.close(); // 메모리 con "즉각" 삭제 아닌 .. 표시
			// 위 주석처리 내용과 같이 실행되지만, 훨씬 빠른 코드다..
			} // for end
			long end = System.currentTimeMillis(); // 1000분의 1초 단위로 시간을 측정
			System.out.println((end - start) + "(1/1000초) 소요");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	} // doGet

} // class
