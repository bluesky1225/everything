package sqlmapper;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:mybatis.xml");
		//DataSource ds = context.getBean("dataSource", DataSource.class);
		SqlSession sqlSession = context.getBean("sqlSession", SqlSession.class);
		
		//List<Goods> list = sqlSession.selectList("good.goodsList");
		
		//for(Goods good : list) {
		//	System.out.println(good);
		//}
		
		// 검색
		/*
		Goods good = sqlSession.selectOne("good.agood", 1);
		System.err.println(good);
		
		Goods good1 = sqlSession.selectOne("good.agood", 4);
		System.err.println(good1);
		*/
		
		/*
		// 데이터를 삽입하는 SQL을 호출
		// good.goodinsert 파라미터 타입은 Good
		Goods good = new Goods();
		good.setCode(4);
		good.setName("한우");
		good.setManufacturer("전주");
		good.setPrice(40000);
		
		int result = sqlSession.insert("good.goodinsert", good);
		
		// insert는 1이상이 리턴되면 삽입 성공
		if(result > 0) {
			System.out.println("삽입 성공");
		} else {
			System.err.println("삽입 실패");
		}
		*/
		
		/*
		// 데이터를 수정하는 SQL을 호출
		// good.goodupdate 파라미터 타입은 Good
		Goods good = new Goods();
		good.setCode(3);
		good.setName("참다랑어");
		good.setManufacturer("태평양");
		good.setPrice(2000000);

		int result = sqlSession.update("good.goodupdate", good);

		// update는 1이상이 리턴되면 수정된 데이터가 있음
		// 0이 리턴되면 조건에 맞는 데이터가 없음
		// 문제가 생기면 예외 발생
		if(result > 0) {
			System.out.println("수정 성공");
		} else if(result==0) {
			System.err.println("수정할 데이터가 없음");
		}
		*/
		
		// 데이터를 삭제하는 SQL을 호출
		// good.gooddelete 파라미터 타입은 대입되는 변수의 자료형

		int result = sqlSession.delete("good.gooddelete", 4);

		// delete는 1이상이 리턴되면 삭제 성공
		// 0이면 삭제할 데이터가 없는것
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.err.println("삭제할 데이터가 없음");
		}
		
		/*
		try {
			Connection con = ds.getConnection();
			System.out.println(con);
			con.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		context.close();
	}

}
