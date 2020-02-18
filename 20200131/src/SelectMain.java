import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

public class SelectMain {

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

				PreparedStatement ps = con.prepareStatement("select * from transactions");

				ResultSet rs = ps.executeQuery();
				
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					
					map.put("num", rs.getInt("tCode"));
					map.put("itemcode", rs.getString("pCode"));
					map.put("itemname", rs.getString("pName"));
					map.put("price", rs.getInt("price"));
					map.put("cnt", rs.getInt("amount"));
					map.put("transdate", rs.getDate("tDate"));
					map.put("userid", rs.getString("tId"));
					list.add(map);
				}
				
				for(Map<String, Object> tempMap: list) {
					System.out.print(tempMap.get("num"));
					System.out.print(tempMap.get("itemcode"));
					System.out.print(tempMap.get("itemname"));
					System.out.print(tempMap.get("price"));
					System.out.print(tempMap.get("cnt"));
					System.out.print(tempMap.get("transdate"));
					System.out.print(tempMap.get("userid")+"\n");
				}
				ps.close();
				
				// 오라클 접속 해제
				con.close();	
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
