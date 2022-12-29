package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {
	
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
		
		//product 테이블에서 가격 10000 이상 제품만 조회
		
		
		String sql= "SELECT USER_ID, ADDRESS FROM USER_INFO WHERE ADDRESS LIKE \"%용산구%\" ";
		// user_info 테이블에서 용산구 주소를 가진 사용자 아이디, 주소 조회
		rs = st.executeQuery(sql);
		System.out.println("삽입행의 갯수=" + rs); //rs.toString()
		int line= 0;
		while(rs.next()) {
			++line;
			String id = rs.getString("USER_ID");
			String ADDRESS = rs.getString("ADDRESS");

			System.out.printf
			("%d. 사용자ID = %s, 사용자 주소 = %s\n", line , id, ADDRESS);
		}
		/*
		 * while(rs.next()) { ++line; int id = rs.getInt("p_code"); String name =
		 * rs.getString("p_name"); double price = rs.getDouble("price"); int balance =
		 * rs.getInt("balance"); System.out.printf
		 * ("%d 상품코드:%d 상품이름:%s 가격:%.2f 수량:%d \n", line , id, name, price, balance); }
		 */
		//con.close();
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
