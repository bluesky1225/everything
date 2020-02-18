import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectMain2 {

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
				
				List<Dto> list = new ArrayList<Dto>();
				
				while(rs.next()) {
					Dto dto = new Dto(rs.getInt("tCode"), rs.getString("pCode"), rs.getString("pName"), rs.getInt("price"), rs.getInt("amount"), rs.getDate("tDate"), rs.getString("tId"));
					
					list.add(dto);
				}
				System.out.println("번호\t상품번호\t상품명\t가격\t수량\t거래날짜\t\t거래아이디");
				for(Dto tempDto: list) {
					System.out.print(tempDto.gettCode()+"\t");
					System.out.print(tempDto.getpCode()+"\t");
					System.out.print(tempDto.getpName()+"\t");
					System.out.print(tempDto.getPrice()+"\t");
					System.out.print(tempDto.getAmount()+"\t");
					System.out.print(tempDto.gettDate()+"\t");
					System.out.print(tempDto.gettId()+"\n");
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
