package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {
	
	public static void main(String[] args) {
		Connection con = null;
		Statement st= null;
		ResultSet rs = null;
		try {
		//0. jdbc driver 호출-jdk비포함
		Class.forName(ConnectionInform.DRIVER_CLASS);
		//1.db 연결
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		System.out.println("연결 성공");
		System.out.println(con.getAutoCommit());
		
		// users 테이블에서 용산구 주소를 가진 사용자 아이디, 주소 조회
		String sql = "select user_id, address from users where address like ?";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setString(1, "%"+"용산구"+"%");		
		rs = pt.executeQuery();
		int line= 0;
		while(rs.next()) {
			++line;
			String user_id = rs.getString("user_id");
			String address = rs.getString("address");
			System.out.printf
			("%d 아이디:%s 주소:%s \n", line , user_id, address);
		}
		//con.close();
		System.out.println("연결 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");//?????
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			rs.close();	
			//pt.close();	
			con.close();//throws 	SQLEXCRPTION
			}catch(SQLException e) {}
		}

	}

}
