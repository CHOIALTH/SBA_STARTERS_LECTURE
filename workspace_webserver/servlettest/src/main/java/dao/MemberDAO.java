package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MemberDTO;

public class MemberDAO {
	int insertMember(MemberDTO dto) {
		Connection con= null;
		PreparedStatement pt = null;
		int count = 0;
		MemberDTO selecteddto = getMember(dto.getId(), dto.getPw());//연결 - 해제
		if(selecteddto != null) {
			System.out.println("아이디 중복입니다. 다른 아이디를 입력하세요");
			return 0;//메소드 중단
		}
		
		try {
		Class.forName(ConnectionInform.DRIVER_CLASS);
		//1.db 연결
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		/*
		 * MemberDTO dto = getMember(id, pw)
		 * dto == null --> 정상 insert
		 * dto != null --> "아이디 중복입니다. 다른 아이디를 입력하세요"
		*/
		
		String sql = "insert into member values(?,?,?,?,?,?, now())";
		pt = con.prepareStatement(sql);
		pt.setString(1, dto.getId());
		pt.setString(2, dto.getPw());
		pt.setString(3, dto.getName());
		pt.setString(4, dto.getPhone());
		pt.setString(5, dto.getEmail());
		pt.setString(6, dto.getAddress());
		count =  pt.executeUpdate();
		//dto 전달 내용을 member 테이블 입력
		//회원가입일 now() 설정 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pt.close();
				con.close();
			}catch(Exception e) {}
		}
		return count;
	}//insertMember end
	int getTotalMember() {
		Connection con= null;
		PreparedStatement pt = null;
		int count = 0;
		try {
		Class.forName(ConnectionInform.DRIVER_CLASS);
		//1.db 연결
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		String sql = "select count(*) from member";//1행 1열(null / 숫자)
		pt = con.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();
		rs.next();
		if(rs.getString("count(*)") == null) {
			count = 0;
		}
		else {
			count =  rs.getInt("count(*)");
		}
		//dto 전달 내용을 member 테이블 입력
		//회원가입일 now() 설정 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pt.close();
				con.close();
			}catch(Exception e) {}
		}
		return count;
	}//getTotal	
	
	ArrayList<MemberDTO> getMemberList(int page, int memberPerPage) {
		ArrayList<MemberDTO> list = new ArrayList();
		Connection con= null;
		PreparedStatement pt = null;
		int count = 0;
		try {
		Class.forName(ConnectionInform.DRIVER_CLASS);
		//1.db 연결
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		String sql = 
		"SELECT id, insert(pw, 2, char_length(pw)-1, repEAT(\"*\",char_length(pw)-1 ) ) as pw, "
		+ " name, indate FROM MEMBER ORDER BY INDATE LIMIT ?, ?";//1행 1열(null / 숫자)
		pt = con.prepareStatement(sql);
		pt.setInt(1,  (page-1) * memberPerPage);// page=1,2, 3   0,3, 6인덱스 
		pt.setInt(2, memberPerPage );
		ResultSet rs = pt.executeQuery();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO
					(rs.getString("id"), rs.getString("name"),rs.getString("indate") );	
			dto.setPw(rs.getString("pw"));
		  list.add(dto);
		}
		//dto 전달 내용을 member 테이블 입력
		//회원가입일 now() 설정 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pt.close();
				con.close();
			}catch(Exception e) {}
		}
		return list;
	}//getMemberList	
	
	public MemberDTO getMember(String id, String pw) {
		Connection con= null;
		PreparedStatement pt= null;
		MemberDTO dto= null;
		try {
		Class.forName(ConnectionInform.DRIVER_CLASS);
		//1.db 연결
		con = DriverManager.getConnection
		(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
		String sql= "select * from member where id=?";
		//rs.next() true 
		pt = con.prepareStatement(sql);
		pt.setString(1, id);
		ResultSet rs= pt.executeQuery();
		if(rs.next()) {
			String dbpw = rs.getString("pw");
			if(pw.equals(dbpw)) { // id 존재한다면
				dto = new MemberDTO
				(rs.getString("id"), rs.getString("pw"), rs.getString("name"),
				rs.getString("email") , rs.getString("phone"),
				rs.getString("address"), rs.getString("indate"));	
			}
			else { // id 존재하고 암호 불일치
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				System.out.println("암호 맞지 않습니다. 4번 입력하세요");
			}
		}
		else { // id, pw 모두 없을때
			System.out.println("1번 회원가입부터 하세요");
		}
		//id 일치하면 pw  일치하면 - 정보 저장 리턴
		// id 일치하면 pw  불일치하면 - "4번 암호 맞지 않습니다"(id만 저장)
		// id 불일치하면 - "1번 회원가입부터 하세요"(dto  null)

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pt.close();
				con.close();
			}catch(Exception e) {}
		}
		return dto;
	}//getMember
}
