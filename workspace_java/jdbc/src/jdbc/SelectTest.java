package jdbc;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// import java.util.Scanner;

public class SelectTest {

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
			
			/*Scanner key = new Scanner(System.in);
			System.out.print("수정사번 : ");
			int employee_id = key.nextInt();
			System.out.print("수정 이름 : ");
			String name = key.next();
			System.out.print("인상할 급여 : ");
			double salary = key.nextDouble();*/
			
			// 100 최신입 10000 -> 3가지 정보 입력
			// emp_copy 테이블에서 사번 100 사원의 이름.. 신입(나머지 이름) 성 최(1글자) 현재 급여보다 10000 인상
			// update 테이블명 SET 변경컬럼명 = 변경값 WHERE 변경조건식 

			String sql = 
					"SELECT employee_id, first_name, last_name, salary, hire_date from employees"; // 107레코드 * 11컬럼
			
			//int rowcount = st.executeUpdate(sql); // insert/delete 시 executeUpdate 메서드 사용
			
			ResultSet rs = st.executeQuery(sql); // select
			
			System.out.println("삽입행의 개수 = " + rs); // rs.toString 메서드 호출됨
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2) + "-" + rs.getString(3);
				double salary = rs.getDouble("salary");
				java.sql.Date d = rs.getDate("hire_date");
				String d2 = rs.getString("hire_date");
				System.out.printf("사번 : %d 이름 : %s 급여 : %f 입사일 : %s\n", id, name, salary, d2);
			}
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
