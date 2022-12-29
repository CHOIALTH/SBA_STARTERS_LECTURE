package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
			// 0. jdbc driver 호출 - jdk비포함
			// 1. db 연결
			Class.forName("org.mariadb.jdbc.Driver");
			DriverManager.getConnection
			("jdbc:mariadb://localhost:3306/empdb", "emp", "emp");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버 발견되지 않았음");
			
		}catch (SQLException e) {
			System.out.println("연결 정보를 확인하세여");
		}
		
	}

}
