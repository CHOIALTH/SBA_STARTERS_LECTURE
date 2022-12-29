package jdbc;
//자바언어 - platform 독립적
//jdbc 프로그램 - db 독립적
//maria db - db 종속적 --> ????
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest4 {
	
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
		
		String sql = "SHOW DATABASES";
		sql = "show tables";
		sql = "describe employees";
		
		rs = st.executeQuery(sql);
		while(rs.next()) {
			System.out.println
			(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3));
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
