package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest3 {
	
	public static void main(String[] args) {
		Connection con = null;
		Statement st= null;
		ResultSet rs = null;
		try {
		Class.forName(ConnectionInform.DRIVER_CLASS);
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		System.out.println("연결 성공");
		System.out.println(con.getAutoCommit());
		
		st = con.createStatement();//sql저장-전송객체
		//jdbc sql - create table(ddl 가능-권고x)
		/*String sql = "create table maxtest(a int)";
        int rowcount = st.executeUpdate(sql); 
        System.out.println(rowcount);*/
		
		String sql = "select max(a) from maxtest";
		rs = st.executeQuery(sql);// rs 이전위치
		rs.next();// 실행.true
		if(rs.getString("max(a)") != null) {
		System.out.println("최대값="+rs.getString("max(a)"));
		}
		else {
			System.out.println("최대값=0");
		}
		System.out.println("연결 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");//?????
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			//rs.close();	
			st.close();	
			con.close();//throws 	SQLEXCRPTION
			}catch(SQLException e) {}
		}

	}

}
