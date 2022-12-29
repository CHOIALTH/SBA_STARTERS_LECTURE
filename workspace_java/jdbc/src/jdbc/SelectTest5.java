package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest5 {
	
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
		//0. jdbc driver 호출-jdk비포함
		Class.forName(ConnectionInform.DRIVER_CLASS);
		//1.db 연결
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		System.out.println("연결 성공");
		System.out.println(con.getAutoCommit());
		
		st = con.createStatement();//sql저장-전송객체	
		
		// employees 테이블에서 사원명 입력받음
		// 사원명 부서명 도시명
		// 만약 입력한 사원명이 부서명 or 도시명이 null일 경우,  부서명 - "부서이동중" / 도시명 = "이사중" 으로 출력되도록 조회하시오.
		Scanner key = new Scanner(System.in);
		System.out.println("사원명 : ");
		String name = key.next();

		
		
		
		
		String sql = "select max(a) from maxtest";
		rs =st.executeQuery(sql); // rs 이전위치
		rs.next();
		if(rs.getString("max(a)") != null) {
			System.out.println("최대값 = " + rs.getString("max(a)") );
		}
		else {
			System.out.println("최대값 = 0");
		}
		
		/*
		 * if (rs.next()) { System.out.println(rs.getInt("a")); } else {
		 * System.out.println("저장부터하슈"); }
		 */



		System.out.println("연결 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");//?????
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
			con.close();//throws 	SQLEXCRPTION
			}catch(SQLException e) {}
		}

	}

}
