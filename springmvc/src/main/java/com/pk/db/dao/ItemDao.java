package com.pk.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pk.db.domain.Item;

public interface ItemDao {
	// Item 테이블의 모든 데이터를 가져오는 메소드
	@Select("select * from item")
	public List<Item> getAll();
	// Item 테이블에서 ItemId를 이용해서 데이터를 1개 찾아오는 메소드
	@Select("select * from item where itemid = #{itemid}")
	public Item getOne(int itemid);
	
}
