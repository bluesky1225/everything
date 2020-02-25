package com.pk.db.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.db.domain.Item;
import com.pk.db.domain.Member;

// repository : Bean(스프링이 생성하는 인스턴스)을 자동 생성해주고
// 데이터 관련된 클래스라는 것을 알려주기 위한 어노테이션
@Repository
public class HibernateDao {
	// 하이버네이트를 사용할 수 있는 인스턴스를 주입
	@Autowired
	private SessionFactory sessionFactory;
	
	// 전체 데이터 가져오는 메소드
	public List<Item> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Item.class).list();
	}
	
	// 데이터 하나를 가져오는 메소드
	public Item getOne(int itemid) {
		return sessionFactory.getCurrentSession().get(Item.class, itemid);
	}
	
	// 데이터 1개를 삽입하는 메소드
	public int insertItem(Item item) {
		sessionFactory.getCurrentSession().save(item);
		
		return 1;
	}
	
public Member login(Member member) {	
		
		System.out.println(sessionFactory);
		
		// 하이버네이트는 기본키를 가지고 조회를 함
		// userid가 기본키가 아니라서 SQL을 이용해서 직접 조회
		List<Member> list = (List<Member>)sessionFactory.getCurrentSession()
				.createSQLQuery("select * from member where userid=:userid")
				.addEntity(Member.class).setString("userid", member.getUserid())
				.list();
				
		if(list.size()==0) {
			return null;
		} else {
			return list.get(0);
		}
	}
}
