package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import jdbc.ConnectionInform;

public class MonthEmployee {
	
	ArrayList getEmployees() throws ClassNotFoundException, SQLException{
		// 모든 내용 들어가야 할 곳
		// 키보드 월 입력
		ArrayList<String> list = new MonthEmployee().getEmployees();
		// ㄴ 미리 제너릭 선언으로 String 타입만 받도록..
		System.out.println("입사월\t 급여총합");
		
		Scanner key = new Scanner(System.in);
		System.out.println("제외할 월 : ");
		int inputmonth = key.nextInt();
		
		// select 입사월, 급여총합 from employees group by month(hire_date)
		String sql = "select substr(hire_date, 6, 2) 입사월, sum(salary) 급여총합" 
				+ "from employees\r\n"
				+ "where date_format(hire_date, '%m') != ?"
				+ "group by month(hire_date)"
				+ "order by 입사월";
		// jdbc 전송결과
		Class.forName(ConnectionInform.DRIVER_CLASS);
		Connection con = DriverManager.getConnection(ConnectionInform.JDBC_URL,ConnectionInform.USERNAME, 		ConnectionInform.PASSWORD);
		PreparedStatement pt = con.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();
		while(rs.next()) {
			int outputmonth = rs.getInt();
			
		}
		// jdbc는 연결 잘 끊어줘야..
		// 연결개수를 최소한으로 유지하는게 더 좋기때문
		}
	 	
	public static void main(String[] args) {
		new MonthEmployee().getEmployees();
		/* 키보드입력
		 * 
		 * 제외할 월 : 3 
		 * 01-12 사이의 값 입력 (03.. 3월 제외)시 월별 입사자 총급여 조회
		 * 입사월 급여총합
		 * 01   xxx
		 * 02   xxx
		 * 04   xxx
		 * ...
		 * 12   xxx
		 * */
		
	}

}
