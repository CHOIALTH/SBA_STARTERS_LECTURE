package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
			// 0. jdbc driver 호출 - jdk비포함
			// 1. db 연결
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con = DriverManager.getConnection 
			(ConnectionInform.JDBC_URL,ConnectionInform.USERNAME,ConnectionInform.PASSWORD);
			// con 선언은 위에서 했으니, 앞에 Connection 붙이지X
			System.out.println("연결 성공");
			System.out.println(con.getAutoCommit());
			// SQL 전송 결과 검색 - SELECT * FROM EMP 예외발생... 중단
			Statement st = con.createStatement();
			
			
			Scanner key = new Scanner(System.in);
			System.out.print("상품명 : ");
			String p_name = key.nextLine();
			System.out.print("가격 : ");
			int price = key.nextInt();
			System.out.print("수량 : ");
			int balance = key.nextInt();
			
			String sql = "INSERT INTO product(p_name, price, balance)"
					+ "VALUES("+p_name + "," + price + "," + balance + ")";
			
			int rowcount = st.executeUpdate(sql);
			
			System.out.println("삽입행의 개수" + rowcount);
			
			con.close(); 
			System.out.println("연결 해제 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버 발견되지 않았음");
			
		}catch (SQLException e) {
			System.out.println("연결 정보를 확인하세여");
		}finally {
			try {
				con.close(); // throws SQLEXCEPTION
			} catch (SQLException e) {
			}
		}
		
	}

}
