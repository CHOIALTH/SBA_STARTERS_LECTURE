package dao;

public class ConnectionInform {
// ConnectionInform이 PUBLIC이므로 밖에서도 사용 가능
	public final static String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	public final static String JDBC_URL = "jdbc:mariadb://localhost:3306/empdb";
	public final static String USERNAME = "emp";
	public final static String PASSWORD = "emp";
}
