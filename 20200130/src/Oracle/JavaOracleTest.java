package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JavaOracleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 클래스 로드 성공");
			
			// 오라클 접속
			Connection con = DriverManager.getConnection("jdbc:oracle:thing:@211.183.7.61:xe", "user28", "user28");
			System.out.println("접속 성공");
			
			PreparedStatement ps = con.prepareStatement("select * from transactions");
			
			ps.execute();
		
			// 오라클 접속 해제
			con.close();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
