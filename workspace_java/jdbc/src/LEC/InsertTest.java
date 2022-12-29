package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {
	
	public static void main(String[] args) {
		Connection con = null;
		try {
		//0. jdbc driver 호출-jdk비포함
		Class.forName(ConnectionInform.DRIVER_CLASS);
		//1.db 연결
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		System.out.println("연결 성공");
		System.out.println(con.getAutoCommit());
		
		//emp_copy--> 100 길동 홍 1000 now() 50
		//String sql= "insert into  employees values(400, '길동' , '홍', 1000, now(), 50)";
		//select length('가')
		
		Scanner key= new Scanner(System.in);
		System.out.print("상품명 : ");
		String p_name  = key.nextLine();
		System.out.print("가격 : ");
		int price  = key.nextInt();
		System.out.print("수량 : ");
		int balance  = key.nextInt();
	/*	String sql= "INSERT INTO product(p_name, price, balance)"
				+ " VALUES('" + p_name + "'," + price + "," + balance + ")";
		Statement st = con.createStatement();//sql저장-전송객체
		int rowcount = st.executeUpdate(sql);
	*/
		String sql= "INSERT INTO product(p_name, price, balance) VALUES(?,?,?)";
		PreparedStatement pt = con.prepareStatement(sql);//sql저장-전송-컴파일-저장
		pt.setString(1, p_name);
		pt.setInt(2,  price);
		pt.setInt(3,  balance);
		int rowcount = pt.executeUpdate();
		
		System.out.println("삽입행의 갯수=" + rowcount);
	
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
