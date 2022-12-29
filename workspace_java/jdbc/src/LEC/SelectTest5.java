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
		
		st = con.createStatement();//sql저장-전송객체
		//employees 테이블에서 사원명 입력
		//사원명 부서명 도시명
		//만약 부서명, 도시명 null 인 경우 부서명-부서이동중, 도시명-이사중 출력
		
		Scanner key= new Scanner(System.in);
		System.out.print("사원명 : ");
		String name  = "'" + key.next() + "'";
	    String sql = 
	    "select first_name, ifnull(department_name, '부서이동중') as department_name, "
	    + " ifnull(city,'이사중') as city "
	    + "from employees e left outer join departments d on d.department_id = e.department_id"
	    + " left outer join locations l on d.location_id=l.location_id "
	    + " where first_name = " + name;
	
		
		rs = st.executeQuery(sql);
		int line= 0;
		System.out.printf
		("      사원명      부서명          도시명 \n");
		while(rs.next()) {
			++line;
			String first_name = rs.getString("first_name");
			String department_name = rs.getString("department_name");
			String city = rs.getString("city");		
			System.out.printf
			("%d %s %s %s\n",line, first_name, department_name, city);
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
			st.close();	
			con.close();//throws 	SQLEXCRPTION
			}catch(SQLException e) {}
		}

	}

}
