import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.mindrot.jbcrypt.BCrypt;

public class JavaOracleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(					
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./db.txt")));
		) {
			String[] oracleInfo = new String[4];
			String temp;
			int i=0;
			while((temp=br.readLine())!=null)
				oracleInfo[i++] = temp;
			// 드라이버 클래스 로드
			Class.forName(oracleInfo[0]);
			System.out.println("오라클 드라이버 클래스 로드 성공");
			
			// 오라클 접속
			Connection con = DriverManager.getConnection(oracleInfo[1], oracleInfo[2], oracleInfo[3]);
			System.out.println("접속 성공");
			
			
			
			Calendar cal = new GregorianCalendar(1997, 2, 7, 14, 34, 00);
			Date transdate = new Date(cal.getTimeInMillis());
			
			//삽입//PreparedStatement ps = con.prepareStatement("insert into transactions(tCode, pCode, pName, price, amount, tDate, tId) values(?, ?, ?, ?, ?, ?, ?)");
			//수정//PreparedStatement ps = con.prepareStatement("update transactions set pCode=?, pName=?, price=?, amount=?, tDate=?, tId=? where tCode=?");
			//삭제//PreparedStatement ps = con.prepareStatement("delete from transactions where tCode=?");
			
			/* 삽입
			ps.setInt(1, 3);
			ps.setString(2, "p003");
			ps.setString(3, "컴퓨터");
			ps.setInt(4, 1200000);
			ps.setInt(5, 1);
			ps.setDate(6, transdate);
			ps.setString(7, "tester");
			*/			
			/* 수정
			ps.setString(1, "p004");
			ps.setString(2, "소나타");
			ps.setInt(3, 2000000);
			ps.setInt(4, 1);
			ps.setDate(5, transdate);
			ps.setString(6, "tester");
			ps.setInt(7, 1);
			*/
			//ps.setInt(1, 3);
			/* 암호화 삽입
			ps.setInt(1, 4);
			ps.setString(2, "p003");
			ps.setString(3, BCrypt.hashpw("컴퓨터", BCrypt.gensalt()));
			ps.setInt(4, 1200000);
			ps.setInt(5, 1);
			ps.setDate(6, transdate);
			ps.setString(7, "tester");
			int result = ps.executeUpdate();
			*/
			//암호화 내용이 일치하는지 체크 //System.out.println(BCrypt.checkpw("컴퓨터", BCrypt.hashpw("컴퓨터", BCrypt.gensalt()))); 
			
			con.setAutoCommit(false);
			
			PreparedStatement ps = con.prepareStatement("insert into transactions(tCode, pCode, pName, price, amount, tDate, tId) values(?, ?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, 7);
			ps.setString(2, "p003");
			ps.setString(3, "컴퓨터");
			ps.setInt(4, 120000);
			ps.setInt(5, 1);
			ps.setDate(6, transdate);
			ps.setString(7, "tester");
			int result = ps.executeUpdate();
			if(result>0)
				System.out.println(result+"행 삽입하였습니다.");
				//System.out.println(result+"행 삽입하였습니다.");
				//System.out.println("행 "+result+"개를 수정하였습니다.");
				//System.out.println("행 "+result+"개를 삭제하였습니다.");
			else
				System.out.println("조건에 맞는 데이터가 없습니다.");
			
			ps.close();
			
			// 오라클 접속 해제
			con.close();			
		} catch(Exception e) {
			System.out.println("데이터베이스 예외 : "+e.getMessage());
			e.printStackTrace();
		}
	}

}
