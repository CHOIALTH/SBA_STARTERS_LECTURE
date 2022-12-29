package jdbc;

public class ConnectionInform {
// ConnectionInform이 PUBLIC이므로 밖에서도 사용 가능
	final static String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	final static String JDBC_URL = "jdbc:mariadb://localhost:3306/empdb";
	final static String USERNAME = "emp";
	final static String PASSWORD = "emp";
}
