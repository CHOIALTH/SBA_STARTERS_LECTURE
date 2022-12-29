package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

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
			System.out.println(con.getAutoCommit())  ;
			// SQL 전송 결과 검색 - SELECT * FROM EMP 예외발생... 중단
			Statement st = con.createStatement();
			
			
			Scanner key = new Scanner(System.in);
			System.out.print("수정사번 : ");
			int employee_id = key.nextInt();
			System.out.print("수정 이름 : ");
			String name = key.next();
			System.out.print("인상할 급여 : ");
			double salary = key.nextDouble();
			
			// 100 최신입 10000 -> 3가지 정보 입력
			// emp_copy 테이블에서 사번 100 사원의 이름.. 신입(나머지 이름) 성 최(1글자) 현재 급여보다 10000 인상
			// update 테이블명 SET 변경컬럼명 = 변경값 WHERE 변경조건식 
			String first_name = "'" + name.substring(1) + "'";
			String last_name = "'" + name.substring(0,1) + "'";
			
			String sql = 
					"UPDATE EMP_COPY SET FIRST_NAME = " + first_name + ", LAST_NAME = "
					+ last_name + ", SALARY = salary +" + salary + "WHERE EMPLOYEE_id =" + employee_id;
			
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
