package member_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LEC.ConnectionInform;



public class MemberDAO {
	int insertMember(MemberDTO dto) {
		int count = 0;
		Connection con = null;
		PreparedStatement pt = null;
		
		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con = DriverManager.getConnection
			(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);	
			String sql = "insert into member values()";
			pt = con.prepareStatement(sql);
			pt.setString(1, dto.getId());
			pt.setString(2, dto.getPw());
			pt.setString(3, dto.getName());
			pt.setString(4, dto.getPhone());
			pt.setString(5, dto.getEmail());
			pt.setString(6, dto.getAddress());
 		    count = pt.executeUpdate();
		} catch (Exception e) {
		}finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {}
		}
		return count; 
		// dto 전달 내용을 member 테이블 입력
		// 회원가입일 now() 설정
	} // 이상 insert
	
	int getTotalMember() {
		
	}
	

}
