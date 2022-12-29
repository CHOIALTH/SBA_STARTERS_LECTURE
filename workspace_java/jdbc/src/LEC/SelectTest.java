package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	
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
		
		Statement st = con.createStatement();//sql저장-전송객체
		
	/*	Scanner key= new Scanner(System.in);
		System.out.print("상품명 : ");
		String p_name  = key.nextLine();
		System.out.print("가격 : ");
		int price  = key.nextInt();
		System.out.print("수량 : ");
		int balance  = key.nextInt();*/
		String sql= 
		"select employee_id, first_name, last_name, salary, hire_date from employees";//107레코드*11컬럼
		ResultSet rs = st.executeQuery(sql);
		System.out.println("삽입행의 갯수=" + rs); //rs.toString()
		int line= 0;
		while(rs.next()) {
			++line;
			int id = rs.getInt(1);
			String name = rs.getString(2) + "-" + rs.getString(3);
			double salary = rs.getDouble("salary");
			java.sql.Date d = rs.getDate("hire_date");
			String d2 = rs.getString("hire_date");//2002-06-07 00:00:00
			System.out.printf
			("%d 사번:%d 이름:%s 급여:%.2f 입사일:%s \n", line , id, name, salary, d);
		}
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
