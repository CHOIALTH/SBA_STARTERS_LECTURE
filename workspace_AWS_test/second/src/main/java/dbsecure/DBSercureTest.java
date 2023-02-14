package dbsecure;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBSercureTest {

	public static void main(String[] args) {
		StandardPBEStringEncryptor db = new StandardPBEStringEncryptor();
		db.setPassword("1234");
		String driver = db.encrypt("org.mariadb.jdbc.Driver");
		String url = db.encrypt("jdbc:mariadb://finalproject-rds-015.cf5lxagnmssn.ap-southeast-1.rds.amazonaws.com:3306/memberdb");
		String account = db.encrypt("finaladmin");
		String password = db.encrypt("12345678");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(account);
		System.out.println(password);
		
	}

}
