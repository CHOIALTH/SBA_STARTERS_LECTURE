package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {
	
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
		
		
		Scanner key= new Scanner(System.in);
		System.out.print("수정 사번 : ");
		int employee_id  = key.nextInt();
		System.out.print("수정 이름 : ");
		String name  = key.next();
		System.out.print("인상할 급여 : ");
		double salary  = key.nextDouble();
		
		// 100 최신입 10000  3가지 입력
		// emp_copy 테이블에서 사번 100 사원의 이름 신입(나머지) 성 최(1글자) 현재 급에 10000 인상
		// update 테이블명 SET 변경컬럼명=변경값, , ,  WHERE 변경조건식
		/*String first_name = "'" + name.substring(1) + "'";
		String last_name = "'" + name.substring(0, 1) + "'";
		
		Statement st = con.createStatement();//sql저장-전송객체
		String sql= 
		"UPDATE EMP_COPY SET FIRST_NAME = " + first_name + ", LAST_NAME= " + last_name
		+ ", SALARY =salary + " + salary + " WHERE EMPLOYEE_ID=" + employee_id;
		int rowcount = st.executeUpdate(sql);*/
		
		String first_name = name.substring(1);
		String last_name = name.substring(0, 1);
		
		String sql= 
		"UPDATE EMP_COPY SET FIRST_NAME = ?, LAST_NAME= ? ,SALARY =salary + ? "
		 + " WHERE EMPLOYEE_ID=?";
		PreparedStatement pt = con.prepareStatement(sql);//sql저장-전송객체
		pt.setString(1, first_name);
		pt.setString(2,  last_name);
		pt.setDouble(3, salary);
		pt.setInt(4, employee_id);
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
